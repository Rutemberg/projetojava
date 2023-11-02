package com.projetojava.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetojava.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {
}
