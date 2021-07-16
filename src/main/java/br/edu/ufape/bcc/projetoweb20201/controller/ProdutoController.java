package br.edu.ufape.bcc.projetoweb20201.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ufape.bcc.projetoweb20201.repository.ProdutoDAOI;
import br.edu.ufape.bcc.projetoweb20201.model.Produto;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    ProdutoDAOI produtoDAOI;

    

    @RequestMapping(value = "/all")
	public String findUsuarios(Model model) {
		List<Produto> produtos = produtoDAOI.findAll();
		model.addAttribute("produto", produtos);
		return "listarprodutos";
	}
    
}
