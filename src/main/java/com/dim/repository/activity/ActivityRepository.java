package com.dim.repository.activity;

import com.dim.entity.activity.Activity;
import com.dim.entity.user.Animateur;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ActivityRepository implements PanacheRepository<Activity> {
    public List<Animateur> findAnimateurByActivity(Long id) {
        return getEntityManager()
                .createQuery(
                        "SELECT anim FROM Activity a JOIN a.animateur anim WHERE a.id = :id",
                        Animateur.class
                )
                .setParameter("id", id)
                .getResultList();
    }
}
