package com.employees.users.domain.service.query;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class QueryEmployeesListResponse {
    private final List<QueryEmployeesResponse> employees;
}
