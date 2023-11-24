package com.projetojava.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetojava.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByNomeContains(String nome);
}
