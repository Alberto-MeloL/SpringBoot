package br.com.alberto.apirest_senai.Model;

import java.io.Serializable;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

public class Responsavel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nonnull
    private String nome;

    @OneToOne(mappedBy = "responsavel")
    private Ambiente ambiente;
    
}
