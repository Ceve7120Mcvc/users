package com.employees.users.domain.service.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class QueryAddressResponse {
    private String street;
    private Long exterior;
    private Long interior;
    private String colony;
    private String municipality;
    private String state;
    private String country;
}
