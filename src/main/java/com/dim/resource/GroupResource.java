package com.dim.resource;

import com.dim.dto.GroupDTO;
import com.dim.entity.group.Group;
import com.dim.entity.group.PeriodeAL;
import com.dim.entity.group.TrancheAge;
import com.dim.mapper.group.GroupFetcher;
import com.dim.mapper.group.GroupMapper;
import com.dim.service.group.GroupService;
import com.dim.service.group.PeriodeALService;
import com.dim.service.group.TrancheAgeService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("groups")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GroupResource {

    @Inject
    GroupService groupService;

    @Inject
    GroupMapper groupMapper;

    @Inject
    GroupFetcher groupFetcher;

    @Inject
    PeriodeALService periodeALService;

    @Inject
    TrancheAgeService trancheAgeService;

    @GET
    public List<Group> getGroups() {
        return this.groupService.getGroups();
    }

    @GET
    @Path("/{id}")
    public Group getGroupById(@PathParam("id") Long id) {
        return this.groupService.getGroupById(id);
    }

    @POST
    public Group createGroup(GroupDTO group) {
        return this.groupService.createGroup(this.groupMapper.toEntity(group, this.groupFetcher));
    }

    @PUT
    @Path("/{id}")
    public Group updateGroup(@PathParam("id") Long id, GroupDTO groupData) {
        return this.groupService.updateGroup(id, this.groupMapper.toEntity(groupData, this.groupFetcher));
    }

    @DELETE
    @Path("/{id}")
    public void deleteGroup(@PathParam("id") Long id) {
        this.groupService.deleteGroup(id);
    }

    @GET
    @Path("/periodals")
    public List<PeriodeAL> getPeriodals() {
        return this.periodeALService.findAll();
    }

    @GET
    @Path("/periodals/{id}")
    public PeriodeAL getPeriodAlById(@PathParam("id") Long id){
        return this.periodeALService.findById(id);
    }

    @POST
    @Path("/periodals")
    public PeriodeAL createPeriodAl(PeriodeAL periodeAL){
        return this.periodeALService.createPeriodeAL(periodeAL);
    }

    @PUT
    @Path("/periodals/{id}")
    public PeriodeAL updatePeriodAl(@PathParam("id") Long id, PeriodeAL periodeALData){
        return this.periodeALService.updatePeriodeAL(id, periodeALData);
    }

    @DELETE
    @Path("/periodals/{id}")
    public void deletePeriodAl(@PathParam("id") Long id){
        this.periodeALService.deletePeriodeAL(id);
    }

    @GET
    @Path("/trancheages")
    public List<TrancheAge> getTrancheAges(){
        return this.trancheAgeService.findAll();
    }

    @GET
    @Path("/trancheages/{id}")
    public TrancheAge getTrancheAgeById(@PathParam("id") Long id){
        return this.trancheAgeService.findById(id);
    }

    @POST
    @Path("/trancheages")
    public Response createTrancheAge(TrancheAge trancheAge){
        if(trancheAge.getMinAge() > trancheAge.getMaxAge()){
            return Response.status(Response.Status.BAD_REQUEST).entity("L'age minimum est plus grand que l'age maximum").build();
        }
        return Response.ok(this.trancheAgeService.createTrancheAge(trancheAge)).build();
    }

    @PUT
    @Path("/trancheages/{id}")
    public Response updateTrancheAge(@PathParam("id") Long id, TrancheAge trancheAgeData){
        if(trancheAgeData.getMinAge() > trancheAgeData.getMaxAge()){
            return Response.status(Response.Status.BAD_REQUEST).entity("L'age minimum est plus grand que l'age maximum").build();
        }
        return Response.ok(this.trancheAgeService.updateTrancheAge(id, trancheAgeData)).build();
    }

    @DELETE
    @Path("/trancheages/{id}")
    public void deleteTrancheAge(@PathParam("id") Long id){
        this.trancheAgeService.deleteTrancheAge(id);
    }
}
