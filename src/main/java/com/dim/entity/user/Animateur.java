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
    private long id;
    private String lastname;
    private String firstname;
    private String genre;
    private Date birthDate;
    private String diplome;
    @OneToOne
    private User user;
}
