package com.dim.service.group;

import com.dim.entity.group.PeriodeAL;
import com.dim.repository.group.PeriodeALRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PeriodeALService {
    @Inject
    PeriodeALRepository periodeALRepository;

    public PeriodeAL findById(Long id){
        return this.periodeALRepository.findById(id);
    }
}
