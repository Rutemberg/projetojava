package com.projetojava.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projetojava.model.Cliente;
import com.projetojava.service.ClienteService;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        return new ResponseEntity<>(clienteService.listarClientes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> encontrarClientePorId(@PathVariable Long id) throws Exception {
        try {
            return new ResponseEntity<>(clienteService.encontrarClientePorId(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Cliente>> encontrarClientePorNome(@RequestParam String nome) {
        return new ResponseEntity<>(clienteService.encontrarClientePorNome(nome), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Cliente> salvarCliente(@RequestBody Cliente cliente) {
        return new ResponseEntity<>(clienteService.salvarCliente(cliente), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> alterarCliente(@PathVariable Long id, @RequestBody Cliente novoCliente)
            throws Exception {
        try {
            Cliente alterarCliente = clienteService.encontrarClientePorId(id);

            alterarCliente.setNome(novoCliente.getNome());
            alterarCliente.setCpf(novoCliente.getCpf());
            alterarCliente.setTelefone(novoCliente.getTelefone());
            alterarCliente.setEmail(novoCliente.getEmail());
            alterarCliente.setPontosfidelidade(novoCliente.getPontosfidelidade());
            alterarCliente.setEnderecos(novoCliente.getEnderecos());

            clienteService.salvarCliente(alterarCliente);

            return new ResponseEntity<>(alterarCliente, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void excluirCliente(@PathVariable Long id) {
        clienteService.excluirCliente(id);
    }

}
