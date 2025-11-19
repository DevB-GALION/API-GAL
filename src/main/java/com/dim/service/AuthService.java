package com.dim.service;

import com.dim.entity.role.Role;
import com.dim.entity.role.RoleEnum;
import com.dim.entity.user.User;
import com.dim.repository.UserRepository;
import io.quarkus.elytron.security.common.BcryptUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static io.quarkus.arc.ComponentsProvider.LOG;

@ApplicationScoped
public class AuthService {

    @Inject
    UserRepository userRepository;

    @Inject
    RoleService roleService;

    @Transactional
    public Boolean register(String name, String email, String password) {
        try{
            User newUser = new User();

            User userAlreadyExists = userRepository.find("email", email).firstResult();
            if (userAlreadyExists != null) {
                return false;
            }

            newUser.name = name;
            newUser.email = email;
            newUser.password = password;

            List<Role> roles = new ArrayList<>();
            roles.add(roleService.findByName(RoleEnum.USER));
            newUser.role = roles;

            newUser.password = BcryptUtil.bcryptHash(password);

            userRepository.persist(newUser);
            LOG.info("Utilisateur ajouté : " + name + " (" + email + ")");
            return true;
        }
        catch (Exception e){
            LOG.error("Erreur lors de l'ajout de l'utilisateur : " + name, e);
            return false;
        }
    }
}
