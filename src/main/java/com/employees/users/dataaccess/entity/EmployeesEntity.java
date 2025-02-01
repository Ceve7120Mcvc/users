package com.employees.users.dataaccess.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class EmployeesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmployees;
    private String name;
    private String surnames;
    private String curp;
    @ManyToOne
    @JoinColumn(name="idPosition")
    private PositionEntity position;
    @ManyToOne
    @JoinColumn(name="idAddress")
    private AddressEntity address;
}
