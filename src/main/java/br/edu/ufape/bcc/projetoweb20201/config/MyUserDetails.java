package br.edu.ufape.bcc.projetoweb20201.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.edu.ufape.bcc.projetoweb20201.model.Usuario;

public class MyUserDetails implements UserDetails {

    private static final long serialVersionUID = 1L;
    private String userName;
    private String password;
    //private String email;
    //private Long id;
    //private int tipo;
    private boolean active = true;
    private List<GrantedAuthority> autorities;

    public MyUserDetails(String email) {
        this.userName = email;
    }
    
    public MyUserDetails() {

    }

    public MyUserDetails(Usuario usuario) {
        Long id = usuario.getId();
        this.userName = Long.toString(id); //usuario.getEmail();
        this.password = usuario.getSenha();
        //this.email = usuario.getEmail();
        //this.id = usuario.getId();
        //this.tipo = usuario.getTipoUsuario();
        this.active = true;
        List<GrantedAuthority> lista = new ArrayList<>();

        //gambiarra
        lista.add(new SimpleGrantedAuthority(String.valueOf(usuario.getTipoUsuario())));
        lista.add(new SimpleGrantedAuthority("LOGADO"));

        this.autorities = lista;
    }

    
    /*public String getEmail() {
        return this.email;
    }*/

    /*public Long getId() {
        return this.id;
    }*/

    /*public int getTipo() {
        return this.tipo;
    }*/

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.active;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.autorities;
    }
}
