package br.com.ufape.bcc.projetoweb20201.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ufape.bcc.projetoweb20201.model.Usuario;

@Repository
public interface UsuarioDAOI extends JpaRepository<Usuario, Long> {

}
