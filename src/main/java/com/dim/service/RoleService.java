package com.dim.service;

import com.dim.entity.role.Role;
import com.dim.entity.role.RoleEnum;
import com.dim.repository.RoleRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class RoleService {

    @Inject
    RoleRepository roleRepository;

    @Transactional
    public Role findByName(RoleEnum name) {
        return roleRepository.find("name", name).firstResult();
    }
}
