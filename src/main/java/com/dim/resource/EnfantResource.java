package com.dim.resource;

import com.dim.entity.enfant.Enfant;
import com.dim.entity.enfant.Pai;
import com.dim.entity.enfant.RegimeAlimentaire;
import com.dim.repository.enfant.EnfantRepository;
import com.dim.repository.enfant.PaiRepository;
import com.dim.repository.enfant.RegimeAlimentaireRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/enfants")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EnfantResource {

    @Inject
    EnfantRepository enfantRepository;

    @Inject
    PaiRepository paiRepository;

    @Inject
    RegimeAlimentaireRepository regimeAlimentaireRepository;

    // ============================
    // ==  ENFANT CRUD
    // ============================

    @GET
    public List<Enfant> getAll() {
        return enfantRepository.listAll();
    }

    @GET
    @Path("/{id}")
    public Enfant getById(@PathParam("id") Long id) {
        return enfantRepository.findById(id);
    }

    @POST
    @Transactional
    public Response create(Enfant enfant) {

        if (enfant.getPai() != null && enfant.getPai().getId() != null) {
            enfant.setPai(paiRepository.findById(enfant.getPai().getId()));
        }

        if (enfant.getRegimeAlimentaire() != null && enfant.getRegimeAlimentaire().getId() != null) {
            enfant.setRegimeAlimentaire(regimeAlimentaireRepository.findById(enfant.getRegimeAlimentaire().getId()));
        }

        enfantRepository.persist(enfant);
        return Response.status(Response.Status.CREATED).entity(enfant).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, Enfant updated) {
        Enfant enfant = enfantRepository.findById(id);

        if (enfant == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        enfant.setName(updated.getName());
        enfant.setFirst_name(updated.getFirst_name());
        enfant.setGender(updated.getGender());
        enfant.setDate_of_birth(updated.getDate_of_birth());
        enfant.setEmail_parent1(updated.getEmail_parent1());
        enfant.setEmail_parent2(updated.getEmail_parent2());
        enfant.setLegal_responsible_phone1(updated.getLegal_responsible_phone1());
        enfant.setLegal_responsible_phone2(updated.getLegal_responsible_phone2());

        if (updated.getPai() != null && updated.getPai().getId() != null) {
            enfant.setPai(paiRepository.findById(updated.getPai().getId()));
        } else {
            enfant.setPai(null);
        }

        if (updated.getRegimeAlimentaire() != null && updated.getRegimeAlimentaire().getId() != null) {
            enfant.setRegimeAlimentaire(regimeAlimentaireRepository.findById(updated.getRegimeAlimentaire().getId()));
        } else {
            enfant.setRegimeAlimentaire(null);
        }

        return Response.ok(enfant).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        boolean deleted = enfantRepository.deleteById(id);

        return deleted ? Response.noContent().build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }



    // ============================
    // ==  PAI CRUD
    // ============================

    @GET
    @Path("/pai")
    public List<Pai> getAllPai() {
        return paiRepository.listAll();
    }

    @GET
    @Path("/pai/{id}")
    public Pai getPaiById(@PathParam("id") Long id) {
        return paiRepository.findById(id);
    }

    @POST
    @Path("/pai")
    @Transactional
    public Response createPai(Pai pai) {
        paiRepository.persist(pai);
        return Response.status(Response.Status.CREATED).entity(pai).build();
    }

    @PUT
    @Path("/pai/{id}")
    @Transactional
    public Response updatePai(@PathParam("id") Long id, Pai updated) {
        Pai pai = paiRepository.findById(id);

        if (pai == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        pai.setName_pai(updated.getName_pai());
        pai.setRemark(updated.getRemark());

        return Response.ok(pai).build();
    }

    @DELETE
    @Path("/pai/{id}")
    @Transactional
    public Response deletePai(@PathParam("id") Long id) {
        boolean deleted = paiRepository.deleteById(id);
        return deleted ? Response.noContent().build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }



    // ============================
    // ==  REGIME ALIMENTAIRE CRUD
    // ============================

    @GET
    @Path("/regime")
    public List<RegimeAlimentaire> getAllRegimes() {
        return regimeAlimentaireRepository.listAll();
    }

    @GET
    @Path("/regime/{id}")
    public RegimeAlimentaire getRegimeById(@PathParam("id") Long id) {
        return regimeAlimentaireRepository.findById(id);
    }

    @POST
    @Path("/regime")
    @Transactional
    public Response createRegime(RegimeAlimentaire regime) {
        regimeAlimentaireRepository.persist(regime);
        return Response.status(Response.Status.CREATED).entity(regime).build();
    }

    @PUT
    @Path("/regime/{id}")
    @Transactional
    public Response updateRegime(@PathParam("id") Long id, RegimeAlimentaire updated) {
        RegimeAlimentaire regime = regimeAlimentaireRepository.findById(id);

        if (regime == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        regime.setName(updated.getName());

        return Response.ok(regime).build();
    }

    @DELETE
    @Path("/regime/{id}")
    @Transactional
    public Response deleteRegime(@PathParam("id") Long id) {
        boolean deleted = regimeAlimentaireRepository.deleteById(id);
        return deleted ? Response.noContent().build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }
}
