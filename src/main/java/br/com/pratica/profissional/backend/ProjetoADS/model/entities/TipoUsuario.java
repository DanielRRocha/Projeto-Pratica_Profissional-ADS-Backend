package br.com.pratica.profissional.backend.ProjetoADS.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Entity
public class TipoUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique = true)
	private String tipo;
	
	private static Logger logger = LogManager.getLogger(TipoUsuario.class);
	
	
	/**
	 * Construtor padrao
	 * 
	 * @author danielrocha
	 */
	public TipoUsuario() {
		logger.info("Utilizando construtor padrão");
	}

	/**
	 * Construtor recebendo o tipo como parametros
	 * 
	 * @param tipo
	 * 
	 * @author danielrocha
	 */
	public TipoUsuario(String tipo) {
		super();
		this.tipo = tipo;
		
		logger.info("Utilizando construtor com parametros");
		logger.debug("Id: " + id + " - Tipo: " + tipo);
	}

	// --------- getters e setters --------- //
	
	public int getId() {
		logger.debug("Get Id: " + id);
		return id;
	}

	public void setId(int id) {
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
