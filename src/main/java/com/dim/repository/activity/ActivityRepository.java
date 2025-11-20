package com.dim.repository.activity;

import com.dim.entity.activity.Activity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ActivityRepository implements PanacheRepository<Activity> {
}
