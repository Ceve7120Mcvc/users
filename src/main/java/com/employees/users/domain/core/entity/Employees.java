package com.employees.users.domain.core.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Employees {
    private String name;
    private String surnames;
    private String curp;
    private Position idPosition;
    private Address idAddress;

    public Employees(String name, String surnames, String curp, Position idPosition, Address idAddress) {
        this.name = name;
        this.surnames = surnames;
        this.curp = curp;
        this.idPosition = idPosition;
        this.idAddress = idAddress;
    }

}
