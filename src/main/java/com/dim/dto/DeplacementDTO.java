package com.dim.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
public class DeplacementDTO {
    public Long id;
    public String name;
    public String lieuDepart;
    public String lieuArrivee;
    public Date dateDepart;
    public Date dateArrivee;
    public int activityId;
    public String deplacementType;
    public int nbMax;
}