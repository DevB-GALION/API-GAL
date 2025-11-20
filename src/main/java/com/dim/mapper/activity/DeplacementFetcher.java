package com.dim.mapper.activity;

import com.dim.entity.activity.Activity;
import com.dim.service.activity.ActivityService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class DeplacementFetcher {
    @Inject
    ActivityService activityService;

    public Activity getActivityById(int id){
        return activityService.findById((long) id);
    }
}
