package com.employees.users.domain.service.mapper;

import com.employees.users.domain.core.entity.Employees;
import com.employees.users.domain.service.create.CreateEmployeesCommand;
import com.employees.users.domain.service.create.CreateEmployeesResponse;
import org.springframework.stereotype.Component;

@Component
public class EmployeesDataMapper {
    public Employees createEmployeesCommandToEmployees(CreateEmployeesCommand employeesCommand){
        return new Employees(
                null,
                employeesCommand.getName(),
                employeesCommand.getSurnames(),
                employeesCommand.getCurp(),
                employeesCommand.getIdPosition(),
                employeesCommand.getIdAddress()
        );
    }

    public CreateEmployeesResponse employeesToCreateEmployeesResponse(Employees employees, String message){
        return new CreateEmployeesResponse(employees.getCurp(), message);
    }

}
