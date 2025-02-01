package com.employees.users.domain.service.handler;

import com.employees.users.domain.core.entity.Employees;
import com.employees.users.domain.core.event.EmployeesCreateEvent;
import com.employees.users.domain.service.create.CreateEmployeesCommand;
import com.employees.users.domain.service.mapper.EmployeesDataMapper;
import com.employees.users.domain.service.ports.output.repository.EmployeesRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Component
public class EmployeesCreateCommandeHandler {
    private final EmployeesDataMapper employeesDataMapper;
    private final EmployeesRepository employeesRepository;

    public EmployeesCreateCommandeHandler(EmployeesDataMapper employeesDataMapper, EmployeesRepository employeesRepository) {
        this.employeesDataMapper = employeesDataMapper;
        this.employeesRepository = employeesRepository;
    }

    @Transactional
    public EmployeesCreateEvent createEmployees(CreateEmployeesCommand createEmployeesCommand) {
        Employees employees = employeesDataMapper.createEmployeesCommandToEmployees(createEmployeesCommand);
        Employees savedEmployees = employeesRepository.createEmployees(employees);
        return new EmployeesCreateEvent(savedEmployees, ZonedDateTime.now(ZoneId.of("UTC")));
    }


}
