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
}


