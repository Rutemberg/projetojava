package com.projetojava.controller;

import com.projetojava.model.Produto;
import com.projetojava.service.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping()
    public ResponseEntity<List<Produto>> listarProdutos() {
        return new ResponseEntity<>(produtoService.listarProdutos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> encontrarProdutoPorId(@PathVariable Long id) throws Exception {
        try {
            return new ResponseEntity<>(produtoService.encontrarProdutoPorId(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping
    public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto) {
        return new ResponseEntity<>(produtoService.salvarProduto(produto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> alterarProduto(@PathVariable Long id, @RequestBody Produto novoProduto)
            throws Exception {
        try {
            Produto alterarProduto = produtoService.encontrarProdutoPorId(id);

            alterarProduto.setNome(novoProduto.getNome());
            alterarProduto.setPreco(novoProduto.getPreco());
            alterarProduto.setQuantidade(novoProduto.getQuantidade());
            alterarProduto.setCodigobarra(novoProduto.getCodigobarra());

            produtoService.salvarProduto(alterarProduto);

            return new ResponseEntity<>(alterarProduto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void excluirProduto(@PathVariable Long id) {
        produtoService.excluirProduto(id);
    }
}
