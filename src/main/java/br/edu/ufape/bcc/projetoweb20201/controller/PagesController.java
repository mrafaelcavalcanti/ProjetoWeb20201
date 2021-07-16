package br.edu.ufape.bcc.projetoweb20201.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//controller para efetuar as principais paginas do usuarios
@Controller
public class PagesController {
    
    @RequestMapping(value={"/","/home"})
    public String home (HttpServletRequest request, Principal principal) {
        
        if (principal!=null) {
			System.out.println("Authorities do user" +principal.getName());
        }
        return "home";

    }

    
    @RequestMapping("/usuario")
    public String usuario (HttpServletRequest request, Principal principal) {
        
        if (principal!=null) {
			System.out.println("Authorities do user" +principal.getName());
        }
        return "usuario";

    }
}
