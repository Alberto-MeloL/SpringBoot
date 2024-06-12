package br.patrimonio.patrimonio_senai.Model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Responsavel implements Serializable{

    @Id
    private Long id;

    private String nome;
    private String cpf;
    private String email;
    
}