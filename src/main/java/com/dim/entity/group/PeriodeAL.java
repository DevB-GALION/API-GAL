package com.dim.entity.group;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "periode_al")
public class PeriodeAL {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public Date startDate;
    public Date endDate;
}
