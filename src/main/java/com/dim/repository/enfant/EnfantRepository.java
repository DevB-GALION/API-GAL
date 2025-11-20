package com.dim.repository.enfant;

import com.dim.entity.enfant.Enfant;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EnfantRepository implements PanacheRepository<Enfant> {
}
