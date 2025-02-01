package com.employees.users.aplication.rest;

import com.employees.users.domain.service.create.*;
import com.employees.users.domain.service.ports.input.service.EmployeesApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/employees", produces = "application/vnd.api.v1+json")
public class EmployeesController {
    private final EmployeesApplicationService employeesApplicationService;

    public EmployeesController(EmployeesApplicationService employeesApplicationService) {
        this.employeesApplicationService = employeesApplicationService;
    }

    @PostMapping
    public ResponseEntity<?> createEmployees(@RequestBody CreateEmployeesCommand createEmployeesCommand) {
        CreateEmployeesResponse response = employeesApplicationService.createEmployees(createEmployeesCommand);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/position")
    public ResponseEntity<?> createPosition(@RequestBody CreatePositionCommand positionCommad){
        CreatePositionResponse response = employeesApplicationService.createPosition(positionCommad);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/address")
    public ResponseEntity<?> createAddress(@RequestBody CreateAddressCommand addressCommad){
        CreateAddressResponse response = employeesApplicationService.createAddress(addressCommad);
        return ResponseEntity.ok(response);
    }
}
