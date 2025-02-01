package com.employees.users.dataaccess.repository;

import com.employees.users.dataaccess.entity.EmployeesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesJpaRepository extends JpaRepository<EmployeesEntity, String> {
}
