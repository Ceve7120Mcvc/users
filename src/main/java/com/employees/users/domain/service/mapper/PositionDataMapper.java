package com.employees.users.domain.service.mapper;

import com.employees.users.domain.core.entity.Position;
import com.employees.users.domain.service.create.CreateEmployeesResponse;
import com.employees.users.domain.service.create.CreatePositionCommand;
import com.employees.users.domain.service.create.CreatePositionResponse;
import org.springframework.stereotype.Component;

@Component
public class PositionDataMapper {
    public Position createPositionCommandToPosition(CreatePositionCommand positionCommand){
        return new Position(
                null,
                positionCommand.getNamePosition(),
                positionCommand.getImmediateBossKey(),
                positionCommand.getSubordinateKey()
        );
    }

    public CreatePositionResponse positionToCreatePositionResponse(Position position, String message){
        return new CreatePositionResponse(position.getNamePosition(), message);
    }
}
