package com.dim.resource;

import com.dim.dto.GroupDTO;
import com.dim.entity.group.Group;
import com.dim.mapper.group.GroupFetcher;
import com.dim.mapper.group.GroupMapper;
import com.dim.service.group.GroupService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

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
}
