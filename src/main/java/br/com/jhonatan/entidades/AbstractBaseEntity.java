package br.com.jhonatan.entidades;

import java.io.Serializable;

public abstract class AbstractBaseEntity implements Serializable {
	
	private static final long serialVersionUID = -2906168139978439077L;

	public abstract Long getId();

}
