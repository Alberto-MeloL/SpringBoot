package br.com.alberto.apirest_senai.Model;

import java.io.Serializable;
import java.util.List;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Ambiente implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nonnull
    private String nome;

    @OneToMany(mappedBy = "ambiente")
    private List<AtivosPatrimoniais> ativos;

    @OneToOne
    @JoinColumn(name = "responsavel_id", nullable = false)
    private Responsavel responsavel;

    
}