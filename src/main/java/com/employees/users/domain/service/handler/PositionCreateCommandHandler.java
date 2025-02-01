package com.employees.users.domain.service.handler;

import com.employees.users.domain.core.entity.Position;
import com.employees.users.domain.core.event.PositionCreateEvent;
import com.employees.users.domain.service.create.CreatePositionCommand;
import com.employees.users.domain.service.mapper.PositionDataMapper;
import com.employees.users.domain.service.ports.output.repository.PositionRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Component
public class PositionCreateCommandHandler {
    private final PositionDataMapper positionDataMapper;
    private final PositionRepository positionRepository;

    public PositionCreateCommandHandler(PositionDataMapper positionDataMapper, PositionRepository positionRepository) {
        this.positionDataMapper = positionDataMapper;
        this.positionRepository = positionRepository;
    }


    @Transactional
    public PositionCreateEvent createPosition(CreatePositionCommand positionCommand){
        Position employees = positionDataMapper.createPositionCommandToPosition(positionCommand);
        Position savedEmployees = positionRepository.createPosition(employees);
        return new PositionCreateEvent(savedEmployees, ZonedDateTime.now(ZoneId.of("UTC")));
    }


}
