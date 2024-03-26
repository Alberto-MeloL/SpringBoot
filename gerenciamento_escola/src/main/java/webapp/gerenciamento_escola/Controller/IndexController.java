package webapp.gerenciamento_escola.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller // não esquecer <-----
public class IndexController {


     @GetMapping("/")
     public String abrirIndex() {
         return "index";
     }
       
    }