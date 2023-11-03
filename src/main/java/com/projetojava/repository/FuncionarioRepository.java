package com.projetojava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetojava.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
