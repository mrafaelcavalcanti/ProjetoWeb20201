package br.edu.ufape.bcc.projetoweb20201.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;



@Entity 
@Table (name = "usuario")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Usuario implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name ="nome")
	private String nome;

	@Email(message = "Email invalido")
	private String email;

	private String senha;

	private String telefone;
	
	@NotNull(message = "É preciso escolher o tipo de usuario")
	@Column(name = "tipo_usuario")
	private int tipoUsuario;
	
	@Column(name = "numero_cartao")
	private String numeroCartao;
	
	@Column(name ="chave_pix")
	private String chavePix;
	
	@Column(name = "imagem_perfil")
	private byte[] imagemPerfil;
	
	//@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	
	//@Valid
	//@OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
	//@JoinColumn(name="id_usuario", referencedColumnName = "id")
	//@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name = "usuario_endereco_id")
	@OneToOne(mappedBy =  "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Endereco endereco;


	public Usuario() {
		
	}

	public Usuario(Long id, String nome, String email, String senha, String telefone, int tipoUsuario,
			String numeroCartao, String chavePix, byte[] imagemPerfil) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.tipoUsuario = tipoUsuario;
		this.numeroCartao = numeroCartao;
		this.chavePix = chavePix;
		this.imagemPerfil = imagemPerfil;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getChavePix() {
		return chavePix;
	}

	public void setChavePix(String chavePix) {
		this.chavePix = chavePix;
	}

	public byte[] getImagemPerfil() {
		return imagemPerfil;
	}

	public void setImagemPerfil(byte[] imagemPerfil) {
		this.imagemPerfil = imagemPerfil;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
	
	
}
