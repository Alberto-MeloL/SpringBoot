package br.patrimonio.patrimonio_senai.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.patrimonio.patrimonio_senai.Model.AtivoPatrimonial;
import br.patrimonio.patrimonio_senai.Repository.AtivoPatrimonialRepository;

@RestController
@RequestMapping("/ativos")
public class AtivoPatrimonialController {
    
    @Autowired
    private AtivoPatrimonialRepository repository;

    @GetMapping
    public List<AtivoPatrimonial> getAllAtivos() {
        return (List<AtivoPatrimonial>) repository.findAll();
    }

    @PostMapping
    public AtivoPatrimonial createAtivo(@RequestBody AtivoPatrimonial ativo) {
        return repository.save(ativo);
    }

    @GetMapping("/{id}")
    public Optional<AtivoPatrimonial> getAtivoById(@PathVariable Long id) {
        return repository.findById(id);
    }
}
