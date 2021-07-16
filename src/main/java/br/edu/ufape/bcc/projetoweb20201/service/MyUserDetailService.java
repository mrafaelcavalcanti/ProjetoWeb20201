package br.edu.ufape.bcc.projetoweb20201.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.edu.ufape.bcc.projetoweb20201.model.Usuario;
import br.edu.ufape.bcc.projetoweb20201.repository.UsuarioDAOI;
import br.edu.ufape.bcc.projetoweb20201.config.MyUserDetails;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    UsuarioDAOI usuarioDAOI;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional <Usuario> oUsuario = usuarioDAOI.findByEmail(username);
        System.out.println(username);

        oUsuario.orElseThrow(() -> new UsernameNotFoundException("Not Found"+ username));

        return new MyUserDetails(oUsuario.get());
    }

    
}
