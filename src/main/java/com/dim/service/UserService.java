package com.dim.service;

import com.dim.entity.user.User;
import com.dim.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;


import java.util.List;

import static io.quarkus.arc.ComponentsProvider.LOG;

@ApplicationScoped
public class UserService {
    @Inject
    UserRepository userRepository;

    @Inject
    RoleService roleService;

    public List<User> findAll() {
        return userRepository.listAll();
    }

    public User findByEmail(String email) {
        return userRepository.find("email", email).firstResult();
    }
    @Transactional
    public void addUser(String name, String email, String password ) {
        try{

            User newUser = new User();
            newUser.name = name;
            newUser.email = email;
            newUser.password = password;
            userRepository.persist(newUser);
            LOG.info("Utilisateur ajouté : " + name + " (" + email + ")");

        }
        catch (Exception e){
            LOG.error("Erreur lors de l'ajout de l'utilisateur : " + name, e);
            throw e; // ou gérer l'exception selon ton besoin
        }
    }

    @Transactional
    public void delete(Long id) {
        try {
            boolean deleted = userRepository.deleteById(id);

            if (!deleted) {
                LOG.warn("Tentative de suppression d'un utilisateur inexistant : ID " + id);
            } else {
                LOG.info("Utilisateur supprimé : ID " + id);
            }

        } catch (Exception e) {
            LOG.error("Erreur lors de la suppression de l'utilisateur ID : " + id, e);
            throw e;
        }
    }

    public void createUser(User user) {
        userRepository.persist(user);
    }

    @Transactional
    public User update(User updatedUser) {
        try {
            User existingUser = userRepository.findById(updatedUser.id);

            if (existingUser == null) {
                LOG.warn("Utilisateur introuvable : ID " + updatedUser.id);
                return null;
            }

            existingUser.name = updatedUser.name;
            existingUser.email = updatedUser.email;
            existingUser.password = updatedUser.password;

            LOG.info("Utilisateur mis à jour : ID " + updatedUser.id);

            return existingUser;

        } catch (Exception e) {
            LOG.error("Erreur lors de la mise à jour de l'utilisateur : " + updatedUser.id, e);
            throw e;
        }
    }

    @Transactional
    public User getUserById(Long id){
        return userRepository.findById(id);
    }
}


