package com.projetojava.service;

import com.projetojava.model.Produto;
import com.projetojava.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Produto encontrarProdutoPorId(UUID id) throws Exception {
        return produtoRepository.findById(id).orElseThrow(()-> new Exception("Produto nao encontrado")); 
    }

    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void excluirProduto(UUID id) {
        produtoRepository.deleteById(id);
    }
}
