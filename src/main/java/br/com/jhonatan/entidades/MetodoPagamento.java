package br.com.jhonatan.entidades;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * MetodoPagamento generated by hbm2java
 */
@Entity
@Table(name = "metodo_pagamento", schema = "personal_control")
public class MetodoPagamento implements Serializable {

	private static final long serialVersionUID = 5099386082815919390L;

	@Id
	@GeneratedValue(generator="metodo_pagamento_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="metodo_pagamento_seq", sequenceName="metodo_pagamento_id_metodo_pagamento_seq", schema="personal_control")
	@Column(name = "id_metodo_pagamento", unique = true, nullable = false, columnDefinition="bigserial")
	private Long id;
	
	@Column(name = "descricao", nullable = false, length = 100)
	private String descricao;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "metodoPagamento")
	private Set<Despesa> despesas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Set<Despesa> getDespesas() {
		return despesas;
	}

	public void setDespesas(Set<Despesa> despesas) {
		this.despesas = despesas;
	}

}
