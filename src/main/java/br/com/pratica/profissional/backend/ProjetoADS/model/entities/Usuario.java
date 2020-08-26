package br.com.pratica.profissional.backend.ProjetoADS.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.pratica.profissional.backend.ProjetoADS.Helpers.Constants;
import br.com.pratica.profissional.backend.ProjetoADS.Helpers.Crypto;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 100)
	private String nome;
	
	@Column(nullable = false)
	private String sobrenome;
	
	@Column(nullable = false, unique = true)
	private String username;
	
	@Column(nullable = false, unique = true)
	private String cpf;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String senha;
	
	@Column(nullable = false)
	private int usuario_id;
	
	private static Logger logger = LogManager.getLogger(Usuario.class);

	
	/**
	 * Construtor padrão
	 * 
	 * @author danielrocha
	 */
	public Usuario() {
		
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
	 * @param usuario
	 * 
	 * @author danielrocha
	 */
	public Usuario(String nome, String sobrenome, String username, String cpf, String email, String senha, int usuario) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.username = username;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		this.usuario_id = usuario;
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

	public String getCpf() {
		logger.debug("Get CPF.: " + cpf);
		return cpf;
	}

	public void setCpf(String cpf) {
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

	public int getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}
}
