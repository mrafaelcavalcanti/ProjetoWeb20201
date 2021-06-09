package br.com.ufape.bcc.projetoweb20201.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity 
@Table (name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nome;
	private String email;
	private String senha;
	private String telefone;
	
	@Column(name = "tipo_usuario")
	private int tipoUsuario;
	
	@Column(name = "numero_cartao")
	private String numeroCartao;
	
	@Column(name ="chave_pix")
	private String chavePix;
	
	@Column(name = "imagem_perfil")
	private byte[] imagemPerfil;
	
	@OneToOne
	@JoinColumn(name="id_usuario_endereco")
	private Endereco endereco;
	
	public Usuario(int id, String nome, String email, String senha, String telefone, int tipoUsuario,
			String numeroCartao, String chavePix, byte[] imagemPergil) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.tipoUsuario = tipoUsuario;
		this.numeroCartao = numeroCartao;
		this.chavePix = chavePix;
		this.imagemPerfil = imagemPergil;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public byte[] getImagemPergil() {
		return imagemPerfil;
	}

	public void setImagemPergil(byte[] imagemPerfil) {
		this.imagemPerfil = imagemPerfil;
	}
	
	
	
}