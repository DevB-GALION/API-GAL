package com.dim.service.activity;

import com.dim.entity.activity.ActivityLocation;
import com.dim.repository.activity.ActivityLocationRepository;
import com.dim.repository.activity.ActivityRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ActivityService {
    @Inject
    ActivityRepository activityRepository;
}
