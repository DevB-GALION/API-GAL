package com.dim.entity.activity;

import com.dim.entity.user.Animateur;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Long id;
    private String name;
    private Date startDate;
    private Date endDate;
    private String lieu;
    @ManyToMany
    @JoinTable(
            name = "app_activity_animateur",
            joinColumns = @JoinColumn(name = "activity_id"),
            inverseJoinColumns = @JoinColumn(name = "animateur_id")
    )
    @JsonIgnore
    private List<Animateur> animateur;
    @ManyToOne
    private ActivityType activityType;
    @ManyToOne
    private ActivityLocation activityLocation;
}
