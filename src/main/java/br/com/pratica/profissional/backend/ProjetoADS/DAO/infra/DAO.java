package br.com.pratica.profissional.backend.ProjetoADS.DAO.infra;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DAO<E extends Entidade> {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Class<E> classe;
	private static Logger logger = LogManager.getLogger(DAO.class);
	
	static {
		try {
			emf = Persistence.createEntityManagerFactory("marido_de_aluguel");
			logger.info("Entity Manager Factory created");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public DAO() {
		this(null);
		logger.info("DAO null");
	}
	
	/**
	 * Construtor recebendo a classe como parametro
	 * 
	 * @param classe
	 * 
	 * @author danielrocha
	 */
	public DAO(Class<E> classe) {
		this.classe = classe;
		logger.info("############### Database operation started ###############");
		em = emf.createEntityManager();
		logger.info("Entity Manager created");
	}
	
	/**
	 * Inicia uma transação com o banco de dados
	 * 
	 * @author danielrocha
	 */
	public DAO<E> abrirT() {
		em.getTransaction().begin();
		logger.info("Transaction iniciated");
		return this;
	}
	
	/**
	 * Commita a mudança e fecha a transação com o banco de dados
	 * 
	 * @author danielrocha
	 */
	public DAO<E> fecharT() {
		try {
			em.getTransaction().commit();
		} catch (RollbackException e) {
			logger.error("Duplicate entry '1' for key 'usuario.PRIMARY'");
			throw new RollbackException();
		}
		logger.info("Transaction commited");
		return this;
	}
	
	/**
	 * Inclui a transação recebida como parametro no banco de dados 
	 * 
	 * @param entidade
	 * 
	 * @author danielrocha
	 * @throws SQLIntegrityConstraintViolationException 
	 */
	public DAO<E> incluir(E entidade) {
			em.persist(entidade);
		return this;
	}

	/**
	 * Inicia, inclui e fecha a transação com o banco de dados
	 * 
	 * @param entidade
	 * 
	 * @author danielrocha
	 * @throws SQLIntegrityConstraintViolationException 
	 */
	public DAO<E> incluirAtomico(E entidade) {
		return this.abrirT().incluir(entidade).fecharT();
	}
	
	/**
	 * Busca Usuario pelo tipo de usuario
	 * 
	 * @param l
	 * @author danielrocha
	 */
	public E buscarUsuarioPeloTipo(Long l) {
		if (classe == null) {
			logger.info("Classe nula");
			throw new UnsupportedOperationException("Classe nula");
		}
		E it = em.find(classe, l);
		return it;
	}
	
//	public Usuario buscarUsuario(Long cpf) {
//		
//		DAO<Usuario> dao = new DAO<Usuario>();
//		List<Usuario> usuarios = dao.obterTodos();
//		Usuario e = null;
//		
//		for(Usuario usuario : usuarios) {
//			if(usuario.getCpf() == cpf) {
//				return usuario;
//			}
//		}
//		return e;
//	}
	
	/**
	 * Obtem os 10 primeiros registros na tabela
	 * 
	 * @author danielrocha
	 */
	public List<E> obterTodos(){
		logger.info("Obter os 10 primeiros registros na tabela");
		return this.obterTodos(10, 0);
	}
	
	
	/**
	 * Retorna os elementos na tabela de acordo com quantidade e 
	 * deslocamento passados como parametros
	 * 
	 * @param limit
	 * @param deslocamento
	 * 
	 * @author danielrocha
	 */
	public List<E> obterTodos(int limit, int deslocamento){
		if(classe == null) {
			logger.info("Classe nula");
			throw new UnsupportedOperationException("Classe nula");
		}
		
		String jpql = "select e from " + classe.getName() + " e";
		logger.debug("Package.Class " + classe.getName());
		TypedQuery<E> query = em.createQuery(jpql, classe);
		query.setMaxResults(limit);
		query.setFirstResult(deslocamento);
		logger.debug("Limite: " + limit + " - Deslocamento: " + deslocamento);
		
		return query.getResultList();
	}
	
	/**
	 * Encerra a Entity Manager
	 * 
	 *  @author danielrocha
	 */
	public void fechar() {
		em.close();
		logger.info("Entity Manager closed");
	}
}
