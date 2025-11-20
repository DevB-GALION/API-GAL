package com.dim.entity.enfant;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Pai")
@Setter
@Getter
@NoArgsConstructor
public class Pai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name_pai;
    public String remark;
}
