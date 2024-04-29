package webapp.gerenciamento_escolar_ta.Controller;

import org.springframework.stereotype.Controller;
//aqui ficam as rotas
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {
    @GetMapping("/")
    public String acessarIndex() {
        return "paginasDeslogado/index";
    }

    @GetMapping("/sobre")
    public String acessarCadastro() {
        return "paginasDeslogado/sobre";
    }

    @GetMapping("/contato")
    public String acessarContato() {
        return "paginasDeslogado/contato";
    }

    @GetMapping("/alunos")
    public String acessarAlunos() {
        return "paginasDeslogado/alunos";
    }

    @GetMapping("/administradores")
    public String acessarAdministradores() {
        return "paginasDeslogado/administradores";
    }

    @GetMapping("/professores")
    public String acessarProfessores() {
        return "paginasLogado/professor";
    }

    @GetMapping("/acesso-adm")
    public String acessarAdm() {
        return "paginasDeslogado/acesso-adm";
    }
    
    // pré-cadastro administrador

    @GetMapping("/pre-cadastro")
public String acessarPreCadAdm(){
    return "paginasLogado/pre-cadastro";
}

}
