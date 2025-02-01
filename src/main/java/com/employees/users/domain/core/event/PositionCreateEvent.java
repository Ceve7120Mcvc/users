package com.employees.users.domain.core.event;

import com.employees.users.common.domain.DomainEvent;
import com.employees.users.domain.core.entity.Employees;
import com.employees.users.domain.core.entity.Position;

import java.time.ZonedDateTime;

public class PositionCreateEvent implements DomainEvent<Position> {
    private final Position position;
    private String message;
    private final ZonedDateTime createdAt;

    public PositionCreateEvent(Position position, ZonedDateTime createdAt) {
        this.position = position;
        this.createdAt = createdAt;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public String getMessage() {
        return "";
    }
}
