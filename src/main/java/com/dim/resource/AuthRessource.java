package com.dim.resource;

import com.dim.entity.user.User;
import com.dim.service.AuthService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.http.HttpResponse;

@Path("auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthRessource {

    @Inject
    AuthService authService;

    @POST
    @Path("register")
    public Response register(User user) {
        Boolean isRegistered = authService.register(user.name, user.email, user.password);

        if (isRegistered) {
            return Response.ok(true).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(false)
                    .build();
        }
    }

}
