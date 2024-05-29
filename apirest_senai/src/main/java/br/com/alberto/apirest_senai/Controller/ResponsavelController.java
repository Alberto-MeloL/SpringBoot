package br.com.alberto.apirest_senai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alberto.apirest_senai.Model.Responsavel;
import br.com.alberto.apirest_senai.Repository.ResponsavelRepository;

// aqui combina duas anotações sendo: Controller e ResponseBody
// ResponseBody serializa os objetos tipicamente em formato Json
// ou seja é uma classe controladora que lida com requisições HTTP
// facilitando a criação de endpoints
@RestController
@RequestMapping
public class ResponsavelController {

    // injeção de dependências, no caso uma instância
    @Autowired
    private ResponsavelRepository repository;

    @GetMapping
    public Responsavel getResponsavel(){
        return Responsavel repository.existsById();
    }

    @PostMapping
    public Responsavel createResponsavel(@RequestBody Responsavel responsavel){
        return repository.save(responsavel);
    }

}

// como seria isso aqui e me explique
//  @GetMapping
//     public Responsavel getResponsavel(){
//         retrun (Responsavel) repository.count();
//     }
