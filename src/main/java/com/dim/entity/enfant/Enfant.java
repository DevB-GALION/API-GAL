package com.dim.entity.enfant;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "Enfant")
@Setter
@Getter
@NoArgsConstructor
public class Enfant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public String first_name;
    public String gender;
    public Date date_of_birth;
    public String email_parent1;
    public String legal_responsible_phone1;
    public String legal_responsible_phone2;
    public String email_parent2;
    @ManyToOne
    public Pai pai;
    @ManyToOne
    public RegimeAlimentaire regimeAlimentaire;

}
