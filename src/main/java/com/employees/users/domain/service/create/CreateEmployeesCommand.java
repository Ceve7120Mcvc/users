package com.employees.users.domain.service.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateEmployeesCommand {
    private final String name;
    private final String surnames;
    private final String curp;
    private final Long idPosition;
    private final Long idAddress;
}
