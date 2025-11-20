package com.dim.repository.enfant;

import com.dim.entity.enfant.Pai;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PaiRepository implements PanacheRepository<Pai> {
}
