package br.edu.ufape.bcc.projetoweb20201.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.ufape.bcc.projetoweb20201.model.Endereco;
import br.edu.ufape.bcc.projetoweb20201.model.Usuario;
import br.edu.ufape.bcc.projetoweb20201.repository.UsuarioDAOI;



@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	@Autowired
	UsuarioDAOI usuarioDAOI;
	
	@RequestMapping(value = "/novo")
	public String novo(Long Id, Model model) {
		model.addAttribute("usuarioForm", new Usuario());
		model.addAttribute("endereco", new Endereco());
		System.out.println("testetss");
		return "cadastrarusuario";
	}

	@RequestMapping(value = "/all")
	public String findUsuarios(Model model) {
		List<Usuario> usuarios = usuarioDAOI.findAll();
		System.out.println(usuarios.get(0).getNome());
		model.addAttribute("usuarios", usuarios);
		return "listarusuarios";
	}
	
	@RequestMapping(value = "/update/{id}")
	public String update(@PathVariable("id") Long id, Model model) {
		System.out.println("teste");
		
		Optional<Usuario> usuario = usuarioDAOI.findById(id);
		model.addAttribute("usuarioForm", usuario.get());
		model.addAttribute("endereco", usuario.get().getEndereco());

		return "updateusuario";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String update(@Validated @ModelAttribute("usuarioForm") Usuario form, BindingResult bindingResult, Model model ) {
		System.out.println("teste");

		
		if(bindingResult.hasErrors()){
			model.addAttribute("errors", bindingResult.getAllErrors());
			System.out.println(bindingResult.getAllErrors());
			return "forward:/usuarios/novo";
		}else{
			usuarioDAOI.save(form);
		
			model.addAttribute("msgs", "usuario atualizado");
		}
		
		
		return "forward:/usuarios/all";
	}
}
