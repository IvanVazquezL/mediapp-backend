package com.ivan.mediappbackend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_data")
public class User {
    @Id
    @EqualsAndHashCode.Include
    private Integer idUser;
    @Column(length = 70, nullable = false, unique = true)
    private String username;
    @Column(length = 60, nullable = false)
    private String password;
    @Column(nullable = false)
    private boolean enabled;

}
