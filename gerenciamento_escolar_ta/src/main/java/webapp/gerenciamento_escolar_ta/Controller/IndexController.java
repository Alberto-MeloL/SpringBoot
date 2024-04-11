package webapp.gerenciamento_escolar_ta.Controller;

import org.springframework.stereotype.Controller;
//aqui ficam as rotas
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
    @GetMapping("/")
    public String acessarIndex() {
        return "PaginasDeslogado/index";
    }

    @GetMapping("/sobre")
    public String acessarCadastro() {
        return "PaginasDeslogado/sobre";
    }

    @GetMapping("/contato")
    public String acessarContato() {
        return "PaginasDeslogado/contato";
    }

    @GetMapping("/alunos")
    public String acessarAlunos() {
        return "PaginasLogado/aluno";
    }

    @GetMapping("/administradores")
    public String acessarAdministradores() {
        return "PaginasDeslogado/administradores";
    }

    @GetMapping("/professores")
    public String acessarProfessores() {
        return "PaginasDeslogado/professores";
    }

}
