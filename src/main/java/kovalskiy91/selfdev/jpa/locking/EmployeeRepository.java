package kovalskiy91.selfdev.jpa.locking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import javax.persistence.LockModeType;
import javax.transaction.Transactional;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Transactional
    @Lock(LockModeType.PESSIMISTIC_READ)
    List<Employee> findByIdAndName(Long id, String name);

    @Transactional
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<Employee> findByIdAndSurname(Long id, String name);

}
