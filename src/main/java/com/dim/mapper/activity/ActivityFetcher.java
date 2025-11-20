package com.dim.mapper.activity;

import com.dim.entity.activity.ActivityLocation;
import com.dim.entity.activity.ActivityType;
import com.dim.service.activity.ActivityLocationService;
import com.dim.service.activity.ActivityTypeService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ActivityFetcher {
    @Inject
    ActivityTypeService activityTypeService;

    @Inject
    ActivityLocationService activityLocationService;

    public ActivityType getActivityTypeById(int id) {
        return activityTypeService.findById((long) id);
    }

    public ActivityLocation getActivityLocationById(int id) {
        return activityLocationService.findById((long) id);
    }
}
