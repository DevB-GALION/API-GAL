package com.dim.entity.group;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "periode_al")
@Getter
@Setter
@NoArgsConstructor
public class PeriodeAL {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public Date startDate;
    public Date endDate;
}
