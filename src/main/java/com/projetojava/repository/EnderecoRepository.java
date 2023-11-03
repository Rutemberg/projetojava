package com.projetojava.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetojava.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, UUID> {

}
