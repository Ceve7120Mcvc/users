package com.employees.users.domain.service.ports.input.service;

import com.employees.users.domain.service.create.*;

public interface EmployeesApplicationService {
    CreateEmployeesResponse createEmployees(CreateEmployeesCommand createEmployeesCommand);
    CreatePositionResponse createPosition(CreatePositionCommand positionCommand);
    CreateAddressResponse createAddress(CreateAddressCommand addressCommand);

}
