package kovalskiy91.selfdev.jpa.inheritance.tableperclasshierarchy;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByNameAndSurname(String name, String surname);
}
