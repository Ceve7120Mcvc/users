package com.employees.users.dataaccess.adapter;

import com.employees.users.dataaccess.entity.EmployeesEntity;
import com.employees.users.dataaccess.mapper.EmployeesDataAccessMapper;
import com.employees.users.dataaccess.repository.EmployeesJpaRepository;
import com.employees.users.domain.core.entity.Employees;
import com.employees.users.domain.service.ports.output.repository.EmployeesRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EmployeesRepositoryImpl implements EmployeesRepository {
    private final EmployeesDataAccessMapper employeesDataAccessMapper;
    private final EmployeesJpaRepository employeesJpaRepository;

    public EmployeesRepositoryImpl(EmployeesDataAccessMapper employeesDataAccessMapper, EmployeesJpaRepository employeesJpaRepository) {
        this.employeesDataAccessMapper = employeesDataAccessMapper;
        this.employeesJpaRepository = employeesJpaRepository;
    }


    @Override
    public Employees createEmployees(Employees employees) {
        EmployeesEntity employeesEntity = employeesDataAccessMapper.employeesToEmployeesEntity(employees);
        EmployeesEntity employeesSaved = employeesJpaRepository.save(employeesEntity);
        return employeesDataAccessMapper.employeesEntityToUser(employeesSaved);
    }

    @Override
    public Optional<Employees> findEmployeesByEmployeesId(String curp) {
        return employeesJpaRepository.findById(curp).map(employeesDataAccessMapper::employeesEntityToUser);
    }

    @Override
    public Employees employeesUpdate(Employees employees) {
        EmployeesEntity employeesEntity = employeesDataAccessMapper.employeesToEmployeesEntity(employees);
        EmployeesEntity employeesUpdate = employeesJpaRepository.save(employeesEntity);
        return employeesDataAccessMapper.employeesEntityToUser(employeesUpdate);
    }
}
