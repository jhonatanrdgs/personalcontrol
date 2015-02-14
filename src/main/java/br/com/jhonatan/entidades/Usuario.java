package br.com.jhonatan.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1669857465707550409L;
	
	@Id
	@Column(columnDefinition="bigserial")
	@SequenceGenerator(name="usuario_seq", sequenceName="usuario_seq_id")
	@GeneratedValue(generator="usuario_seq", strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Transient
	private String oi;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOi() {
		return oi;
	}

	public void setOi(String oi) {
		this.oi = oi;
	}
	
	
}
