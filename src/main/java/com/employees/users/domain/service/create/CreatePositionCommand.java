package com.employees.users.domain.service.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreatePositionCommand {
    private final String namePosition;
    private final Long ImmediateBossKey;
}
