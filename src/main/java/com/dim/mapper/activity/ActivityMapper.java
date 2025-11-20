package com.dim.mapper.activity;

import com.dim.dto.ActivityDTO;
import com.dim.entity.activity.Activity;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface ActivityMapper {

    @Mapping(target = "activityType", expression = "java(fetcher.getActivityTypeById(dto.activityTypeId))")
    @Mapping(target = "activityLocation", expression = "java(fetcher.getActivityLocationById(dto.activityLocationId))")
    Activity toEntity(ActivityDTO dto, @Context ActivityFetcher fetcher);

    @Mapping(target = "activityTypeId", source = "activityType.id")
    @Mapping(target = "activityLocationId", source = "activityLocation.id")
    ActivityDTO toDTO(Activity activity);
}
