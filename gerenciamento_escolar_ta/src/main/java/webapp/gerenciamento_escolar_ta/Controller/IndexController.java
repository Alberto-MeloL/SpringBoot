package webapp.gerenciamento_escolar_ta.Controller;

import org.springframework.stereotype.Controller;
//aqui ficam as rotas
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
    @GetMapping("/")
    public String acessarIndex() {
        return "index";
    }

    @GetMapping("/sobre")
    public String acessarCadastro() {
        return "sobre";
    }

    @GetMapping("/contato")
    public String acessarContato() {
        return "contato";
    }

    @GetMapping("/alunos")
    public String acessarAlunos() {
        return "alunos";
    }

    @GetMapping("/administradores")
    public String acessarAdministradores() {
        return "administradores";
    }

    @GetMapping("/professores")
    public String acessarProfessores() {
        return "professores";
    }

}
