package com.dim.mapper.group;

import com.dim.entity.group.PeriodeAL;
import com.dim.entity.group.TrancheAge;
import com.dim.service.group.PeriodeALService;
import com.dim.service.group.TrancheAgeService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class GroupFetcher {
    @Inject
    PeriodeALService periodeALService;

    @Inject
    TrancheAgeService trancheAgeService;

    public PeriodeAL getPeriodeAlById(int id) {
        return periodeALService.findById((long) id);
    }

    public TrancheAge getTrancheAgeById(int id) {
        return trancheAgeService.findById((long) id);
    }
}
