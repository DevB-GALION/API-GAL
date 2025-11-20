package com.dim.service.group;

import com.dim.entity.group.TrancheAge;
import com.dim.repository.group.TrancheAgeRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class TrancheAgeService {
    @Inject
    TrancheAgeRepository trancheAgeRepository;

    public TrancheAge findById(Long id){
        return this.trancheAgeRepository.findById(id);
    }
}
