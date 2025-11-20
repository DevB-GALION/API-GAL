package com.dim.service;

import com.dim.entity.user.Animateur;
import com.dim.repository.AnimateurRepository;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class AnimateurService {
    @Inject
    AnimateurRepository animateurRepository;

    @Transactional
    public List<Animateur> findAll(){
        return this.animateurRepository.listAll();
    }

    @Transactional
    public Animateur findById(Long id){
        return this.animateurRepository.findById(id);
    }

    @Transactional
    public Animateur createAnimateur(Animateur animateur){
        this.animateurRepository.persist(animateur);
        return animateur;
    }

    @Transactional
    public Animateur updateAnimateur(Long id, Animateur animateurData){
        try{
            Animateur animateur = this.animateurRepository.findById(id);
            if(animateur != null){
                animateur.setLastname(animateurData.getLastname());
                animateur.setFirstname(animateurData.getFirstname());
                animateur.setGenre(animateurData.getGenre());
                animateur.setBirthDate(animateurData.getBirthDate());
                animateur.setDiplome(animateurData.getDiplome());
                this.animateurRepository.persist(animateur);
            }
            return animateur;
        }catch (Exception e){
            Log.error("Erreur : " + e.getMessage());
            return null;
        }
    }

    @Transactional
    public Boolean deleteAnimateur(Long id){
        Boolean isSuccess = false;
        try{
            Animateur animateur = this.animateurRepository.findById(id);
            if(animateur != null){
                this.animateurRepository.delete(animateur);
            }
            isSuccess = true;
        }catch (Exception e){
            Log.error("Erreur : " + e.getMessage());
        }
        return isSuccess;
    }
}
