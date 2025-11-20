package com.dim.service.activity;

import com.dim.repository.activity.DeplacementRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class DeplacementService {
    @Inject
    DeplacementRepository deplacementRepository;
}
