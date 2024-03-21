package webapp.cadastro;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



    /** @author Rolfi Luz - Senai * */
    @Controller
    public class IndexController {
        @RequestMapping(value = "/", method = RequestMethod.GET)
        public ModelAndView abrirIndex() {
            ModelAndView mv = new ModelAndView("index");

            String mensagem = "Olá, seja bem-vinda(o)!";
            mv.addObject("msg", mensagem);

            return mv;
        }

        //cadastro

        @RequestMapping(value = "/contato", method = RequestMethod.GET)
        public String abrirContato() {
            return "contato";

        }

        // @RequestMapping(value = "/", method = RequestMethod.POST)
        // public ModelAndView buscarIndex(@RequestParam("buscar") String buscar) {
        //     ModelAndView mv = new ModelAndView("index");

        //     String mensagem = "Resultado da Busca !";
        //     mv.addObject("msg", mensagem);
        //     mv.addObject("buscar", buscar);

        //     return mv;

        // }
    }
