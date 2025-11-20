package com.dim.resource;

import com.dim.dto.ActivityDTO;
import com.dim.dto.AnimateurDTO;
import com.dim.entity.activity.ActivityLocation;
import com.dim.entity.activity.ActivityType;
import com.dim.mapper.activity.ActivityFetcher;
import com.dim.mapper.activity.ActivityMapper;
import com.dim.mapper.user.AnimateurFetcher;
import com.dim.mapper.user.AnimateurMapper;
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
    ActivityMapper activityMapper;

    @Inject
    ActivityFetcher activityFetcher;

    @Inject
    AnimateurMapper animateurMapper;

    @Inject
    AnimateurFetcher animateurFetcher;

    @Inject
    ActivityTypeService activityTypeService;

    @Inject
    ActivityLocationService activityLocationService;


    @GET
    public List<ActivityDTO> getActivities() {
        return this.activityService.findAll().stream().map(activityMapper::toDTO).toList();
    }

    @GET
    @Path("{id}")
    public ActivityDTO getActivityById(@PathParam("id") Long id) {
        return this.activityMapper.toDTO(this.activityService.findById(id));
    }

    @POST
    public ActivityDTO createActivity(ActivityDTO activity) {
        return this.activityMapper.toDTO(this.activityService.createActivity(this.activityMapper.toEntity(activity, this.activityFetcher)));
    }

    @PUT
    @Path("{id}")
    public ActivityDTO updateActivity(@PathParam("id") Long id, ActivityDTO activityData) {
        return this.activityMapper.toDTO(this.activityService.updateActivity(id, this.activityMapper.toEntity(activityData, this.activityFetcher)));
    }

    @DELETE
    @Path("{id}")
    public Boolean deleteActivity(@PathParam("id") Long id) {
        return this.activityService.deleteActivity(id);
    }

    @GET
    @Path("/animateurs/{id}")
    public List<AnimateurDTO> getActivitiesByAnimateur(@PathParam("id") Long animateurId) {
        return this.activityService.getAnimateursFromActivity(animateurId).stream().map(animateurMapper::toDTO).toList();
    }

    @POST
    @Path("animateurs/{id}")
    public Boolean addAnimateurToActivity(@PathParam("id") Long activityId, Long animateurId) {
        return this.activityService.addAnimateurToActivity(activityId, animateurId);
    }

    @DELETE
    @Path("/animateurs/{id}")
    public Boolean removeAnimateurFromActivity(@PathParam("id") Long activityId, Long animateurId) {
        return this.activityService.removeAnimateurFromActivity(activityId, animateurId);
    }

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