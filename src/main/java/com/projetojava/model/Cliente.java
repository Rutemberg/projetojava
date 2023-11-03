package com.projetojava.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "cliente")
@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends Pessoa {
    private String email;
    private Integer pontosfidelidade;
}
