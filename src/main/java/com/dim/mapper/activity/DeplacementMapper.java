package com.dim.mapper.activity;

import com.dim.dto.DeplacementDTO;
import com.dim.entity.activity.Deplacement;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface DeplacementMapper {
    @Mapping(target = "activity", expression = "java(fetcher.getActivityById(dto.activityId))")
    Deplacement toEntity(DeplacementDTO dto, @Context DeplacementFetcher fetcher);

    @Mapping(target = "activityId", source = "activity.id")
    DeplacementDTO toDTO(Deplacement deplacement);
}
