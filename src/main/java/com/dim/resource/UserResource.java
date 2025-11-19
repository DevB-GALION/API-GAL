package com.dim.resource;
import com.dim.entity.user.User;
import com.dim.service.UserService;
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
        //this.userservice.registerUser(newUser.name, newUser.email, newUser.password);
    }
}
