package com.dim.service;

import com.dim.entity.enfant.Enfant;
import com.dim.entity.enfant.Pai;
import com.dim.entity.enfant.RegimeAlimentaire;
import com.dim.repository.enfant.EnfantRepository;
import com.dim.repository.enfant.PaiRepository;
import com.dim.repository.enfant.RegimeAlimentaireRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class EnfantService {

    @Inject
    EnfantRepository enfantRepository;

    @Inject
    PaiRepository paiRepository;

    @Inject
    RegimeAlimentaireRepository regimeAlimentaireRepository;

    public List<Enfant> getAll() {
        return enfantRepository.listAll();
    }

    public Enfant getById(Long id) {
        return enfantRepository.findById(id);
    }

    @Transactional
    public Enfant create(Enfant enfant) {

        if (enfant.getPai() != null && enfant.getPai().getId() != null) {
            Pai pai = paiRepository.findById(enfant.getPai().getId());
            enfant.setPai(pai);
        }

        if (enfant.getRegimeAlimentaire() != null && enfant.getRegimeAlimentaire().getId() != null) {
            RegimeAlimentaire regime = regimeAlimentaireRepository.findById(enfant.getRegimeAlimentaire().getId());
            enfant.setRegimeAlimentaire(regime);
        }

        enfantRepository.persist(enfant);
        return enfant;
    }

    @Transactional
    public Enfant update(Long id, Enfant data) {
        Enfant enfant = enfantRepository.findById(id);
        if (enfant == null) return null;

        enfant.setName(data.getName());
        enfant.setFirst_name(data.getFirst_name());
        enfant.setGender(data.getGender());
        enfant.setDate_of_birth(data.getDate_of_birth());
        enfant.setEmail_parent1(data.getEmail_parent1());
        enfant.setEmail_parent2(data.getEmail_parent2());
        enfant.setLegal_responsible_phone1(data.getLegal_responsible_phone1());
        enfant.setLegal_responsible_phone2(data.getLegal_responsible_phone2());

        if (data.getPai() != null && data.getPai().getId() != null) {
            enfant.setPai(paiRepository.findById(data.getPai().getId()));
        } else {
            enfant.setPai(null);
        }

        if (data.getRegimeAlimentaire() != null && data.getRegimeAlimentaire().getId() != null) {
            enfant.setRegimeAlimentaire(regimeAlimentaireRepository.findById(data.getRegimeAlimentaire().getId()));
        } else {
            enfant.setRegimeAlimentaire(null);
        }

        return enfant;
    }

    @Transactional
    public boolean delete(Long id) {
        return enfantRepository.deleteById(id);
    }
}
