package com.projetojava.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_funcionario_id", referencedColumnName = "id")
    private List<Endereco> enderecos;
}
