package com.springbootpostgres.springpostgres.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootpostgres.springpostgres.domain.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}