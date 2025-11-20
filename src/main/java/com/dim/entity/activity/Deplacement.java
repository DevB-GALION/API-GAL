package com.dim.entity.activity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "app_deplacement")
@Setter
@Getter
@NoArgsConstructor
public class Deplacement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public String lieuDepart;
    public String lieuArrivee;
    public String dateDepart;
    public String dateArrivee;
    @OneToOne
    public Activity activity;
    public String deplacementType;
    public int nbMax;
}
