package com.dim.resource;
import com.dim.service.UserService;
import com.dim.entity.user.User;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
@Path("users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    UserService userservice;

    @GET
    public  List<User> listAll(){
        return userservice.findAll();
    }


    @POST
    public void addUser(User newUser){
        userservice.addUser(newUser.name, newUser.email, newUser.password);
    }

    @DELETE
    @Path("/{id}")
    public void deleteUser(@PathParam("id") long id){
        userservice.delete(id);
    }


    @PUT
    @Path("/{id}")
    public User updateUser(@PathParam("id") long id, User updatedUser){
        updatedUser.id = id;
        return userservice.update(updatedUser);
    }
}
