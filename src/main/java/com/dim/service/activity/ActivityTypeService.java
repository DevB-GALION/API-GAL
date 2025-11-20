package com.dim.service.activity;

import com.dim.entity.activity.ActivityType;
import com.dim.repository.activity.ActivityTypeRepository;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ActivityTypeService {
    @Inject
    ActivityTypeRepository activityTypeRepository;

    @Transactional
    public List<ActivityType> findAll(){
        return this.activityTypeRepository.listAll();
    }

    @Transactional
    public ActivityType findById(Long id){
        return this.activityTypeRepository.findById(id);
    }

    @Transactional
    public ActivityType createActivityType(ActivityType activityType){
        this.activityTypeRepository.persist(activityType);
        return activityType;
    }

    @Transactional
    public ActivityType updateActivityType(Long id, ActivityType activityTypeData){
        try{
            ActivityType activityType = this.activityTypeRepository.findById(id);
            if (activityType != null){
                activityType.setName(activityTypeData.getName());
                activityType.setBaignade(activityTypeData.getBaignade());
                this.activityTypeRepository.persist(activityType);
                return activityType;
            }
        }catch (Exception e){
            Log.error("Erreur : " + e.getMessage());
        }
        return null;
    }

    @Transactional
    public Boolean deleteActivityType(Long id){
        Boolean isSuccess = false;
        try{
            ActivityType activityType = this.activityTypeRepository.findById(id);
            if(activityType != null){
                this.activityTypeRepository.delete(activityType);
            }
            isSuccess = true;
        }catch (Exception e){
            Log.error("Erreur : " + e.getMessage());
        }
        return isSuccess;
    }
}
