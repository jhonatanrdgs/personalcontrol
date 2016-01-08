package br.com.jhonatan.controller;

import java.io.Serializable;

import org.springframework.ui.ModelMap;

public abstract class CrudController<T> implements Serializable {

	private static final long serialVersionUID = 8740603538366947783L;
	public static final String FORM = "form";
	
	public abstract String list(final ModelMap map);
	
	public abstract String search(final T entity, final ModelMap map);
	
	public abstract String create(final ModelMap map);
	
	public abstract String save(final T entity, final ModelMap map);
	
	public abstract String prepareEdit(final Long id, final ModelMap map);
	
	public abstract String remove(final Long id, final ModelMap map);

}
