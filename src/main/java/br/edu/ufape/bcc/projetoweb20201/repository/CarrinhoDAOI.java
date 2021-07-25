package br.edu.ufape.bcc.projetoweb20201.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.ufape.bcc.projetoweb20201.model.Carrinho;

@Repository
public interface CarrinhoDAOI extends JpaRepository<Carrinho, Long>{
    
    @Query("SELECT c FROM Carrinho c WHERE c.idUsuario=:id")
    public List<Carrinho> findByUserId(Long id);
}
