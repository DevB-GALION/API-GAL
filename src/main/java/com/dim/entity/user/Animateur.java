package com.dim.entity.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "app_animateur")
@Setter
@Getter
@NoArgsConstructor
public class Animateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String lastname;
    public String firstname;
    public String genre;
    public Date birthDate;
    public String diplome;
    @OneToOne
    public User user;
}
