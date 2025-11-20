package com.dim.service;

import com.dim.entity.role.Role;
import com.dim.entity.role.RoleEnum;
import com.dim.entity.user.User;
import com.dim.repository.UserRepository;
import com.dim.security.jwt.JwtUtil;
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
    UserService userService;

    @Inject
    RoleService roleService;

    @Transactional
    public Boolean register(String name, String email, String password) {
        try{
            User newUser = new User();

            User userAlreadyExists = userService.findByEmail(email);
            if (userAlreadyExists != null) {
                return false;
            }

            newUser.setName(name);
            newUser.setEmail(email);

            List<Role> roles = new ArrayList<>();
            roles.add(roleService.findByName(RoleEnum.USER));
            newUser.setRole(roles);

            newUser.setPassword(BcryptUtil.bcryptHash(password));

            userService.createUser(newUser);
            LOG.info("Utilisateur ajouté : " + name + " (" + email + ")");
            return true;
        }
        catch (Exception e){
            LOG.error("Erreur lors de l'ajout de l'utilisateur : " + name, e);
            return false;
        }
    }

    @Transactional
    public String login(String email, String password){
        try{
            User user = userService.findByEmail(email);

            if(user != null && BcryptUtil.matches(password, user.password)){
                return JwtUtil.generateToken(user.name, user.role, 20000);
            }else{
                return null;
            }
        }catch (Exception e){
            return e.getMessage();
        }
    }
}
