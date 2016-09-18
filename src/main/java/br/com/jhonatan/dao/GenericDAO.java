package br.com.jhonatan.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.jhonatan.dto.BaseDTO;

public class GenericDAO<T> implements Serializable {
	private static final long serialVersionUID = 7279035949209212928L;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void salvar(final T entidade) {
		entityManager.persist(entidade);
	}
	
	public void atualizar(final T entidade) {
		entityManager.merge(entidade);
	}
	
	public void excluir(final T entidade) {
		entityManager.remove(entidade);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> criarQueryResultList(final String nQuery, final Object... params) {
		final Query q = entityManager.createNamedQuery(nQuery);
		for (int i = 0; i < params.length; i++) {
			q.setParameter(i+1, params[i]);
		}
		return (List<T>)q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> criarQueryResultListWithLimit(final String nQuery, final int limit, final Object... params) {
		final Query q = entityManager.createNamedQuery(nQuery);
		q.setMaxResults(limit);
		for (int i = 0; i < params.length; i++) {
			q.setParameter(i+1, params[i]);
		}
		return (List<T>)q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<? extends BaseDTO> criarQueryResultListDTO(final String nQuery, final Object... params) {
		final Query q = entityManager.createNamedQuery(nQuery);
		for (int i = 0; i < params.length; i++) {
			q.setParameter(i+1, params[i]);
		}
		return q.getResultList();
		
	}
	
	@SuppressWarnings("unchecked")
	public T criarQuerySingleResult(final String nQuery, final Object... params) {
		final Query q = entityManager.createNamedQuery(nQuery);
		for (int i = 0; i < params.length; i++) {
			q.setParameter(i+1, params[i]);
		}
		try {
			return (T)q.getSingleResult();
		} catch (final NoResultException e) {
			return null;
		}
	}
	
	public Double criarQuerySingleResultSomatorio(final String nQuery, final Object... params) {
		final Query q = entityManager.createNamedQuery(nQuery);
		for (int i = 0; i < params.length; i++) {
			q.setParameter(i+1, params[i]);
		}
		try {
			return (Double)q.getSingleResult();
		} catch (final NoResultException e) {
			return null;
		}
	}
	
	public T findById(final Class<T> classe, final Long id) {
		return this.entityManager.find(classe, id);
	}
	
	public EntityManager getEntityManager() {
		return this.entityManager;
	}
	
}
