package com.dim.service.activity;

import com.dim.repository.activity.ActivityLocationRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ActivityLocationService {
    @Inject
    ActivityLocationRepository activityLocationRepository;
}
