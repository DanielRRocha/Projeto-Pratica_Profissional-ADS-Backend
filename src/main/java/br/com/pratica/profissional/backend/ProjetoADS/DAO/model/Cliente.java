package br.com.pratica.profissional.backend.ProjetoADS.DAO.model;

import javax.persistence.Column;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
	
	private static Logger logger = LogManager.getLogger(Cliente.class);

	
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
		logger.debug("Get Id: " + id);
		return id;
	}
	
	public void setId(Long id) {
		logger.debug("Set Id: " + id);
		this.id = id;
	}
	
	public String getNome() {
		logger.debug("Get name; " + nome);
		return nome;
	}

	public void setNome(String nome) {
		logger.debug("Set name: " + nome);
		this.nome = nome;
	}

	public String getSobrenome() {
		logger.debug("Get last name: " + sobrenome);
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		logger.debug("Set last name: " + sobrenome);
		this.sobrenome = sobrenome;
	}

	public String getUsername() {
		logger.debug("Get username: " + username);
		return username;
	}

	public void setUsername(String username) {
		logger.debug("Set username: " + username);
		this.username = username;
	}

	public Long getCpf() {
		logger.debug("Get CPF.: " + cpf);
		return cpf;
	}

	public void setCpf(Long cpf) {
		logger.debug("Set CPF.: " + cpf);
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		logger.debug("Set e-mail: " + email);
		this.email = email;
	}

	public String getSenha() {
//		String senha_decripted = Crypto.decrypt(senha , Constants.crypto_key);
		logger.debug("Get senha");
		return senha;
	}

	public void setSenha(String senha) {
//		String senha_encripted = Crypto.encrypt(senha, Constants.crypto_key);
		logger.debug("Set senha encripted");
		this.senha = senha;
	}

	public Long getTipo_id() {
		logger.debug("Get Tipo Id; " + tipo_id);
		return tipo_id;
	}

	public void setTipo_id(Long tipo_id) {
		logger.debug("Set Tipo Id; " + tipo_id);
		this.tipo_id = tipo_id;
	}
	
	
}
