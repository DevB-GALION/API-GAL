package com.dim.resource;

import com.dim.entity.activity.ActivityLocation;
import com.dim.entity.activity.ActivityType;
import com.dim.service.activity.ActivityLocationService;
import com.dim.service.activity.ActivityService;
import com.dim.service.activity.ActivityTypeService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/activities")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ActivityResource {
    @Inject
    ActivityService activityService;

    @Inject
    ActivityTypeService activityTypeService;

    @Inject
    ActivityLocationService activityLocationService;

    @GET
    @Path("/types")
    public List<ActivityType> getActivityTypes() {
        return activityTypeService.findAll();
    }

    @GET
    @Path("/types/{id}")
    public ActivityType getActivityTypeById(@PathParam("id") Long id) {
        return activityTypeService.findById(id);
    }

    @POST
    @Path("/types")
    public ActivityType createActivityType(ActivityType activityType) {
        return activityTypeService.createActivityType(activityType);
    }

    @PUT
    @Path("/types/{id}")
    public ActivityType updateActivityType(@PathParam("id") Long id, ActivityType activityTypeData) {
        return activityTypeService.updateActivityType(id, activityTypeData);
    }

    @DELETE
    @Path("/types/{id}")
    public Boolean deleteActivityType(@PathParam("id") Long id) {
        return activityTypeService.deleteActivityType(id);
    }
}