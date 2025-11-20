package com.dim.service.group;

import com.dim.entity.group.TrancheAge;
import com.dim.repository.group.TrancheAgeRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class TrancheAgeService {
    @Inject
    TrancheAgeRepository trancheAgeRepository;

    @Transactional
    public List<TrancheAge> findAll(){
        return this.trancheAgeRepository.listAll();
    }

    @Transactional
    public TrancheAge findById(Long id){
        return this.trancheAgeRepository.findById(id);
    }

    @Transactional
    public TrancheAge createTrancheAge(TrancheAge trancheAge){
        this.trancheAgeRepository.persist(trancheAge);
        return trancheAge;
    }

    @Transactional
    public TrancheAge updateTrancheAge(Long id, TrancheAge trancheAgeData){
        TrancheAge trancheAge = this.trancheAgeRepository.findById(id);
        if(trancheAge != null){
            trancheAge.setName(trancheAgeData.getName());
            trancheAge.setMinAge(trancheAgeData.getMinAge());
            trancheAge.setMaxAge(trancheAgeData.getMaxAge());
            this.trancheAgeRepository.persist(trancheAge);
        }
        return trancheAge;
    }

    @Transactional
    public void deleteTrancheAge(Long id){
        TrancheAge trancheAge = this.trancheAgeRepository.findById(id);
        if(trancheAge != null){
            this.trancheAgeRepository.delete(trancheAge);
        }
    }
}
