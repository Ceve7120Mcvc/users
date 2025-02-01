package com.employees.users.domain.service.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateEmployeesCommand {
    @NonNull
    private final String name;
    private final String surnames;
    @NonNull
    private final String curp;
    private final Long idPosition;
    private final Long idAddress;
}
