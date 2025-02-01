package com.employees.users.domain.core.entity;

import com.employees.users.common.domain.entity.AggregateRoot;
import com.employees.users.common.domain.valueonject.EmployeesId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Employees extends AggregateRoot<EmployeesId> {
    private String name;
    private String surnames;
    private String curp;
    private Long idPosition;
    private Long idAddress;

    public Employees(EmployeesId employeesId, String name, String surnames, String curp, Long idPosition, Long idAddress) {
        super.setId(employeesId);
        this.name = name;
        this.surnames = surnames;
        this.curp = curp;
        this.idPosition = idPosition;
        this.idAddress = idAddress;
    }
}
