package com.dim.entity.enfant;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Regime_Alimentaire")
@Setter
@Getter
@NoArgsConstructor
public class RegimeAlimentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
}
