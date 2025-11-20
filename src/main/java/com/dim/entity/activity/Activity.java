package com.dim.entity.activity;

import com.dim.entity.user.Animateur;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "app_activite")
@Setter
@Getter
@NoArgsConstructor
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    public Date startDate;
    public Date endDate;
    public String lieu;
    @ManyToMany
    public List<Animateur> animateur;
    @ManyToOne(cascade = CascadeType.ALL)
    public ActivityType activityType;
    @ManyToOne(cascade = CascadeType.ALL)
    public ActivityLocation activityLocation;
}
