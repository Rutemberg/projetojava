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
import org.springframework.web.bind.annotation.RestController;

import com.projetojava.model.Fornecedor;
import com.projetojava.service.FornecedorService;

@RestController
@RequestMapping(value = "/fornecedor")
public class FornecedorController {

    private final FornecedorService fornecedorService;

    @Autowired
    public FornecedorController(FornecedorService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }

    @GetMapping
    public ResponseEntity<List<Fornecedor>> listarFornecedores() {
        return new ResponseEntity<>(fornecedorService.listarFornecedores(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> econtrarFornecedorPorId(@PathVariable Long id) throws Exception {
        try {
            return new ResponseEntity<>(fornecedorService.encontrarFornecedorPorId(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Fornecedor> salvarFornecedor(@RequestBody Fornecedor fornecedor) {
        return new ResponseEntity<>(fornecedorService.salvarFornecedor(fornecedor), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> alterarFornecedor(@PathVariable Long id, @RequestBody Fornecedor novoFornecedor)
            throws Exception {
        try {
            Fornecedor alterarFornecedor = fornecedorService.encontrarFornecedorPorId(id);

            alterarFornecedor.setNome(novoFornecedor.getNome());
            alterarFornecedor.setCnpj(novoFornecedor.getCnpj());
            alterarFornecedor.setTelefone(novoFornecedor.getTelefone());

            fornecedorService.salvarFornecedor(alterarFornecedor);

            return new ResponseEntity<>(alterarFornecedor, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void excluirFornecedor(@PathVariable Long id) {
        fornecedorService.excluirFornecedor(id);
    }

}
