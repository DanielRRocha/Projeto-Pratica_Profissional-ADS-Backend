package br.com.pratica.profissional.backend.ProjetoADS.DAO.model;

import javax.persistence.Column;

import br.com.pratica.profissional.backend.ProjetoADS.DAO.infra.Entidade;

public class Cliente implements Entidade {

	private Long id;
	@Column(nullable = false, length = 100)
	private String nome;
	@Column(nullable = false)
	private String sobrenome;
	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	private Long cpf;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String senha;
	private Long tipo_id;
	
	
	/**
	 * Construtor padrão
	 * 
	 * @author danielrocha
	 */
	public Cliente() {
		
	}

	/**
	 * 
	 * Construtor recebendo dados do cliente como parametros
	 * 
	 * @param nome
	 * @param sobrenome
	 * @param username
	 * @param cpf
	 * @param email
	 * @param senha
	 * @param tipo_id
	 * 
	 * @author danielrocha
	 */
	public Cliente(String nome, String sobrenome, String username, Long cpf, String email, String senha, Long tipo_id) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.username = username;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		this.tipo_id = tipo_id;
	}

	// --------- getters e setters --------- //
	
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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
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

	public Long getTipo_id() {
		return tipo_id;
	}

	public void setTipo_id(Long tipo_id) {
		this.tipo_id = tipo_id;
	}
	
	
}
