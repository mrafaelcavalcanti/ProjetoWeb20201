package br.edu.ufape.bcc.projetoweb20201.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ufape.bcc.projetoweb20201.model.Endereco;
import br.edu.ufape.bcc.projetoweb20201.repository.EnderecoDAOI;

@Controller
@RequestMapping("/enderecos")
public class EnderecoController {
	@Autowired
	EnderecoDAOI enderecoDAOI;
	
	@RequestMapping(value = "/all")
	public String findUsuarios(Model model) {
		List<Endereco> enderecos = enderecoDAOI.findAll();
		model.addAttribute("endereco", enderecos);
		return "listarenderecos";
	}

}
