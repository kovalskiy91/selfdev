package kovalskiy91.selfdev.jpa.repository;

import kovalskiy91.selfdev.jpa.entity.FullTimeEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FullTimeEmployeeRepository extends JpaRepository<FullTimeEmployee, Long> {
}
