package com.employees.users.domain.core.event;

import com.employees.users.domain.core.entity.Employees;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeesUpdateEvent {
    private Employees employees;
    private String message;

    public EmployeesUpdateEvent(Employees employees, String message) {
        this.employees = employees;
        this.message = message;
    }

    public EmployeesUpdateEvent(Employees employees) {
        this.employees = employees;
    }
}
