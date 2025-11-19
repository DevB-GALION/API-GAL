package com.dim.resource;

import com.dim.entity.group.Group;
import com.dim.service.GroupService;
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

    @GET
    public List<Group> getGroups() {
        return this.groupService.getGroups();
    }

    @GET
    @Path(":id")
    public Group getGroupById(Long id) {
        return this.groupService.getGroupById(id);
    }

    @POST
    public Group createGroup(Group group) {
        return this.groupService.createGroup(group);
    }

    @PUT
    @Path("{id}")
    public Group updateGroup(@PathParam("id") Long id, Group groupData) {
        return this.groupService.updateGroup(id, groupData);
    }

    @DELETE
    @Path("{id}")
    public void deleteGroup(@PathParam("id") Long id) {
        this.groupService.deleteGroup(id);
    }
}
