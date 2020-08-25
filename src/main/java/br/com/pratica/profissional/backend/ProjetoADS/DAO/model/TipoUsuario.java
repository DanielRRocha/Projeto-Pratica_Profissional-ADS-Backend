package br.com.pratica.profissional.backend.ProjetoADS.DAO.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.pratica.profissional.backend.ProjetoADS.DAO.infra.Entidade;


@Entity
public class TipoUsuario implements Entidade {

	@Id
	@Column(unique = true)
	private Long id;
	
	@Column(unique = true)
	private String tipo;
	
	private static Logger logger = LogManager.getLogger(TipoUsuario.class);
	
	
	/**
	 * Construtor padrao
	 * 
	 * @param id
	 * @param tipo
	 * 
	 * @author danielrocha
	 */
	public TipoUsuario() {
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
	public TipoUsuario(Long id, String tipo) {
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
