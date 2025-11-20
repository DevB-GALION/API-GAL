package com.dim.resource;

import com.dim.dto.DeplacementDTO;
import com.dim.mapper.activity.DeplacementFetcher;
import com.dim.mapper.activity.DeplacementMapper;
import com.dim.service.activity.DeplacementService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("deplacements")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DeplacementResource {
    @Inject
    DeplacementService deplacementService;

    @Inject
    DeplacementMapper deplacementMapper;

    @Inject
    DeplacementFetcher deplacementFetcher;

    @GET
    public List<DeplacementDTO> listAll(){
        return deplacementService.findAll().stream().map(deplacementMapper::toDTO).toList();
    }

    @GET
    @Path("/{id}")
    public DeplacementDTO getDeplacementById(@PathParam("id") Long id){
        return this.deplacementMapper.toDTO(this.deplacementService.findById(id));
    }

    @POST
    public DeplacementDTO createDeplacement(DeplacementDTO deplacement){
        return this.deplacementMapper.toDTO(this.deplacementService.createDeplacement(this.deplacementMapper.toEntity(deplacement, this.deplacementFetcher)));
    }

    @PUT
    @Path("/{id}")
    public DeplacementDTO updateDeplacement(@PathParam("id") Long id, DeplacementDTO deplacementData) {
        return this.deplacementMapper.toDTO(this.deplacementService.updateDeplacement(id, this.deplacementMapper.toEntity(deplacementData, this.deplacementFetcher)));
    }

    @DELETE
    @Path("/{id}")
    public Boolean deleteDeplacement(@PathParam("id") Long id) {
        return deplacementService.deleteDeplacement(id);
    }
}
