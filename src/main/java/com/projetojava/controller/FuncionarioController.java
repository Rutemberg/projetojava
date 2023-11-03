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

import com.projetojava.model.Funcionario;
import com.projetojava.service.FuncionarioService;

@RestController
@RequestMapping(value = "/funcionario")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @Autowired
    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> listarFuncionarios() {
        return new ResponseEntity<>(funcionarioService.listarFuncionarios(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> encontrarFuncionarioPorId(@PathVariable Long id) throws Exception {
        try {
            return new ResponseEntity<>(funcionarioService.encontrarFuncionarioPorId(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Funcionario> salvarFuncionario(@RequestBody Funcionario funcionario) {
        return new ResponseEntity<>(funcionarioService.salvarFuncionario(funcionario), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> alterarFuncionario(@PathVariable Long id, @RequestBody Funcionario novoFuncionario)
            throws Exception {
        try {
            Funcionario alterarFuncionario = funcionarioService.encontrarFuncionarioPorId(id);

            alterarFuncionario.setNome(novoFuncionario.getNome());
            alterarFuncionario.setCpf(novoFuncionario.getCpf());
            alterarFuncionario.setTelefone(novoFuncionario.getTelefone());
            alterarFuncionario.setCargo(novoFuncionario.getCargo());
            alterarFuncionario.setMatricula(novoFuncionario.getMatricula());
            alterarFuncionario.setSalario(novoFuncionario.getSalario());

            funcionarioService.salvarFuncionario(alterarFuncionario);

            return new ResponseEntity<>(alterarFuncionario, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void excluirFuncionario(@PathVariable Long id) {
        funcionarioService.excluirFuncionario(id);
    }

}
