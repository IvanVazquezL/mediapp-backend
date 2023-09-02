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
public class Menu {
    @Id
    @EqualsAndHashCode.Include
    private Integer idMenu;
    @Column(length = 20, nullable = false)
    private String name;
    @Column(length = 20, nullable = false)
    private String icon;
    @Column(length = 30, nullable = false)
    private String url;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="menu_role",
            joinColumns = @JoinColumn(name="id_menu", referencedColumnName = "idMenu"),
            inverseJoinColumns = @JoinColumn(name="id_role", referencedColumnName = "idRole")
    )
    private List<Role> roles;
}
