package com.dim.repository.activity;

import com.dim.entity.activity.Deplacement;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DeplacementRepository implements PanacheRepository<Deplacement> {
}
