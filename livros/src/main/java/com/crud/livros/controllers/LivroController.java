package com.crud.livros.controllers;

import com.crud.livros.entities.Livro;
import com.crud.livros.services.LivroService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @Operation(summary = "Criar um novo livro.")
    @PostMapping("/create-livro")
    public ResponseEntity<Livro> createLivro(@RequestBody Livro livro){
        return livroService.createLivro(livro);
    }

    @Operation(summary = "Listar todos os livros.")
    @GetMapping("/list-all-livros")
    public ResponseEntity<List<Livro>> getAllLivros(){
        return livroService.getAllLivros();
    }

    @Operation(summary = "Listar livros por Id.")
    @GetMapping("/list-livros/{id}")
    public ResponseEntity<Optional<Livro>> getLivroById(@PathVariable Long id){
        return livroService.getLivroById(id);
    }

    @Operation(summary = "Deletar livro por Id.")
    @DeleteMapping("/delete-by-id/{id}")
    public ResponseEntity<?> deleteLivroById(@PathVariable Long id){
        return livroService.deleteLivroById(id);
    }

    @Operation(summary = "Atualizar livro por Id.")
    @PutMapping("/update-by-id/{id}")
    public void updateLivro(@RequestBody Livro livro, @PathVariable Long id){}
}
