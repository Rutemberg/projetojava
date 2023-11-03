package com.projetojava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojava.repository.ClienteRepository;
import com.projetojava.model.Cliente;

@Service
public class ClienteService {
    private final ClienteRepository clienterepository;

    @Autowired
    public ClienteService(ClienteRepository clienterepository) {
        this.clienterepository = clienterepository;
    }

    public List<Cliente> listarClientes() {
        return clienterepository.findAll();
    }

    public Cliente encontrarClientePorId(Long id) throws Exception {
        return clienterepository.findById(id).orElseThrow(() -> new Exception("Cliente nao encontrado"));
    }

    public Cliente salvarCliente(Cliente cliente) {
        return clienterepository.save(cliente);
    }

    public void excluirCliente(Long id) {
        clienterepository.deleteById(id);
    }
}
