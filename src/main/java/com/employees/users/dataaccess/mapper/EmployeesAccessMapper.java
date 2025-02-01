package com.employees.users.dataaccess.mapper;

import com.employees.users.common.domain.valueonject.EmployeesId;
import com.employees.users.dataaccess.entity.EmployeesEntity;
import com.employees.users.dataaccess.entity.PositionEntity;
import com.employees.users.domain.core.entity.Employees;
import com.employees.users.domain.core.entity.Position;
import org.springframework.stereotype.Component;

@Component
public class EmployeesAccessMapper {
    public EmployeesEntity employeesToEmployeesEntity(Employees employees){
        return EmployeesEntity.builder()
                .name(employees.getName())
                .surnames(employees.getSurnames())
                .curp(employees.getCurp())
                .idAddress(employees.getIdPosition())
                .idPosition(employees.getIdAddress())
                .build();
    }

    public Employees employeesEntityToUser(EmployeesEntity employeesEntity){
        EmployeesId id = employeesEntity.getIdEmployees() != null ? new EmployeesId(employeesEntity.getIdEmployees()) : null;
        return new Employees(
                id,
                employeesEntity.getName(),
                employeesEntity.getSurnames(),
                employeesEntity.getCurp(),
                employeesEntity.getIdPosition(),
                employeesEntity.getIdAddress()
        );
    }


}
