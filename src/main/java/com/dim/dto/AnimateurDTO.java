package com.dim.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
public class AnimateurDTO {
    public long id;
    public String lastname;
    public String firstname;
    public String genre;
    public Date birthDate;
    public String diplome;
    public int userId;
}
