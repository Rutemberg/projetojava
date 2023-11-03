package com.projetojava.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "funcionario")
public class Funcionario extends Pessoa {
    private String matricula;
    private String cargo;    
    private Double salario;

}
