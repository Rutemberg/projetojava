package com.projetojava.dominio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetojava.dominio.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
