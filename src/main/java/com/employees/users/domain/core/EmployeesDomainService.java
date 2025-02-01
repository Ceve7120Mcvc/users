package com.employees.users.domain.core;

import com.employees.users.domain.core.entity.Employees;
import com.employees.users.domain.core.event.EmployeesUpdateEvent;

public interface EmployeesDomainService {
    EmployeesUpdateEvent validateUpdateEmployees(Employees employees, Employees newEmployees);
}
