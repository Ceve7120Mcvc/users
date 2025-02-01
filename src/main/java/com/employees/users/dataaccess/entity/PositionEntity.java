package com.employees.users.dataaccess.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "position")
public class PositionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPosition;
    private String namePosition;
    private Long immediateBossKey;
    private Long subordinateKey;
}
