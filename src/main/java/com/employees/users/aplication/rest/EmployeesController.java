package com.employees.users.aplication.rest;

import com.employees.users.domain.service.create.*;
import com.employees.users.domain.service.ports.input.service.EmployeesApplicationService;
import com.employees.users.domain.service.query.QueryEmployeesResponse;
import com.employees.users.domain.service.update.UpdateEmployeesCommand;
import com.employees.users.domain.service.update.UpdateEmployeesResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/employees", produces = "application/vnd.api.v1+json")
public class EmployeesController {
    private final EmployeesApplicationService employeesApplicationService;

    public EmployeesController(EmployeesApplicationService employeesApplicationService) {
        this.employeesApplicationService = employeesApplicationService;
    }

    @PostMapping
    public ResponseEntity<?> createEmployees(@RequestBody CreateEmployeesCommand createEmployeesCommand) throws Exception {
        CreateEmployeesResponse response = employeesApplicationService.createEmployees(createEmployeesCommand);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{curp}")
    public ResponseEntity<QueryEmployeesResponse> updateOffer(@PathVariable String curp,
                                                               @RequestBody UpdateEmployeesCommand employeesCommand){

        employeesCommand.setCurp(curp);
        QueryEmployeesResponse response = employeesApplicationService.updateEmployees(employeesCommand);
        return ResponseEntity.ok().body(response);
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

    @GetMapping("/employees")
    public ResponseEntity<?> getEmployess(){
        return ResponseEntity.ok(null);
    }
}
