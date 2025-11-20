package com.dim.service.activity;

import com.dim.entity.activity.ActivityLocation;
import com.dim.repository.activity.ActivityLocationRepository;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ActivityLocationService {
    @Inject
    ActivityLocationRepository activityLocationRepository;

    @Transactional
    public List<ActivityLocation> findAll(){
        return this.activityLocationRepository.listAll();
    }

    @Transactional
    public ActivityLocation findById(Long id){
        return this.activityLocationRepository.findById(id);
    }

    @Transactional
    public ActivityLocation createActivityLocation(ActivityLocation activityLocation){
        this.activityLocationRepository.persist(activityLocation);
        return activityLocation;
    }

    @Transactional
    public ActivityLocation updateActivityLocation(Long id, ActivityLocation activityLocationData){
        try{
            ActivityLocation activityLocation = this.activityLocationRepository.findById(id);
            if(activityLocation != null){
                activityLocation.setName(activityLocationData.getName());
                activityLocation.setCapacityMax(activityLocationData.getCapacityMax());
                activityLocation.setEmplacement(activityLocationData.getEmplacement());
                this.activityLocationRepository.persist(activityLocation);
                return activityLocation;
            }
        }catch (Exception e){
            Log.error("Erreur : " + e.getMessage());
        }
        return null;
    }

    @Transactional
    public Boolean deleteActivityLocation(Long id){
        Boolean isSuccess = false;
        try{
            this.activityLocationRepository.deleteById(id);
            isSuccess = true;
        }catch (Exception e){
            Log.error("Erreur : " + e.getMessage());
        }

        return isSuccess;
    }
}
