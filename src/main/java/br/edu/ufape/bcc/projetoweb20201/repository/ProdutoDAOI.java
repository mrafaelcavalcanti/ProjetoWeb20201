package br.edu.ufape.bcc.projetoweb20201.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.ufape.bcc.projetoweb20201.model.Produto;

@Repository
public interface ProdutoDAOI extends JpaRepository<Produto, Long>{

    @Query("SELECT p FROM Produto p WHERE p.nomeProduto LIKE '%%:name%%'")
    public List<Produto> findByName(String name);

    @Query("SELECT p FROM Produto p WHERE p.categoria=:categoria")
    public List<Produto> findByCategoria(int categoria);
    
    @Query(value = "SELECT * FROM produto p WHERE p.id_usuario=:id", nativeQuery = true)
    public List<Produto> findByUserProducts(Long id);
}
