package com.projetojava.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojava.repository.FornecedorRepository;
import com.projetojava.model.Fornecedor;

@Service
public class FornecedorService {
    private final FornecedorRepository fornecedorRepository;

    @Autowired
    public FornecedorService(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    public List<Fornecedor> listarFornecedores() {
        return fornecedorRepository.findAll();
    }

    public Fornecedor encontrarFornecedorPorId(UUID id) throws Exception {
        return fornecedorRepository.findById(id).orElseThrow(() -> new Exception("Fornecedor nao encontrado"));
    }

    public Fornecedor salvarFornecedor(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public void excluirFornecedor(UUID id) {
        fornecedorRepository.deleteById(id);
    }
}
