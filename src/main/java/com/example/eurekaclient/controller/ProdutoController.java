package com.example.eurekaclient.controller;

import com.example.eurekaclient.model.Produto;
import com.example.eurekaclient.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> getProdutos() {
        return produtoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Produto> getProduto(@PathVariable Long id) {
        return produtoService.findById(id);
    }

    @PostMapping
    public Produto addProduto(@RequestBody Produto produto) {
        return produtoService.save(produto);
    }

    @DeleteMapping("/{id}")
    public void deleteProduto(@PathVariable Long id) {
        produtoService.delete(id);
    }
}
