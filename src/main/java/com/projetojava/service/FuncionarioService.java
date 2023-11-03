package com.projetojava.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojava.repository.FuncionarioRepository;
import com.projetojava.model.Funcionario;

@Service
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;

    @Autowired
    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Funcionario encontrarFuncionarioPorId(UUID id) throws Exception {
        return funcionarioRepository.findById(id).orElseThrow(() -> new Exception("Funcionario nao encontrado"));
    }

    public Funcionario salvarFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public void excluirFuncionario(UUID id) {
        funcionarioRepository.deleteById(id);
    }
}
