package br.com.jhonatan.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

public class GenericDAO<T> implements Serializable {
	private static final long serialVersionUID = 7279035949209212928L;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void salvar(T entidade) {
		entityManager.persist(entidade);
	}
	
	@Transactional
	public void atualizar(T entidade) {
		entityManager.merge(entidade);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> criarQueryResultList(String nQuery, Object... params) {
		Query q = entityManager.createNamedQuery(nQuery);
		for (int i = 0; i < params.length; i++) {
			q.setParameter(i+1, params[i]);
		}
		return (List<T>)q.getResultList();
	}
	
	/**
	 * Usar com cuidado, pois está sem tipagem.
	 * @param nQuery
	 * @param params
	 * @return
	 */
	//TODO ver se dá para refatorar
	@SuppressWarnings("rawtypes")
	public List criarQueryResultListSemTipagem(String nQuery, Object... params) {
		Query q = entityManager.createNamedQuery(nQuery);
		for (int i = 0; i < params.length; i++) {
			q.setParameter(i+1, params[i]);
		}
		return q.getResultList();
		
	}
	
	@SuppressWarnings("unchecked")
	public T criarQuerySingleResult(String nQuery, Object... params) {
		Query q = entityManager.createNamedQuery(nQuery);
		for (int i = 0; i < params.length; i++) {
			q.setParameter(i+1, params[i]);
		}
		try {
			return (T)q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public Double criarQuerySingleResultSomatorio(String nQuery, Object... params) {
		Query q = entityManager.createNamedQuery(nQuery);
		for (int i = 0; i < params.length; i++) {
			q.setParameter(i+1, params[i]);
		}
		try {
			return (Double)q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public T findById(Class<T> classe, Long id) {
		return this.entityManager.find(classe, id);
	}
	
	public EntityManager getEntityManager() {
		return this.entityManager;
	}
	
}
