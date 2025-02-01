package com.employees.users.domain.core.event;

import com.employees.users.common.domain.DomainEvent;
import com.employees.users.domain.core.entity.Employees;

import java.time.ZonedDateTime;

public class EmployeesCreateEvent implements DomainEvent<Employees> {
    private final Employees employees;
    private String message;
    private final ZonedDateTime createdAt;

    public EmployeesCreateEvent(Employees employees, ZonedDateTime createdAt) {
        this.employees = employees;
        this.message = message;
        this.createdAt = createdAt;
    }

    public Employees getEmployees() {
        return employees;
    }

    @Override
    public String getMessage() {
        return "";
    }
}
