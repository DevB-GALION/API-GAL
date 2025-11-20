package com.dim.mapper.group;

import com.dim.dto.GroupDTO;
import com.dim.entity.group.Group;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface GroupMapper {

    @Mapping(target = "periodeAL", expression = "java(fetcher.getPeriodeAlById(dto.periodeAlId))")
    @Mapping(target = "trancheAge", expression = "java(fetcher.getTrancheAgeById(dto.trancheAgeId))")
    Group toEntity(GroupDTO dto, @Context GroupFetcher fetcher);

    @Mapping(target = "periodeAlId", source = "periodeAL.id")
    @Mapping(target = "trancheAgeId", source = "trancheAge.id")
    GroupDTO toDTO(Group group);
}