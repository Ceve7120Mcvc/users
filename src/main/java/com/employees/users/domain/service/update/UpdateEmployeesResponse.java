package com.employees.users.domain.service.update;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
@Builder
@AllArgsConstructor
public class UpdateEmployeesResponse {
    private final String name;
    private final String surnames;
    private final String curp;
    private final Long idPosition;
    private final Long idAddress;
}
