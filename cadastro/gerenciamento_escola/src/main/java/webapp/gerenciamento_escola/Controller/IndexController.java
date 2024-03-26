package webapp.gerenciamento_escola.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller // não esquecer <-----
public class IndexController {

    // @RequestMapping(value = "/", method = RequestMethod.GET)
    // public ModelAndView abrirIndex() {
    //     ModelAndView mv = new ModelAndView("index");

    //     String mensagem = "Gerenciamento Escolar.";

    //     mv.addObject("msg", mensagem);

    //     return mv;
    // }

    @GetMapping("/")
    public String abrirINdex() {
        return "index";
    }

    

}
