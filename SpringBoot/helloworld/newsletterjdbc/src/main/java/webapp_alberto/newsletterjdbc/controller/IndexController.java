package webapp_alberto.newsletterjdbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller//anotações
public class IndexController {
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public ModelAndView abrirIndex(){
ModelAndView mv = new ModelAndView("index");
   String mensagem = "Olá, seja bem-vinda(o)!";
   mv.addObject("msg", mensagem);
   
   return mv;

}
    
}
