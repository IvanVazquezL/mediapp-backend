package com.ivan.mediappbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

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
    // Eager so the database fill the roles without us doing a second query
    @ManyToMany(fetch = FetchType.EAGER)
    // We create an intermediate table to establish the manu to many relationship between user and role
    // id_role is inverse because that property is in Role not in User
    @JoinTable(
            name="user_role",
            joinColumns = @JoinColumn(name="id_user", referencedColumnName = "idUser"),
            inverseJoinColumns = @JoinColumn(name="id_role", referencedColumnName = "idRole")
    )
    private List<Role>roles;

}
