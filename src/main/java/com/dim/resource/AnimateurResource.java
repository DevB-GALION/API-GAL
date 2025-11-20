package com.dim.resource;

import com.dim.dto.AnimateurDTO;
import com.dim.mapper.user.AnimateurFetcher;
import com.dim.mapper.user.AnimateurMapper;
import com.dim.service.AnimateurService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("animateurs")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AnimateurResource {
    @Inject
    AnimateurService animateurService;

    @Inject
    AnimateurMapper animateurMapper;

    @Inject
    AnimateurFetcher animateurFetcher;

    @GET
    public List<AnimateurDTO> getAnimateurs(){
        return this.animateurService.findAll().stream().map(animateurMapper::toDTO).toList();
    }

    @GET
    @Path("/{id}")
    public AnimateurDTO getAnimateurById(@PathParam("id") Long id){
        return this.animateurMapper.toDTO(this.animateurService.findById(id));
    }

    @POST
    public AnimateurDTO createAnimateur(AnimateurDTO animateur){
        return this.animateurMapper.toDTO(this.animateurService.createAnimateur(this.animateurMapper.toEntity(animateur, this.animateurFetcher)));
    }

    @PUT
    @Path("/{id}")
    public AnimateurDTO updateAnimateur(@PathParam("id") Long id, AnimateurDTO animateurData){
        return this.animateurMapper.toDTO(this.animateurService.updateAnimateur(id, this.animateurMapper.toEntity(animateurData, this.animateurFetcher)));
    }

    @DELETE
    @Path("/{id}")
    public Boolean deleteAnimateur(@PathParam("id") Long id) {
       return this.animateurService.deleteAnimateur(id);
    }
}
