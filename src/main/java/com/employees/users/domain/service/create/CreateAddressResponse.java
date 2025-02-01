package com.employees.users.domain.service.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CreateAddressResponse {
    private final String message;
}
