package com.dim.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GroupDTO {
    public int id;
    public String name;
    public int periodeAlId;
    public int trancheAgeId;
}