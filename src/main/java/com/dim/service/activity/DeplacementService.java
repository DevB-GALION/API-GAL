package com.dim.service.activity;

import com.dim.entity.activity.Deplacement;
import com.dim.repository.activity.DeplacementRepository;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class DeplacementService {
    @Inject
    DeplacementRepository deplacementRepository;

    @Transactional
    public List<Deplacement> findAll(){
        return this.deplacementRepository.listAll();
    }

    @Transactional
    public Deplacement findById(Long id){
        return this.deplacementRepository.findById(id);
    }

    @Transactional
    public Deplacement createDeplacement(Deplacement deplacement){
        this.deplacementRepository.persist(deplacement);
        return deplacement;
    }

    @Transactional
    public Deplacement updateDeplacement(Long id, Deplacement deplacementData){
        try{
            Deplacement deplacement = this.deplacementRepository.findById(id);
            if(deplacement != null){
                deplacement.setName(deplacementData.getName());
                deplacement.setDateArrivee(deplacementData.getDateArrivee());
                deplacement.setDateDepart(deplacementData.getDateDepart());
                deplacement.setLieuArrivee(deplacementData.getLieuArrivee());
                deplacement.setLieuDepart(deplacementData.getLieuDepart());
                deplacement.setActivity(deplacementData.getActivity());
                deplacement.setNbMax(deplacementData.getNbMax());
                this.deplacementRepository.persist(deplacement);
            }
            return deplacement;
        }catch (Exception e){
            Log.error("Erreur : " + e.getMessage());
        }
        return null;
    }

    @Transactional
    public Boolean deleteDeplacement(Long id){
        Boolean isSuccess = false;
        try{
            Deplacement deplacement = this.deplacementRepository.findById(id);
            if(deplacement != null){
                this.deplacementRepository.delete(deplacement);
                isSuccess = true;
            }
        }catch (Exception e){
            Log.error("Erreur : " + e.getMessage());
        }
        return isSuccess;
    }
}
