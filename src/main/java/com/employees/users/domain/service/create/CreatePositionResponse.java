package com.employees.users.domain.service.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CreatePositionResponse {
    private final String namePosition;
    private final String message;
}
