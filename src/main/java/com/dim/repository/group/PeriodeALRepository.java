package com.dim.repository.group;

import com.dim.entity.group.PeriodeAL;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PeriodeALRepository implements PanacheRepository<PeriodeAL> {
}
