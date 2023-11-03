package com.projetojava.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetojava.model.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, UUID> {

}
