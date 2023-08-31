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
public class Role {
    @Id
    @EqualsAndHashCode.Include
    private Integer idRole;
    @Column(length = 70, nullable = false)
    private String name;
    private String description;
}
