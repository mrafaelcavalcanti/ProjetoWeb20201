package br.edu.ufape.bcc.projetoweb20201.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table (name = "endereco")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Endereco implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Cidade nao pode estar vazia")
	@Column(name = "cidade")
	private String cidade;

	@Column(name = "bairro")
	private String bairro;
	@Column(name = "rua")
	private String rua;
	@Column(name = "numero")
	private int numero;
	@Column(name = "complemento")
	private String complemento;
	@Column(name = "cep")
	private String cep;
	
	
	//@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "enderecoU")
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	@JsonIgnore
	private Usuario usuario;
		
	public Endereco() {
		
	}
	
	public Endereco(Long id, String cidade, String bairro, String rua, int numero, String complemento, String cep) {
		this.id = id;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
		
}
