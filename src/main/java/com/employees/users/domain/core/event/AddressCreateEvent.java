package com.employees.users.domain.core.event;

import com.employees.users.common.domain.DomainEvent;
import com.employees.users.domain.core.entity.Employees;

import java.time.ZonedDateTime;

public class AddressCreateEvent implements DomainEvent<Employees> {
    private String message;
    private final ZonedDateTime createdAt;

    public AddressCreateEvent(String message, ZonedDateTime createdAt) {
        this.message = message;
        this.createdAt = createdAt;
    }

    @Override
    public String getMessage() {
        return "";
    }
}
