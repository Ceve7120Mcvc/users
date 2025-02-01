package com.employees.users.domain.service.mapper;

import com.employees.users.common.domain.valueonject.AddressId;
import com.employees.users.common.domain.valueonject.PositionId;
import com.employees.users.domain.core.entity.Address;
import com.employees.users.domain.core.entity.Employees;
import com.employees.users.domain.core.entity.Position;
import com.employees.users.domain.service.create.CreateEmployeesCommand;
import com.employees.users.domain.service.create.CreateEmployeesResponse;
import com.employees.users.domain.service.query.QueryEmployeesResponse;
import org.springframework.stereotype.Component;

@Component
public class EmployeesDataMapper {
    public Employees createEmployeesCommandToEmployees(CreateEmployeesCommand employeesCommand){
        Position idPosition = employeesCommand.getIdPosition() != null ? new Position(new PositionId(employeesCommand.getIdPosition())) : null;
        Address idAddress = employeesCommand.getIdAddress() != null ? new Address( new AddressId(employeesCommand.getIdAddress())) : null;
        return new Employees(
                employeesCommand.getName(),
                employeesCommand.getSurnames(),
                employeesCommand.getCurp(),
                idPosition,
                idAddress
        );
    }

    public CreateEmployeesResponse employeesToCreateEmployeesResponse(Employees employees, String message){
        return new CreateEmployeesResponse(employees.getCurp(), message);
    }

   public QueryEmployeesResponse employeesToQueryEmployeesResponse(Employees employees){
        return QueryEmployeesResponse.builder()
                .curp(employees.getCurp())
                .name(employees.getName())
                .idPosition(employees.getIdPosition())
                .idAddress(employees.getIdAddress())
                .build();
   }

}
