package com.crud.livros.dto;
import lombok.Data;

@Data
public class LivrosDTO {


    private Long id;
    private String nome;
    private String autor;
    private Double preco;
    private Integer quantidadeEmEstoque;
}
