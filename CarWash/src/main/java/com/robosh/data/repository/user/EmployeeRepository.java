package com.robosh.data.repository.user;

import com.robosh.data.entity.user.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
