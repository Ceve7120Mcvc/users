package com.employees.users.domain;

import com.employees.users.domain.core.event.AddressCreateEvent;
import com.employees.users.domain.core.event.EmployeesCreateEvent;
import com.employees.users.domain.core.event.PositionCreateEvent;
import com.employees.users.domain.service.create.*;
import com.employees.users.domain.service.handler.AddressCreateCommandHandler;
import com.employees.users.domain.service.handler.EmployeesCreateCommandeHandler;
import com.employees.users.domain.service.handler.PositionCreateCommandHandler;
import com.employees.users.domain.service.mapper.AddressDataMapper;
import com.employees.users.domain.service.mapper.EmployeesDataMapper;
import com.employees.users.domain.service.mapper.PositionDataMapper;
import com.employees.users.domain.service.ports.input.service.EmployeesApplicationService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Validated
@Service
public class EmployeesApplicationServiceImpl implements EmployeesApplicationService {
    private final EmployeesCreateCommandeHandler employeesCreateCommandeHandler;
    private final EmployeesDataMapper employeesDataMapper;
    private final PositionCreateCommandHandler positionCreateCommandHandler;
    private final PositionDataMapper positionDataMapper;
    private final AddressCreateCommandHandler addressCreateCommandHandler;
    private final AddressDataMapper addressDataMapper;

    public EmployeesApplicationServiceImpl(EmployeesCreateCommandeHandler employeesCreateCommandeHandler, EmployeesDataMapper employeesDataMapper, PositionCreateCommandHandler positionCreateCommandHandler, PositionDataMapper positionDataMapper, AddressCreateCommandHandler addressCreateCommandHandler, AddressDataMapper addressDataMapper) {
        this.employeesCreateCommandeHandler = employeesCreateCommandeHandler;
        this.employeesDataMapper = employeesDataMapper;
        this.positionCreateCommandHandler = positionCreateCommandHandler;
        this.positionDataMapper = positionDataMapper;
        this.addressCreateCommandHandler = addressCreateCommandHandler;
        this.addressDataMapper = addressDataMapper;
    }

    @Override
    public CreateEmployeesResponse createEmployees(CreateEmployeesCommand createEmployeesCommand) {
        EmployeesCreateEvent employeesCreateEvent = employeesCreateCommandeHandler.createEmployees(createEmployeesCommand);
        return employeesDataMapper.employeesToCreateEmployeesResponse(employeesCreateEvent.getEmployees(), "Users saved successfully!");
    }

    @Override
    public CreatePositionResponse createPosition(CreatePositionCommand positionCommand) {
        PositionCreateEvent event = positionCreateCommandHandler.createPosition(positionCommand);
        return positionDataMapper.positionToCreatePositionResponse(event.getPosition(),event.getMessage());
    }

    @Override
    public CreateAddressResponse createAddress(CreateAddressCommand addressCommand) {
        AddressCreateEvent event = addressCreateCommandHandler.createAddress(addressCommand);
        return addressDataMapper.addressToCreateAddressResponse(event.getMessage());
    }
}
