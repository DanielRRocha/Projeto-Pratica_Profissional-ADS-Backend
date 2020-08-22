package br.com.pratica.profissional.backend.ProjetoADS.DB.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Usuario {

	@Id
	private Long id;
	private String tipo;
	
	
	/**
	 * Construtor padrao
	 * 
	 * @param id
	 * @param tipo
	 * 
	 * @author danielrocha
	 */
	public Usuario() {
		
	}

	/**
	 * Construtor recebendo dois parametros
	 * 
	 * @param id
	 * @param tipo
	 * 
	 * @author danielrocha
	 */
	public Usuario(Long id, String tipo) {
		super();
		this.id = id;
		this.tipo = tipo;
	}


	/**
	 *  Retorna Id do usuario
	 * @return id
	 * 
	 * @author danielrocha
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Seta id do usuario
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 *  Retorna tipo do usuario
	 * @return tipo
	 * 
	 * @author danielrocha
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Seta tipo do usuario
	 * 
	 * @param tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
}
