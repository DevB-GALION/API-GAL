package com.dim.service.activity;

import com.dim.entity.activity.Activity;
import com.dim.entity.user.Animateur;
import com.dim.repository.activity.ActivityRepository;
import com.dim.service.AnimateurService;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ActivityService {
    @Inject
    ActivityRepository activityRepository;

    @Inject
    AnimateurService animateurService;

    @Transactional
    public List<Activity> findAll(){
        return this.activityRepository.listAll();
    }

    @Transactional
    public Activity findById(Long id){
        return this.activityRepository.findById(id);
    }
    @Transactional
    public Activity createActivity(Activity activity){
        activity.setId(null);
        activityRepository.persist(activity);
        return activity;
    }


    @Transactional
    public Activity updateActivity(Long id, Activity activityData){
        try{
            Activity activity = this.activityRepository.findById(id);
            if(activity != null){
                activity.setName(activityData.getName());
                activity.setActivityLocation(activityData.getActivityLocation());
                activity.setActivityType(activityData.getActivityType());
                activity.setStartDate(activityData.getStartDate());
                activity.setEndDate(activityData.getEndDate());
                activity.setLieu(activityData.getLieu());
                activity.setAnimateur(activityData.getAnimateur());
                this.activityRepository.persist(activity);
                return activity;
            }
        }catch (Exception e){
            Log.error("Erreur : " + e.getMessage());
        }
        return null;
    }

    @Transactional
    public Boolean deleteActivity(Long id){
        Boolean isSuccess = false;
        try{
            this.activityRepository.deleteById(id);
            isSuccess = true;
        }catch (Exception e){
            Log.error("Erreur : " + e.getMessage());
        }

        return isSuccess;
    }

    @Transactional
    public Boolean addAnimateurToActivity(Long animateurId, Long activityId){
        Boolean isSuccess = false;
        try{
            Activity activity = this.activityRepository.findById(activityId);
            if(activity != null){
                activity.getAnimateur().add(animateurService.findById(animateurId));
                this.activityRepository.persist(activity);
                isSuccess = true;
            }
        }catch (Exception e){
            Log.error("Erreur : " + e.getMessage());
        }
        return isSuccess;
    }

    @Transactional
    public Boolean removeAnimateurFromActivity(Long activityId, Long animateurId){
        Boolean isSuccess = false;
        try{
            Activity activity = this.activityRepository.findById(activityId);
            if(activity != null){
                activity.getAnimateur().remove(animateurService.findById(animateurId));
                this.activityRepository.persist(activity);
                isSuccess = true;
            }
        }catch (Exception e){
            Log.error("Erreur : " + e.getMessage());
        }

        return isSuccess;
    }

    @Transactional
    public List<Animateur> getAnimateursFromActivity(Long activityId){
        return this.activityRepository.findAnimateurByActivity(activityId);
    }
}
