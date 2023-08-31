package com.ivan.mediappbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Medic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idMedic;
    @Column(length = 70, nullable = false)
    private String firstName;
    @Column(length = 70, nullable = false)
    private String lastName;
    @Column(length = 20, nullable = false)
    private String licenseNumber;
    private String photoUrl;

}
