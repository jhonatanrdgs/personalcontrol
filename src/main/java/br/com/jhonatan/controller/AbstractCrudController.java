package br.com.jhonatan.controller;

import java.io.Serializable;

import org.springframework.ui.ModelMap;

public abstract class AbstractCrudController<T> implements Serializable {

	private static final long serialVersionUID = 8740603538366947783L;
	
	public abstract String list(final ModelMap map);
	public abstract String search(final T entity, final ModelMap map);
	public abstract String create(final ModelMap map);
	public abstract String save(final T entity, final ModelMap map);
	public abstract String prepareEdit(final Long idUC, final ModelMap map);
	public abstract String remove(final Long idUC, final ModelMap map);

}
