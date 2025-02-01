package com.employees.users.domain.service.create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateAddressCommand {
    private final String street;
    private final Long exterior;
    private final Long interior;
    private final String colony;
    private final String municipality;
    private final String state;
    private final String country;

}
