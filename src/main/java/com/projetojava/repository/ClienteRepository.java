package com.projetojava.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetojava.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNomeContains(String nome);
}
