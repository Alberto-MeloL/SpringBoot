package webapp.gerenciamento_escolar_ta.Controller.Administrador;

import webapp.gerenciamento_escolar_ta.Model.Administrador.AdministradorModel;
import webapp.gerenciamento_escolar_ta.Model.Administrador.VerificaCadastroAdm;
import webapp.gerenciamento_escolar_ta.Model.Aluno.VerificaCadAluno;
import webapp.gerenciamento_escolar_ta.Model.Professor.VerificaCadProfessor;
import webapp.gerenciamento_escolar_ta.Repository.Administrador.AdministradorRepository;
import webapp.gerenciamento_escolar_ta.Repository.Administrador.VerificaCadastroAdmRepository;
import webapp.gerenciamento_escolar_ta.Repository.Aluno.VerificaCadAlunoRepository;
import webapp.gerenciamento_escolar_ta.Repository.Professor.VerificaCadProfessorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdministradorController {

    // gerenciar o acesso do administrador
    boolean acessoAdm = false;

    @Autowired
    private AdministradorRepository admRep;

    @Autowired
    private VerificaCadastroAdmRepository verifCadAdm;

    //instancia para cadastrar aluno/professor

    @Autowired 
    private VerificaCadProfessorRepository verificaCadProfessor;

    @Autowired
    private VerificaCadAlunoRepository verificaCadAluno;
    // métodos

    @PostMapping("pre-cad-adm")
    public ModelAndView preCadastrarAdm(VerificaCadastroAdm adm, RedirectAttributes attributes) {
        boolean verificaCpf = verifCadAdm.existsById(adm.getCpf());
        ModelAndView mv = new ModelAndView("redirect:/");
        try {
            if (!verificaCpf) {

                verifCadAdm.save(adm);
                String mensagem = "Cadastro realizado com sucesso!";
                System.out.println(mensagem);
                attributes.addFlashAttribute("msg", mensagem);
                attributes.addFlashAttribute("classe", "verde");
            } else {
                String mensagem = "Erro ao cadastrar";
                System.err.println(mensagem);
                attributes.addFlashAttribute("msg", mensagem);
                attributes.addFlashAttribute("classe", "vermelho");
            }
        } catch (Exception e) {
            System.err.printf("Houve um erro!", e);
            return mv;
        }

        return mv;
    }

    @PostMapping("cadastrar-adm")
    public ModelAndView cadastroAdm(AdministradorModel adm, RedirectAttributes attributes) {
        boolean verificaCpfAdm = verifCadAdm.existsById(adm.getCpf());

        ModelAndView mv = new ModelAndView("redirect:/acesso-adm");

        try {
            if (verificaCpfAdm) {
                admRep.save(adm);
                String mensagem = "Cadstro realizado com sucesso!";
                System.out.println(mensagem);
                attributes.addFlashAttribute("msg", mensagem);
                attributes.addFlashAttribute("classe", "vermelho");
            } else {
                String mensgem = "Erro ao cadastrar, verifique seu cadastro.";
                System.err.println(mensgem);
                attributes.addFlashAttribute("msg", mensgem);
                attributes.addFlashAttribute("classe", "vermelho");
            }

            return mv;

        } catch (Exception e) {

            System.err.printf("Houve um erro!", e);
            return mv;
        }
    }

    @PostMapping("acesso-adm")
    public ModelAndView loginAdm(@RequestParam String cpf,
            @RequestParam String senha, RedirectAttributes attributes) {
        ModelAndView mv = new ModelAndView("redirect:/administrador");

        try {
            boolean acessoCpf = admRep.existsById(cpf);
            boolean acessoSenha = senha.equals(admRep.findByCpf(cpf).getSenha());

            if (acessoCpf && acessoSenha) {
                acessoAdm = true;
            } else {
                String mensagem = "Login não realizado.";
                System.out.println(mensagem);
                attributes.addFlashAttribute("msg", mensagem);
                attributes.addFlashAttribute("classe", "vermelho");
                mv.setViewName("redirect:/index");
            }

            return mv;
        } catch (Exception e) {
            String mensagem = "Login não realizado";
            System.out.println(mensagem);
            attributes.addFlashAttribute("msg", mensagem);
            attributes.addFlashAttribute("classe", "vermelho");
            mv.setViewName("redirect:/index");
            return mv;
        }
    }

    @GetMapping("/administrador")
    public ModelAndView acessoInterno(RedirectAttributes attributes) {

        ModelAndView mv = new ModelAndView("paginasLogado/administrador");

        if (acessoAdm) {
            System.out.println("Acesso permitido.");
        } else {
            String mensagem = "Acesso negado, Faça seu login.";
            System.out.println(mensagem);
            attributes.addFlashAttribute("msg", mensagem);
            attributes.addFlashAttribute("classe", "vermelho");
            mv.setViewName("redirect:/index");
        }
        return mv;
    }

    //ações do administrador
    @PostMapping("add-professor")
     public ModelAndView cadProfessor(VerificaCadProfessor prof, RedirectAttributes attributes) {
        ModelAndView mv = new ModelAndView("redirect:/index"); // Redireciona para a página de professores após o cadastro

        // Verifica se o email já está cadastrado
        boolean verificaEmail = verificaCadProfessor.existsById(prof.getEmail());
        try {
            if (!verificaEmail) {
                verificaCadProfessor.save(prof);
                String mensagem = "Professor cadastrado com sucesso!";
                System.out.println(mensagem);
                attributes.addFlashAttribute("msg", mensagem);
            attributes.addFlashAttribute("classe", "verde");
            } else {
                String mensagem = "Erro: O email já está cadastrado!";
                System.err.println(mensagem);
            } 
        } catch (Exception e) {

            System.err.printf("Houve um erro ao cadastrar email do professor", e);
        }
      
        return mv;
    }



    @PostMapping("add-aluno")
    public ModelAndView cadProfessor(VerificaCadAluno aluno, RedirectAttributes attributes) {
       ModelAndView mv = new ModelAndView("redirect:/");

       // Verifica se o email já está cadastrado
       boolean verificaEmail = verificaCadAluno.existsById(aluno.getEmail());
       try {
           if (!verificaEmail) {
               verificaCadAluno.save(aluno);
               String mensagem = "Aluno cadastrado com sucesso!";
               System.out.println(mensagem);
               attributes.addFlashAttribute("msg", mensagem);
           attributes.addFlashAttribute("classe", "verde");
           } else {
               String mensagem = "Erro: O email já está cadastrado!";
               System.err.println(mensagem);
           } 
       } catch (Exception e) {

           System.err.printf("Houve um erro ao cadastrar email do aluno", e);
       }
     
       return mv;
   }
    
    @PostMapping("logout-adm")
    public ModelAndView logoutAdm(RedirectAttributes attributes) {
        ModelAndView mv = new ModelAndView("redirect:/");
        attributes.addFlashAttribute("msg", "Você saiu.");
        attributes.addFlashAttribute("classe", "verde");
        acessoAdm = false;
        return mv;
    }

}
