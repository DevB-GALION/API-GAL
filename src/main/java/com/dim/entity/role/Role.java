package com.dim.entity.role;

import jakarta.persistence.*;

@Entity
@Table(name = "app_role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @Enumerated(EnumType.STRING)
    public RoleEnum name;
}
