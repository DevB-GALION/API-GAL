package com.dim.repository.enfant;

import com.dim.entity.enfant.RegimeAlimentaire;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RegimeAlimentaireRepository implements PanacheRepository<RegimeAlimentaire> {
}
