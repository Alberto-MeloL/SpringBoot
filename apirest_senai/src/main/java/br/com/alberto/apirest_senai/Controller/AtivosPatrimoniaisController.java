package br.com.alberto.apirest_senai.Controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.alberto.apirest_senai.Model.AtivosPatrimoniais;
import br.com.alberto.apirest_senai.Repository.AtivosPatrimoniaisRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


// o que esta acontecendo aqui
@RestController
@RequestMapping("/ativos")
public class AtivosPatrimoniaisController {

    @Autowired
    private AtivosPatrimoniaisRepository repository;

    @GetMapping
    public List<AtivosPatrimoniais> getAllAtivos() {
    return (List<AtivosPatrimoniais>) repository.findAll();
    }
    
    @PostMapping
    public AtivosPatrimoniais createAtivo(@RequestBody AtivosPatrimoniais ativos){
        return repository.save(ativos);
    }

    
}
