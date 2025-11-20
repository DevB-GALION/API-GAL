package com.dim.repository.activity;

import com.dim.entity.activity.ActivityType;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ActivityTypeRepository implements PanacheRepository<ActivityType> {
}
