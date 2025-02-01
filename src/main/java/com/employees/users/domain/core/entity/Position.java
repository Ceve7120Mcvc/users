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

    public Position(PositionId id, String namePosition, Long immediateBossKey) {
        super.setId(id);
        this.namePosition = namePosition;
        this.immediateBossKey = immediateBossKey;
    }
}
