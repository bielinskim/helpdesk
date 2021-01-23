package com.bielinskim.lab.repositories;

import com.bielinskim.lab.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}