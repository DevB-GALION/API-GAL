package com.dim.repository.group;

import com.dim.entity.group.TrancheAge;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TrancheAgeRepository implements PanacheRepository<TrancheAge> {
}
