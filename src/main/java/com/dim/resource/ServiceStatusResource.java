package com.dim.resource;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/Status")
public class ServiceStatusResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @RolesAllowed({"ADMIN", "USER"})
    public String hello() {
        return "Status OK";
    }
}
