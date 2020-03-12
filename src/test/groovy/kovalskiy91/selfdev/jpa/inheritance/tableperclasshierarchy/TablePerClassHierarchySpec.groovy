package kovalskiy91.selfdev.jpa.inheritance.tableperclasshierarchy

import kovalskiy91.selfdev.SelfDevSpec
import org.springframework.beans.factory.annotation.Autowired

import java.sql.ResultSet

class TablePerClassHierarchySpec extends SelfDevSpec {

    @Autowired
    private EmployeeRepository employeeRepository;

    def "should save full time employee via superclass"() {
        given:
        def fullTimeEmployee = new FullTimeEmployee(
                name: "John",
                surname: "Doe",
                salary: 1000,
        )

        when:
        employeeRepository.save(fullTimeEmployee)

        then:
        def id = fullTimeEmployee.id
        assertEmployeeType(id, "FT_EMP")
    }

    void assertEmployeeType(id, type) {
        sql.query("select type from employee where id = $id", { ResultSet rs ->
            rs.next()
            assert rs.getString("type") == type
        })
    }

    def "should save part time employee via superclass"() {
        given:
        PartTimeEmployee partTimeEmployee = new PartTimeEmployee(
                name: "Jane",
                surname: "Doe",
                hourlyWage: 10,
        )

        when:
        employeeRepository.save(partTimeEmployee)

        then:
        def id = partTimeEmployee.id
        assertEmployeeType(id, "PT_EMP")
    }

}
