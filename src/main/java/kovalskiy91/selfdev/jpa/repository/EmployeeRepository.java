package kovalskiy91.selfdev.jpa.repository;

import kovalskiy91.selfdev.jpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
