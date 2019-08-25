package br.com.cative.beans;

public class Usuario {
	
	private int idUsuario;
	private String nome;
	private String apelido;
	private String email;
	private String tipoUsuario;
	private String senha;
	private String foto;
	
	
	public Usuario() {
		super();
	}
	
	public Usuario(int idUsuario, String nome, String apelido, String email, String tipoUsuario, String senha,
			String foto) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.apelido = apelido;
		this.email = email;
		this.tipoUsuario = tipoUsuario;
		this.senha = senha;
		this.foto = foto;
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
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
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
	
	public void setTudo(int idUsuario, String nome, String apelido, String email, String tipoUsuario, String senha,
			String foto) {
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.apelido = apelido;
		this.email = email;
		this.tipoUsuario = tipoUsuario;
		this.senha = senha;
		this.foto = foto;
	}
	
	public String getTudo() {
		return "Usuario" + "\n" +
				"Nome" + "\n" + 
				"Apelido" + "\n" + 
				"Email" + "\n" +
				"Tipo de Usuario" + "\n" +
				"Senha" + "\n" + 
				"Foto" + "\n";
	}	
	
}
