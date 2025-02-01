package com.employees.users.domain.core.entity;

import com.employees.users.common.domain.entity.AggregateRoot;
import com.employees.users.common.domain.valueonject.AddressId;
import com.employees.users.common.domain.valueonject.EmployeesId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Address extends AggregateRoot<AddressId> {
    private String street;
    private Long exterior;
    private Long interior;
    private String colony;
    private String municipality;
    private String state;
    private String country;

    public Address(AddressId id, String street, Long exterior, Long interior, String colony, String municipality, String state, String country) {
        super.setId(id);
        this.street = street;
        this.exterior = exterior;
        this.interior = interior;
        this.colony = colony;
        this.municipality = municipality;
        this.state = state;
        this.country = country;
    }

    public Address(AddressId addressId) {
        super.setId(addressId);
    }
}
