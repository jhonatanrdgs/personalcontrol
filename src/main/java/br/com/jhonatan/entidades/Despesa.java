package br.com.jhonatan.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Despesa generated by hbm2java
 */

@NamedQueries({
	
	@NamedQuery(name=Despesa.CONSULTAR_DESPESAS_POR_DESCRICAO_CATEGORIA_METODOPG_DATA,
			query="select d from Despesa d "
					+ " join fetch d.categoria c"
					+ " join fetch d.metodoPagamento mp"
					+ " where (d.descricao like concat('%', ?1, '%') or ?1 is null)"
					+ " and (c.id = ?2 or ?2 is null)"
					+ " and (mp.id = ?3 or ?3 is null)"
					+ " and (d.data between ?4 and ?5)"),
					
	@NamedQuery(name=Despesa.CONSULTAR_DESPESA_POR_ID_FETCH, 
		query="select d from Despesa d "
				+ " join fetch d.categoria c"
				+ " join fetch d.metodoPagamento mp"
				+ " join fetch d.usuario u"
				+ " where d.id = ?1")
	
})

@Entity
@Table(name = "despesa", schema = "personal_control")
@Inheritance(strategy=InheritanceType.JOINED)
public class Despesa implements Serializable {
	//TODO despesa fixa

	private static final long serialVersionUID = 8987183170531571355L;

	public static final String CONSULTAR_DESPESAS_POR_DESCRICAO_CATEGORIA_METODOPG_DATA = "despesa.consultarDespesasPorDescricaoCategoriaMetodoPgData";

	public static final String CONSULTAR_DESPESA_POR_ID_FETCH = "despesa.consultarDespesaPorIdFetch";

	@Id
	@GeneratedValue(generator="despesa_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="despesa_seq", sequenceName="despesa_id_despesa_seq", schema="personal_control")
	@Column(name = "id_despesa", unique = true, nullable = false, columnDefinition="bigserial")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_categoria", nullable = false, columnDefinition="int")
	private Categoria categoria;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_metodo_pagamento", nullable = false, columnDefinition="int")
	private MetodoPagamento metodoPagamento;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario", nullable = false, columnDefinition="int")
	private Usuario usuario;
	
	@Column(name = "parcelada", nullable = false)
	private boolean parcelada;
	
	@Column(name = "valor_total", nullable = false, precision=10, scale=2, columnDefinition="Decimal(10,2)")
	private Double valorTotal;
	
	@Column(name = "descricao", nullable = false, length = 100)
	private String descricao;
	
	@Column(name="total_parcelas")
	private Integer totalParcelas;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "data", nullable = false, length = 13)
	private Date data;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="despesa", cascade=CascadeType.ALL)
	private Set<ParcelaDespesa> parcelas;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public MetodoPagamento getMetodoPagamento() {
		return metodoPagamento;
	}

	public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isParcelada() {
		return parcelada;
	}

	public void setParcelada(boolean parcelada) {
		this.parcelada = parcelada;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getTotalParcelas() {
		return totalParcelas;
	}

	public void setTotalParcelas(Integer totalParcelas) {
		this.totalParcelas = totalParcelas;
	}

	public Set<ParcelaDespesa> getParcelas() {
		return parcelas;
	}

	public void setParcelas(Set<ParcelaDespesa> parcelas) {
		this.parcelas = parcelas;
	}
	

}
