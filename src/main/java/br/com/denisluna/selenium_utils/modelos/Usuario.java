package br.com.denisluna.selenium_utils.modelos;

/**
 * Classe modelo de acesso, com dados de Login com usuário e senha.
 * 
 * @author Denis Luna Borges da Silva
 *
 */

public class Usuario {
	protected String usuario;
	protected String senha;

	/**
	 * Construtor da classe
	 * 
	 * @param usuario nome de usuário.
	 * @param senha   senha do usuário.
	 */

	public Usuario(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public String getSenha() {
		return this.senha;
	}

	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", senha=" + senha + "]";
	}

}
