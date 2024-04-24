package webapp.gerenciamento_escolar_ta.Controller.Administrador;

import webapp.gerenciamento_escolar_ta.Model.Administrador.AdministradorModel;
import webapp.gerenciamento_escolar_ta.Repository.Administrador.AdministradorRepository;
import webapp.gerenciamento_escolar_ta.Repository.Administrador.VerificaCadastroAdmRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    // métodos

    @PostMapping("cadastrar-adm")
    public ModelAndView cadastroAdm(AdministradorModel adm, RedirectAttributes attributes) {
        boolean verificaCpfAdm = verifCadAdm.existsById(adm.getCpf());

        ModelAndView mv = new ModelAndView("redirect:/paginasLogado/administrador");

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
    @RequestParam String senha, RedirectAttributes attributes ) {
ModelAndView mv = new ModelAndView("redirect:/administrador");        

try {
    boolean acessoCpf = admRep.existsById(cpf);
    boolean acessoSenha = senha.equals(admRep.findByCpf(cpf).getSenha());

    if (acessoCpf && acessoSenha) {
        acessoAdm = true;
    }else{
        String mensagem = "Login não realizado.";
        System.out.println(mensagem);
        attributes.addFlashAttribute("msg", mensagem);
        attributes.addFlashAttribute("classe", "vermelho");
        mv.setViewName("redirect/index");
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
}else{
    String mensagem = "Acesso negado, Faça seu login.";
    System.out.println(mensagem);
    attributes.addFlashAttribute("msg", mensagem);
    attributes.addFlashAttribute("classe", "vermelho");
    mv.setViewName("redirect:/index");
}
return mv;
}

@PostMapping("logout-adm")
public ModelAndView logoutAdm(RedirectAttributes attributes) {
ModelAndView mv = new ModelAndView("redirect:/index");
attributes.addFlashAttribute("msg", "Você saiu.");
attributes.addFlashAttribute("classe", "verde");
acessoAdm = false;   
    return mv;
}


}
