package com.dim.mapper.user;

import com.dim.entity.group.PeriodeAL;
import com.dim.entity.group.TrancheAge;
import com.dim.entity.user.User;
import com.dim.service.UserService;
import com.dim.service.group.PeriodeALService;
import com.dim.service.group.TrancheAgeService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AnimateurFetcher {
    @Inject
    UserService userService;

    public User getUserById(int id) {
        return this.userService.getUserById((long) id);
    }
}
