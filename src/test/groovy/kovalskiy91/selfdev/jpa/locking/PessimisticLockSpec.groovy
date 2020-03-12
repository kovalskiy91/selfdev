package kovalskiy91.selfdev.jpa.locking

import kovalskiy91.selfdev.SelfDevSpec
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.TransactionStatus
import org.springframework.transaction.support.TransactionTemplate

import javax.persistence.EntityManager
import javax.persistence.LockModeType
import java.util.function.Consumer

class PessimisticLockSpec extends SelfDevSpec {

    @Autowired
    private EmployeeRepository employeeRepository
    @Autowired
    private FullTimeEmployeeRepository fullTimeEmployeeRepository;
    @Autowired
    private TransactionTemplate transactionTemplate
    @Autowired
    private EntityManager entityManager

    def NAME = "John"
    def SURNAME = "Doe"

    def employee = new Employee(
            name: NAME,
            surname: SURNAME
    )
    def fullTimeEmployee = new FullTimeEmployee(
            name: NAME,
            surname: SURNAME,
            salary: 1000
    )


    def setup() {
        QueryInterceptor.clean()
    }

    def "should acquire for share lock when selecting with pessimistic read"() {
        given:
        employeeRepository.save(employee)

        when:
        employeeRepository.findByIdAndName(employee.id, NAME)

        then:
        def selectQueries = QueryInterceptor.selectQueries
        selectQueries.size() == 1
        selectQueries.get(0).contains "for share of employee"
    }

    def "should acquire for update lock when selecting with pessimistic write"() {
        given:
        employeeRepository.save(employee)

        when:
        employeeRepository.findByIdAndSurname(employee.id, SURNAME)

        then:
        def selectQueries = QueryInterceptor.selectQueries
        selectQueries.size() == 1
        selectQueries.get(0).contains "for update of employee"
    }

    def "should acquire for share lock for subclass only when selecting with repository and pessimistic read"() {
        given:
        employeeRepository.save(fullTimeEmployee)

        when:
        fullTimeEmployeeRepository.findByIdAndName(fullTimeEmployee.id, NAME)

        then:
        def selectQueries = QueryInterceptor.selectQueries
        selectQueries.size() == 1
        String selectQuery = selectQueries.get(0)
        selectQuery.contains "inner join employee"
        selectQuery.contains "for share of fulltimeem"
    }

    def "should acquire for share lock for class hierarchy when selecting with entity manager and pessimistic read"() {
        given:
        employeeRepository.save(employee)

        when:
        transactionTemplate.executeWithoutResult(new Consumer<TransactionStatus>() {
            @Override
            void accept(TransactionStatus transactionStatus) {
                entityManager.find(FullTimeEmployee, fullTimeEmployee.id, LockModeType.PESSIMISTIC_READ)
            }
        })

        then:
        def selectQueries = QueryInterceptor.selectQueries
        selectQueries.size() == 1
        String selectQuery = selectQueries.get(0)
        selectQuery.contains "inner join employee"
        selectQuery.contains "for share"
    }

}
