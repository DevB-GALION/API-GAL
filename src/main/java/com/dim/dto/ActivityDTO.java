package com.dim.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
public class ActivityDTO {
    public long id;
    public String name;
    public Date startDate;
    public Date endDate;
    public String lieu;
    public int activityTypeId;
    public int activityLocationId;
}
