package br.edu.ufape.bcc.projetoweb20201.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.ufape.bcc.projetoweb20201.model.Usuario;

@Repository
public interface UsuarioDAOI extends JpaRepository<Usuario, Long> {

    @Query("select u from Usuario u where u.email=:email and u.senha=:senha")
    public Usuario findUsuario(String email, String senha);

    @Query("select u from Usuario u where u.email=:email")
    public Optional <Usuario> findByEmail(String email);

    @Query("select u from Usuario u where u.id=:id")
    public Usuario findUsuarioById(Long id);

}
