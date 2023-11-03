package com.projetojava.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetojava.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, UUID> {

}
