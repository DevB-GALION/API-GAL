package com.dim.repository.activity;

import com.dim.entity.activity.ActivityLocation;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ActivityLocationRepository implements PanacheRepository<ActivityLocation> {
}
