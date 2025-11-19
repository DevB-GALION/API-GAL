package com.dim.resource;

import com.dim.entity.user.User;
import com.dim.service.AuthService;
import io.vertx.core.json.Json;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jose4j.json.internal.json_simple.JSONObject;

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

    @POST
    @Path("login")
    public Response login(User user) {
        String token = authService.login(user.email, user.password);

        if (token != null) {
            return Response.ok(JSONObject.toString("token", token)).build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Invalid email or password")
                    .build();
        }
    }
}
