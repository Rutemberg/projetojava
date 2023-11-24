package com.projetojava.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetojava.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    List<Funcionario> findByNomeContains(String nome);
}
