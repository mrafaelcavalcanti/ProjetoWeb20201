package br.edu.ufape.bcc.projetoweb20201.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.bcc.projetoweb20201.model.Endereco;

@Repository
public interface EnderecoDAOI extends JpaRepository<Endereco, Long> {

}
