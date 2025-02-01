package com.employees.users.domain.service.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
@Builder
@AllArgsConstructor
public class CreateEmployeesResponse {
    private final String curp;
    private final String message;
}
