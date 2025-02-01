package com.employees.users.domain.service.ports.output.repository;

import com.employees.users.domain.core.entity.Position;

public interface PositionRepository {
    Position createPosition(Position position);
}
