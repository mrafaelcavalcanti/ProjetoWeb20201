package br.edu.ufape.bcc.projetoweb20201.apirest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.bcc.projetoweb20201.model.Usuario;
import br.edu.ufape.bcc.projetoweb20201.repository.EnderecoDAOI;
import br.edu.ufape.bcc.projetoweb20201.repository.UsuarioDAOI;


@RestController
@RequestMapping("/api/usuarios")
public class UsuarioRESTController {

    @Autowired
    UsuarioDAOI usuarioDAOI;

 

    @GetMapping
    @RequestMapping("/get/all")
    public List<Usuario> findAllUsuarios() {
        return usuarioDAOI.findAll();
    }

  

    @GetMapping("/get/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable("id") Long id) {
        
        Optional<Usuario> optUsuario = usuarioDAOI.findById(id);
        if (optUsuario.isPresent()) {
            Usuario usuario = optUsuario.get();
            return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
        }
        
        return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getEmail/{email}")
    public ResponseEntity<Usuario> getUsuarioByEmail(@PathVariable("email") String email) {
        
        Optional<Usuario> optUsuario = usuarioDAOI.findByEmail(email);
        if (optUsuario.isPresent()) {
            Usuario usuario = optUsuario.get();
            return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
        }
        
        return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario addUsuario(@RequestBody Usuario usuario) {
        usuario.getEndereco().setUsuario(usuario);
        Usuario novoUsuario = usuarioDAOI.save(usuario);
        return novoUsuario;
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario) {
        usuario.getEndereco().setUsuario(usuario);
        Optional<Usuario> optUsuario = usuarioDAOI.findById(usuario.getId());
        if (optUsuario.isPresent()) {
            usuarioDAOI.save(usuario);
            return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
        }
        return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Usuario> deleteUsuario(@PathVariable("id") Long id) {
        Optional<Usuario> optUsario = usuarioDAOI.findById(id);
        if (optUsario.isPresent()) {
            Usuario usuario = optUsario.get();
            usuarioDAOI.delete(usuario);
            return new ResponseEntity<Usuario>(HttpStatus.OK);
        }
        return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);
    }


}
