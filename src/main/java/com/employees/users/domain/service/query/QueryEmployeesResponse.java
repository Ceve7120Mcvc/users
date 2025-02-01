package com.employees.users.domain.service.query;

import com.employees.users.domain.core.entity.Address;
import com.employees.users.domain.core.entity.Position;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class QueryEmployeesResponse {
    private String name;
    private String surnames;
    private String curp;
    private Position idPosition;
    private Address idAddress;
}
