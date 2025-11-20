package com.dim.entity.group;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tranche_age")
@Setter
@Getter
@NoArgsConstructor
public class TrancheAge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public Integer minAge;
    public Integer maxAge;
}
