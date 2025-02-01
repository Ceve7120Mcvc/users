package com.employees.users.domain.core;

import com.employees.users.domain.core.entity.Employees;
import com.employees.users.domain.core.event.EmployeesUpdateEvent;

public class EmployeesDomainServiceImpl implements EmployeesDomainService{
    @Override
    public EmployeesUpdateEvent validateUpdateEmployees(Employees employeesReceived, Employees localEmployees) {
        EmployeesUpdateEvent employeesCreateEvent = new EmployeesUpdateEvent(localEmployees, "");
        if (employeesReceived.getCurp() != null){
            localEmployees.setCurp(employeesReceived.getCurp());
        }
        if (employeesReceived.getName() != null){
            localEmployees.setName(employeesReceived.getName());
        }
        if (employeesReceived.getSurnames() != null){
            localEmployees.setIdPosition(employeesReceived.getIdPosition());
        }
        if (employeesReceived.getIdPosition() != null && employeesReceived.getIdPosition().getId().getValue() != null){
            localEmployees.setIdPosition(employeesReceived.getIdPosition());
        }
        if (employeesReceived.getIdAddress() != null && employeesReceived.getIdAddress().getId().getValue() != null){
            localEmployees.setIdAddress(employeesReceived.getIdAddress());
        }
        employeesCreateEvent.setMessage("Success update");
        return employeesCreateEvent;
    }
}
