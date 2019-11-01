package br.com.cative.beans;

public class Usuario {
	
	private int idUsuario;
	private String nome;
	private String senha;
	private String email;
	private int tipoUsuario;
	private String foto;
	private String tema;
	private int pontuacao;
	
	public Usuario(int idUsuario, String nome, String senha, String email, int tipoUsuario, int pontuacao) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.tipoUsuario = tipoUsuario;
		this.pontuacao = pontuacao;
	}
	public Usuario() {
		super();
	}
	
	
	public Usuario(int idUsuario, String nome, String senha, String email, int tipoUsuario, String foto, String tema,
			int pontuacao) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.tipoUsuario = tipoUsuario;
		this.foto = foto;
		this.tema = tema;
		this.pontuacao = pontuacao;
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
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
	public int getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(int i) {
		this.tipoUsuario = i;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getTema() {
		return tema;
	}
	
	public void setTema(String tema) {
		this.tema = tema;
	}
	
	public int getPontuacao() {
		return pontuacao;
	}
	
	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	
}
