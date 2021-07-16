package br.edu.ufape.bcc.projetoweb20201.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity 
@Table (name = "produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "Nome do produto não pode ser vazio")
	@Column(name = "nome_produto")
	private String nomeProduto;
	
	@NotNull(message = "Quantidade não pode ser vazio")
	private float quantidade;
	
	@NotNull(message = "Peso não pode ser vazio")
	private float peso;
	
	@NotNull(message = "Preço não pode ser vazio")
	private float preco;

	@NotNull(message = "Categoria não pode ser vazio")
	private int categoria;
	
	@NotNull(message = "ID do usuario produtor não pode ser vazio")
	@Column(name = "id_usuario")
	private Long usuario;
	
	public Produto() {

	}

	public Produto(Long id, String nomeProduto, float quantidade, float peso, float preco, int categoria, Long usuario) {
		super();
		this.id = id;
		this.nomeProduto = nomeProduto;
		this.quantidade = quantidade;
		this.peso = peso;
		this.preco = preco;
		this.categoria = categoria;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public int getCategoria() {
		return categoria;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public Long getUsuario() {
		return usuario;
	}

	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}
	
	
	
}
