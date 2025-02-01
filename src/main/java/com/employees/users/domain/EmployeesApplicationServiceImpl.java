package com.employees.users.domain;

import com.employees.users.common.domain.valueonject.AddressId;
import com.employees.users.common.domain.valueonject.PositionId;
import com.employees.users.domain.core.entity.Address;
import com.employees.users.domain.core.entity.Employees;
import com.employees.users.domain.core.entity.Position;
import com.employees.users.domain.core.event.AddressCreateEvent;
import com.employees.users.domain.core.event.EmployeesCreateEvent;
import com.employees.users.domain.core.event.EmployeesUpdateEvent;
import com.employees.users.domain.core.event.PositionCreateEvent;
import com.employees.users.domain.service.create.*;
import com.employees.users.domain.service.handler.AddressCreateCommandHandler;
import com.employees.users.domain.service.handler.EmployeesCreateCommandeHandler;
import com.employees.users.domain.service.handler.EmployeesUpdateCommandHandler;
import com.employees.users.domain.service.handler.PositionCreateCommandHandler;
import com.employees.users.domain.service.mapper.AddressDataMapper;
import com.employees.users.domain.service.mapper.EmployeesDataMapper;
import com.employees.users.domain.service.mapper.PositionDataMapper;
import com.employees.users.domain.service.ports.input.service.EmployeesApplicationService;
import com.employees.users.domain.service.query.QueryEmployeesResponse;
import com.employees.users.domain.service.update.UpdateEmployeesCommand;
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
    private final EmployeesUpdateCommandHandler employeesUpdateCommandHandler;

    public EmployeesApplicationServiceImpl(EmployeesCreateCommandeHandler employeesCreateCommandeHandler, EmployeesDataMapper employeesDataMapper, PositionCreateCommandHandler positionCreateCommandHandler, PositionDataMapper positionDataMapper, AddressCreateCommandHandler addressCreateCommandHandler, AddressDataMapper addressDataMapper, EmployeesUpdateCommandHandler employeesUpdateCommandHandler) {
        this.employeesCreateCommandeHandler = employeesCreateCommandeHandler;
        this.employeesDataMapper = employeesDataMapper;
        this.positionCreateCommandHandler = positionCreateCommandHandler;
        this.positionDataMapper = positionDataMapper;
        this.addressCreateCommandHandler = addressCreateCommandHandler;
        this.addressDataMapper = addressDataMapper;
        this.employeesUpdateCommandHandler = employeesUpdateCommandHandler;
    }

    @Override
    public CreateEmployeesResponse createEmployees(CreateEmployeesCommand createEmployeesCommand) throws Exception {
        EmployeesCreateEvent employeesCreateEvent = employeesCreateCommandeHandler.createEmployees(createEmployeesCommand);
        return employeesDataMapper.employeesToCreateEmployeesResponse(employeesCreateEvent.getEmployees(), "Users saved successfully!");
    }

    @Override
    public QueryEmployeesResponse updateEmployees(UpdateEmployeesCommand employeesCommand) {
        Employees updateEmployees = new Employees(
                employeesCommand.getCurp(),
                employeesCommand.getName(),
                employeesCommand.getSurnames(),
                new Position(new PositionId(employeesCommand.getIdPosition().getId().getValue())),
                new Address(new AddressId(employeesCommand.getIdAddress().getId().getValue()))
                );
        EmployeesUpdateEvent updateEvent = employeesUpdateCommandHandler.updateEmployees(updateEmployees);
        return employeesDataMapper.employeesToQueryEmployeesResponse(updateEvent.getEmployees());
    }

    @Override
    public CreatePositionResponse createPosition(CreatePositionCommand positionCommand) {
        PositionCreateEvent event = positionCreateCommandHandler.createPosition(positionCommand);
        return positionDataMapper.positionToCreatePositionResponse(event.getPosition(),"saved successfully!");
    }

    @Override
    public CreateAddressResponse createAddress(CreateAddressCommand addressCommand) {
        AddressCreateEvent event = addressCreateCommandHandler.createAddress(addressCommand);
        return addressDataMapper.addressToCreateAddressResponse("saved successfully!");
    }
}
