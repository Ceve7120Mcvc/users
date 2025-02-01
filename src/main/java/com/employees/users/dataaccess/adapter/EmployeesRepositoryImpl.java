package com.employees.users.dataaccess.adapter;

import com.employees.users.dataaccess.entity.EmployeesEntity;
import com.employees.users.dataaccess.mapper.EmployeesAccessMapper;
import com.employees.users.dataaccess.repository.EmployeesJpaRepository;
import com.employees.users.domain.core.entity.Employees;
import com.employees.users.domain.service.ports.output.repository.EmployeesRepository;
import org.springframework.stereotype.Component;

@Component
public class EmployeesRepositoryImpl implements EmployeesRepository {
    private final EmployeesAccessMapper employeesAccessMapper;
    private final EmployeesJpaRepository employeesJpaRepository;

    public EmployeesRepositoryImpl(EmployeesAccessMapper employeesAccessMapper, EmployeesJpaRepository employeesJpaRepository) {
        this.employeesAccessMapper = employeesAccessMapper;
        this.employeesJpaRepository = employeesJpaRepository;
    }


    @Override
    public Employees createEmployees(Employees employees) {
        EmployeesEntity employeesEntity = employeesAccessMapper.employeesToEmployeesEntity(employees);
        EmployeesEntity employeesSaved = employeesJpaRepository.save(employeesEntity);
        return employeesAccessMapper.employeesEntityToUser(employeesSaved);
    }
}
