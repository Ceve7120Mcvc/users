package com.employees.users.domain.service.handler;

import com.employees.users.domain.core.EmployeesDomainService;
import com.employees.users.domain.core.entity.Employees;
import com.employees.users.domain.core.event.EmployeesUpdateEvent;
import com.employees.users.domain.service.ports.output.repository.EmployeesRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class EmployeesUpdateCommandHandler {
    private final EmployeesRepository employeesRepository;
    private final EmployeesDomainService employeesDomainService;

    public EmployeesUpdateCommandHandler(EmployeesRepository employeesRepository, EmployeesDomainService employeesDomainService) {
        this.employeesRepository = employeesRepository;
        this.employeesDomainService = employeesDomainService;
    }

    @Transactional
    public EmployeesUpdateEvent updateEmployees(Employees employees){
        Optional<Employees> updateEmployees = employeesRepository.findEmployeesByEmployeesId(employees.getCurp());
        EmployeesUpdateEvent updateEvent = employeesDomainService.validateUpdateEmployees(employees, updateEmployees.get());
        Employees employeesUpdate = employeesRepository.employeesUpdate(null);
        return new EmployeesUpdateEvent(employeesUpdate, updateEvent.getMessage());
    }
}
