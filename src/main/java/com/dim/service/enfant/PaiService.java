package com.dim.service;

import com.dim.entity.enfant.Pai;
import com.dim.repository.enfant.PaiRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class PaiService {

    @Inject
    PaiRepository paiRepository;

    public List<Pai> getAll() {
        return paiRepository.listAll();
    }

    public Pai getById(Long id) {
        return paiRepository.findById(id);
    }

    @Transactional
    public Pai create(Pai pai) {
        paiRepository.persist(pai);
        return pai;
    }

    @Transactional
    public Pai update(Long id, Pai data) {
        Pai pai = paiRepository.findById(id);
        if (pai == null) return null;

        pai.setName_pai(data.getName_pai());
        pai.setRemark(data.getRemark());

        return pai;
    }

    @Transactional
    public boolean delete(Long id) {
        return paiRepository.deleteById(id);
    }
}
