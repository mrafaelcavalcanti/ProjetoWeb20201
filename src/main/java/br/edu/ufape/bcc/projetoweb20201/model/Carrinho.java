package br.edu.ufape.bcc.projetoweb20201.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "carrinho")
public class Carrinho implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "id_produto")
    private Long idProduto;

    @Column(name = "quantidade")
    private float quantidade;

    public Carrinho() {

    }

    public Carrinho(Long id, Long idUsuario, Long idProduto, float quantidade) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

}
