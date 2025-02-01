package com.employees.users.dataaccess.mapper;

import com.employees.users.common.domain.valueonject.EmployeesId;
import com.employees.users.common.domain.valueonject.PositionId;
import com.employees.users.dataaccess.entity.EmployeesEntity;
import com.employees.users.dataaccess.entity.PositionEntity;
import com.employees.users.domain.core.entity.Employees;
import com.employees.users.domain.core.entity.Position;
import org.springframework.stereotype.Component;

@Component
public class PositionAccessMapper {

    public PositionEntity positionToPositionEntity(Position position){
        return PositionEntity.builder()
                .namePosition(position.getNamePosition())
                .immediateBossKey(position.getImmediateBossKey())
                .build();
    }

    public Position positionEntityToUser(PositionEntity positionEntity){
        PositionId id = positionEntity.getIdPosition() != null ? new PositionId(positionEntity.getIdPosition()) : null;
        return new Position(
                id,
                positionEntity.getNamePosition(),
                positionEntity.getImmediateBossKey()
        );
    }
}
