package com.projetojava.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetojava.model.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
    List<Fornecedor> findByNomeContains(String nome);

}
