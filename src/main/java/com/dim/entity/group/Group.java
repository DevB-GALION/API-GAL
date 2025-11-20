package com.dim.entity.group;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "groups")
@Setter
@Getter
@NoArgsConstructor
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    @ManyToOne
    public PeriodeAL periodeAL;
    @ManyToOne
    public TrancheAge trancheAge;
}
