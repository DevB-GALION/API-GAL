package com.dim.entity.group;

import jakarta.persistence.*;

@Entity
@Table(name = "tranche_age")
public class TrancheAge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public Integer minAge;
    public Integer maxAge;
}
