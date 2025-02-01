package com.employees.users.dataaccess.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAddress;
    private String street;
    private Long exterior;
    private Long interior;
    private String colony;
    private String municipality;
    private String state;
    private String country;
}
