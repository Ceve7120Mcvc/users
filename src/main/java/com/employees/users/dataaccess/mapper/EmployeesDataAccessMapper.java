package com.employees.users.dataaccess.mapper;

import com.employees.users.common.domain.valueonject.EmployeesId;
import com.employees.users.dataaccess.entity.AddressEntity;
import com.employees.users.dataaccess.entity.EmployeesEntity;
import com.employees.users.dataaccess.entity.PositionEntity;
import com.employees.users.domain.core.entity.Address;
import com.employees.users.domain.core.entity.Employees;
import com.employees.users.domain.core.entity.Position;
import org.springframework.stereotype.Component;

@Component
public class EmployeesDataAccessMapper {
    private final PositionDataAccessMapper positionDataAccessMapper;
    private final AddressDataAccessMapper addressDataAccessMapper;

    public EmployeesDataAccessMapper(PositionDataAccessMapper positionDataAccessMapper, AddressDataAccessMapper addressDataAccessMapper) {
        this.positionDataAccessMapper = positionDataAccessMapper;
        this.addressDataAccessMapper = addressDataAccessMapper;
    }

    public EmployeesEntity employeesToEmployeesEntity(Employees employees){
        PositionEntity idPosition = employees.getIdPosition() != null ? positionDataAccessMapper.positionToPositionEntity(employees.getIdPosition()) : null;
        AddressEntity idAddress = employees.getIdAddress() != null ? addressDataAccessMapper.addressToAddressEntity(employees.getIdAddress()) : null;
        return EmployeesEntity.builder()
                .name(employees.getName())
                .surnames(employees.getSurnames())
                .curp(employees.getCurp())
                .position(idPosition)
                .address(idAddress)
                .build();
    }

    public Employees employeesEntityToUser(EmployeesEntity employeesEntity){
        Position idPosition = employeesEntity.getPosition() != null ? positionDataAccessMapper.positionEntityToUser(employeesEntity.getPosition()) : null;
        Address idAddress = employeesEntity.getAddress() != null ? addressDataAccessMapper.addressEntityToAddress(employeesEntity.getAddress()) : null;
        return new Employees(
                employeesEntity.getName(),
                employeesEntity.getSurnames(),
                employeesEntity.getCurp(),
                idPosition,
                idAddress
        );
    }


}
