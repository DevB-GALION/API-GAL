package com.dim.service.group;

import com.dim.entity.group.PeriodeAL;
import com.dim.repository.group.PeriodeALRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class PeriodeALService {
    @Inject
    PeriodeALRepository periodeALRepository;

    @Transactional
    public List<PeriodeAL> findAll(){
        return this.periodeALRepository.listAll();
    }

    @Transactional
    public PeriodeAL findById(Long id){
        return this.periodeALRepository.findById(id);
    }

    @Transactional
    public PeriodeAL createPeriodeAL(PeriodeAL periodeAL){
        this.periodeALRepository.persist(periodeAL);
        return periodeAL;
    }

    @Transactional
    public PeriodeAL updatePeriodeAL(Long id, PeriodeAL periodeALData){
        PeriodeAL periodeAL = this.periodeALRepository.findById(id);
        if(periodeAL != null){
            periodeAL.setName(periodeALData.getName());
            periodeAL.setEndDate(periodeALData.getEndDate());
            periodeAL.setStartDate(periodeALData.getStartDate());
            this.periodeALRepository.persist(periodeAL);
        }
        return periodeAL;
    }

    @Transactional
    public void deletePeriodeAL(Long id){
        PeriodeAL periodeAL = this.periodeALRepository.findById(id);
        if(periodeAL != null){
            this.periodeALRepository.delete(periodeAL);
        }
    }
}
