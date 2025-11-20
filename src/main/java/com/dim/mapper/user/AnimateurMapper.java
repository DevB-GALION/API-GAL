package com.dim.mapper.user;

import com.dim.dto.AnimateurDTO;
import com.dim.entity.user.Animateur;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface AnimateurMapper {
    @Mapping(target = "user", expression = "java(fetcher.getUserById(dto.userId))")
    Animateur toEntity(AnimateurDTO dto, @Context AnimateurFetcher fetcher);

    @Mapping(target = "userId", source = "user.id")
    AnimateurDTO toDTO(Animateur animateur);
}
