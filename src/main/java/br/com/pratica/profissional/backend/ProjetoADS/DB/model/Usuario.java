package br.com.pratica.profissional.backend.ProjetoADS.DB.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import br.com.pratica.profissional.backend.ProjetoADS.DB.Utils.Entidade;


@Entity
public class Usuario implements Entidade{

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

	// --------- getters e setters --------- //
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
}
