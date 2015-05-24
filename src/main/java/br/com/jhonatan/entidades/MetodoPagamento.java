package br.com.jhonatan.entidades;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * MetodoPagamento generated by hbm2java
 */

@NamedQueries({
	
	@NamedQuery(name=MetodoPagamento.CONSULTAR_METODOS_PAGAMENTO_POR_DESCRICAO,
			query="from MetodoPagamento mp where ativo = ?1 and (upper(mp.descricao) like concat('%', upper(?2), '%') or ?2 is null)"),
			
	@NamedQuery(name=MetodoPagamento.CONSULTAR_TODOS_METODOS_PAGAMENTO_ATIVOS, query="from MetodoPagamento mp where ativo = true order by descricao"),
	
	@NamedQuery(name=MetodoPagamento.CONSULTAR_DESPESAS_POR_METODO_PAGAMENTO_ATIVO,
			query="select new br.com.jhonatan.dto.RelatorioGastosPorMetodoPagamentoDTO(mp.descricao, sum(p.valorParcela)) from MetodoPagamento mp"
					+ " join mp.despesas d"
					+ " join d.parcelas p"
					+ " where p.dataParcela between ?1 and ?2"
					+ " and d.fixa = false"
					+ " group by mp.descricao")
})

@Entity
@Table(name = "metodo_pagamento", schema = "personal_control")
public class MetodoPagamento extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 5099386082815919390L;

	public static final String CONSULTAR_METODOS_PAGAMENTO_POR_DESCRICAO = "metodoPagamento.consultarMetodosPagamentoPorDescricao";
	public static final String CONSULTAR_TODOS_METODOS_PAGAMENTO_ATIVOS = "metodoPagamento.consultarTodosMetodosPagamentoAtivos";
	public static final String CONSULTAR_DESPESAS_POR_METODO_PAGAMENTO_ATIVO = "metodoPagamento.consultarDespesasPorMetodoPagamentoAtivo";
	
	public MetodoPagamento() {
		this.ativo = true;
	}

	@Id
	@GeneratedValue(generator="metodo_pagamento_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="metodo_pagamento_seq", sequenceName="metodo_pagamento_id_metodo_pagamento_seq", schema="personal_control")
	@Column(name = "id_metodo_pagamento", unique = true, nullable = false, columnDefinition="bigserial")
	private Long id;
	
	@Column(name = "descricao", nullable = false, length = 100)
	private String descricao;
	
	@Column(name="ativo", nullable = false)
	private boolean ativo;
	
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
	
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Set<Despesa> getDespesas() {
		return despesas;
	}

	public void setDespesas(Set<Despesa> despesas) {
		this.despesas = despesas;
	}

}
