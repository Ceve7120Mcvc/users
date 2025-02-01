package com.employees.users.domain.service.ports.output.repository;

import com.employees.users.domain.core.entity.Employees;
import com.employees.users.domain.core.entity.Position;

public interface EmployeesRepository {
    Employees createEmployees(Employees employees);
}
