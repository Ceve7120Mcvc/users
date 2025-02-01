package com.employees.users.domain.core.entity;

import com.employees.users.common.domain.entity.AggregateRoot;
import com.employees.users.common.domain.valueonject.EmployeesId;
import com.employees.users.common.domain.valueonject.PositionId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Position extends AggregateRoot<PositionId> {
    private String namePosition;
    private Long immediateBossKey;
    private Long subordinateKey;

    public Position(PositionId id, String namePosition, Long immediateBossKey, Long subordinateKey) {
        super.setId(id);
        this.namePosition = namePosition;
        this.immediateBossKey = immediateBossKey;
        this.subordinateKey = subordinateKey;
    }

    public Position(PositionId positionId) {
        super.setId(positionId);
    }
}
