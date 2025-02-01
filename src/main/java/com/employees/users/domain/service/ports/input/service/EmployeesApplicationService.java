package com.employees.users.domain.service.ports.input.service;

import com.employees.users.domain.service.create.*;
import com.employees.users.domain.service.query.QueryEmployeesResponse;
import com.employees.users.domain.service.update.UpdateEmployeesCommand;

public interface EmployeesApplicationService {
    CreateEmployeesResponse createEmployees(CreateEmployeesCommand createEmployeesCommand) throws Exception;
    QueryEmployeesResponse updateEmployees(UpdateEmployeesCommand employeesCommand);
    CreatePositionResponse createPosition(CreatePositionCommand positionCommand);
    CreateAddressResponse createAddress(CreateAddressCommand addressCommand);

}
