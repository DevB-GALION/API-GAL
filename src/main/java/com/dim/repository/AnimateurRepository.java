package com.dim.repository;

import com.dim.entity.user.Animateur;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AnimateurRepository implements PanacheRepository<Animateur> {
}
