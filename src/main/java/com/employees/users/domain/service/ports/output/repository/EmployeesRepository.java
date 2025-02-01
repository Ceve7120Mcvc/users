package com.employees.users.domain.service.ports.output.repository;

import com.employees.users.domain.core.entity.Employees;
import com.employees.users.domain.core.entity.Position;

import java.util.Optional;

public interface EmployeesRepository {
    Employees createEmployees(Employees employees);
    Optional<Employees> findEmployeesByEmployeesId(String  curp);
    Employees employeesUpdate(Employees employees);
}
