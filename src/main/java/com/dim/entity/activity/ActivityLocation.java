package com.dim.entity.activity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "app_lieu_activite")
@Setter
@Getter
@NoArgsConstructor
public class ActivityLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public int capacityMax;
    public String emplacement;
}
