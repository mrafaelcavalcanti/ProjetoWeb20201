package br.edu.ufape.bcc.projetoweb20201.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//controller para efetuar as principais paginas do usuarios
@Controller
public class PagesController {
    
    @RequestMapping("/home")
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

    @RequestMapping("/carrinho")
    public String carrinho (HttpServletRequest request, Principal principal) {
        if (principal!=null) {
			System.out.println("Authorities do user" +principal.getName());
        }
        return "carrinho";
    }

    @RequestMapping("/meusprodutos")
    public String meusprodutos (HttpServletRequest request, Principal principal) {
        if (principal!=null) {
			System.out.println("Authorities do user" +principal.getName());
        }
        return "meusprodutos";
    }
}
