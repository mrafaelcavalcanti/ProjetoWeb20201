package br.edu.ufape.bcc.projetoweb20201.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.ufape.bcc.projetoweb20201.model.Produto;

@Repository
public interface ProdutoDAOI extends JpaRepository<Produto, Long>{

    @Query(value = "SELECT * FROM produto WHERE nome_produto LIKE %:name%", nativeQuery = true)
    public List<Produto> findByName(@Param("name") String name);

    @Query("SELECT p FROM Produto p WHERE p.categoria=:categoria")
    public List<Produto> findByCategoria(int categoria);
    
    @Query(value = "SELECT * FROM produto p WHERE p.id_usuario=:id", nativeQuery = true)
    public List<Produto> findByUserProducts(Long id);
}
