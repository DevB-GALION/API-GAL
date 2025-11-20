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
    @Path("/locations")
    public List<ActivityLocation> getActivityLocations() {
        return activityLocationService.findAll();
    }

    @GET
    @Path("/locations/{id}")
    public ActivityLocation getActivityLocationById(@PathParam("id") Long id) {
        return this.activityLocationService.findById(id);
    }

    @POST
    @Path("/locations")
    public ActivityLocation createActivityLocation(ActivityLocation activityLocation) {
        return this.activityLocationService.createActivityLocation(activityLocation);
    }

    @PUT
    @Path("/locations/{id}")
    public ActivityLocation updateActivityLocation(@PathParam("id") Long id, ActivityLocation activityLocationData) {
        return this.activityLocationService.updateActivityLocation(id, activityLocationData);
    }

    @DELETE
    @Path("/locations/{id}")
    public Boolean deleteActivityLocation(@PathParam("id") Long id) {
        return this.activityLocationService.deleteActivityLocation(id);
    }

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