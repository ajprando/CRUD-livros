package com.crud.livros.services;

import com.crud.livros.dto.LivrosDTO;
import com.crud.livros.entities.Livro;
import com.crud.livros.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public ResponseEntity<Livro> createLivro(@RequestBody Livro livro){
        Livro newLivro = livroRepository.save(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(newLivro);
    }

    public ResponseEntity<List<Livro>> getAllLivros(){
        List<Livro> allLivros = livroRepository.findAll();
        return ResponseEntity.ok(allLivros);
    }

    public ResponseEntity<Optional<Livro>> getLivroById(@PathVariable Long id){
        Optional<Livro> getLivroById = livroRepository.findById(id);
        return ResponseEntity.ok(getLivroById);
    }

    public ResponseEntity<?> deleteLivroById(@PathVariable Long id){
        livroRepository.deleteById(id);
        return ResponseEntity.ok("Deletedo com sucesso!");
    }

    public ResponseEntity<Livro> updateLivroById(@RequestBody Livro updateLivro, @PathVariable Long id){
        return livroRepository.findById(id).map(livro -> {
            livro.setNome(updateLivro.getNome());
            livro.setAutor(updateLivro.getAutor());
            livro.setPreco(updateLivro.getPreco());
            livro.setQuantidadeEmEstoque((updateLivro.getQuantidadeEmEstoque()));

            Livro updatedLivro = livroRepository.save(livro);
            return ResponseEntity.ok(updateLivro);
        }).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }
}
