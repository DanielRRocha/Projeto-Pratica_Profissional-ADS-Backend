package br.com.pratica.profissional.backend.ProjetoADS.DAO.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.pratica.profissional.backend.ProjetoADS.DAO.infra.Entidade;


@Entity
public class Usuario implements Entidade {

	@Id
	private Long id;
	private String tipo;
	
	private static Logger logger = LogManager.getLogger(Usuario.class);
	
	
	/**
	 * Construtor padrao
	 * 
	 * @param id
	 * @param tipo
	 * 
	 * @author danielrocha
	 */
	public Usuario() {
		logger.info("Construtor padrão");
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
		
		logger.info("Construtor Com parametros");
		logger.debug("Id: " + id + " - Tipo: " + tipo);
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

	public String getTipo() {
		logger.debug("Get tipo: " + tipo);
		return tipo;
	}

	public void setTipo(String tipo) {
		logger.debug("Set tipo: " + tipo);
		this.tipo = tipo;
	}

	
}
