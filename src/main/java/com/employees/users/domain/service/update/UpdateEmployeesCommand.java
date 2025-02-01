package com.employees.users.domain.service.update;

import com.employees.users.domain.core.entity.Address;
import com.employees.users.domain.core.entity.Position;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class UpdateEmployeesCommand {
    private String name;
    private String surnames;
    private String curp;
    private Position idPosition;
    private Address idAddress;
}
