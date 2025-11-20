package com.dim.service;

import com.dim.entity.enfant.RegimeAlimentaire;
import com.dim.repository.enfant.RegimeAlimentaireRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class RegimeAlimentaireService {

    @Inject
    RegimeAlimentaireRepository regimeRepository;

    public List<RegimeAlimentaire> getAll() {
        return regimeRepository.listAll();
    }

    public RegimeAlimentaire getById(Long id) {
        return regimeRepository.findById(id);
    }

    @Transactional
    public RegimeAlimentaire create(RegimeAlimentaire regime) {
        regimeRepository.persist(regime);
        return regime;
    }

    @Transactional
    public RegimeAlimentaire update(Long id, RegimeAlimentaire data) {
        RegimeAlimentaire regime = regimeRepository.findById(id);
        if (regime == null) return null;

        regime.setName(data.getName());
        return regime;
    }

    @Transactional
    public boolean delete(Long id) {
        return regimeRepository.deleteById(id);
    }
}
