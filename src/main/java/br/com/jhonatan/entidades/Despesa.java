package br.com.jhonatan.entidades;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.jhonatan.util.Constantes;

/**
 * Despesa generated by hbm2java
 */
@NamedQueries({
	
	@NamedQuery(name=Despesa.CONSULTAR_DESPESAS_POR_DESCRICAO_CATEGORIA_METODOPG_DATA,
			query="select d from Despesa d "
					+ " join fetch d.categoria c"
					+ " join fetch d.metodoPagamento mp"
					+ " where (upper(d.descricao) like concat('%', upper(?1), '%') or ?1 is null)"
					+ " and (c.id = ?2 or ?2 is null)"
					+ " and (mp.id = ?3 or ?3 is null)"
					+ " and (d.data between ?4 and ?5)"),
					
	@NamedQuery(name=Despesa.CONSULTAR_DESPESA_POR_ID_FETCH, 
		query="select d from Despesa d "
				+ " join fetch d.categoria c"
				+ " join fetch d.metodoPagamento mp"
				+ " join fetch d.usuario u"
				+ " left join fetch d.parcelas p"
				+ " where d.id = ?1"),
				
	@NamedQuery(name=Despesa.CONSULTAR_DESPESAS_PARCELADAS_MES,
		query="select new br.com.jhonatan.dto.RelatorioComprasParceladasDTO(d.descricao, pd.valorParcela, pd.numeroParcela, d.totalParcelas) from ParcelaDespesa pd"
				+ " inner join pd.despesa d"
				+ " where extract(month from pd.dataParcela) = ?1 and extract(year from pd.dataParcela) = ?2 and d.totalParcelas > 1"),
				
	@NamedQuery(name=Despesa.CONSULTAR_GASTOS_FIXOS,
			query="select new br.com.jhonatan.dto.RelatorioGastosFixosDTO(d.descricao, d.valorTotal) from Despesa d"
					+ " where d.fixa = true"),
					
	@NamedQuery(name=Despesa.CONSULTAR_VALOR_TOTAL_DESPESAS_VARIAVEIS_MES,//TODO query na entidade errada
			query="select sum(p.valorParcela) from ParcelaDespesa p"
					+ " where extract(month from p.dataParcela) = ?1 and extract(year from p.dataParcela) = ?2"),
					
	@NamedQuery(name=Despesa.CONSULTAR_SOMATORIO_DESPESAS_FIXAS,
			query="select sum(d.valorTotal) from Despesa d where d.fixa = true"),
					
	@NamedQuery(name=Despesa.CONSULTAR_DESPESAS_VARIAVEIS_MES,
			query="select new br.com.jhonatan.dto.RelatorioComprasNaoParceladasDTO(d.descricao, sum(d.valorTotal)) from Despesa d "
					+ " where d.fixa = false and d.totalParcelas = 1"
					+ " and extract(month from d.data) = ?1 and extract(year from d.data) = ?2"
					+ " group by d.descricao"),
					
	@NamedQuery(name=Despesa.CONSULTAR_VALOR_TOTAL_DESPESAS_MES_RELATORIO_RENDIMENTOS,
			query="select sum(p.valorParcela) "
					+ " from Despesa d"
					+ " join d.parcelas p"
					+ " where p.dataParcela between ?1 and ?2"),
					
	@NamedQuery(name=Despesa.CONSULTAR_DESPESAS_VARIAVEIS_PERIODO_SUM,
			query="select sum(pd.valorParcela) as valor from ParcelaDespesa pd "
					+ " join pd.despesa d"
					+ " where d.fixa = false"
					+ " and pd.dataParcela between ?1 and ?2"),
					
					
	@NamedQuery(name=Despesa.CONSULTAR_DESPESAS_VARIAVEIS_PERIODO_RELATORIO_PDF,
			query="select new br.com.jhonatan.dto.RelatorioGastosMensaisPdfDTO(d.descricao, d.valorTotal, p.valorParcela, p.numeroParcela, d.totalParcelas, d.categoria.descricao) "
					+ " from Despesa d"
					+ " inner join d.parcelas p"
					+ " where p.dataParcela between ?1 and ?2 order by d.categoria.id"),
					
	@NamedQuery(name=Despesa.CONSULTAR_DESPESAS_COM_PARCELAS_PROXIMO_MES_EM_DIANTE,
			query="select distinct d from Despesa d"
					+ " join fetch d.parcelas p"
					+ " where p.dataParcela >= ?1"
					+ " and d.totalParcelas > 1"
					+ " and p.paga = false"
					+ " order by d.descricao"),
					
	@NamedQuery(name=Despesa.CONSULTAR_DESPESAS_FIXAS_POR_METODO_PAGAMENTO,
			query="select sum(d.valorTotal) from Despesa d "
					+ "inner join d.metodoPagamento mp "
					+ "where mp.id = ?1 and d.fixa = true ")
					
})

@Entity
@Table(name = "despesa", schema = "personal_control")
public class Despesa extends AbstractBaseEntity implements Serializable {
	
	private static final long serialVersionUID = 8987183170531571355L;

	public static final String CONSULTAR_DESPESAS_POR_DESCRICAO_CATEGORIA_METODOPG_DATA = "despesa.consultarDespesasPorDescricaoCategoriaMetodoPgData";
	public static final String CONSULTAR_DESPESA_POR_ID_FETCH = "despesa.consultarDespesaPorIdFetch";
	public static final String CONSULTAR_DESPESAS_PARCELADAS_MES = "despesa.consultarDespesasParceladasMes";
	public static final String CONSULTAR_GASTOS_FIXOS = "despesa.consultarGastosFixos";
	public static final String CONSULTAR_VALOR_TOTAL_DESPESAS_VARIAVEIS_MES = "despesa.consultarValorTotalDespesasVariaveisMes";
	public static final String CONSULTAR_SOMATORIO_DESPESAS_FIXAS = "despesa.consultarDespesasFixasMesAno";
	public static final String CONSULTAR_DESPESAS_VARIAVEIS_MES = "despesa.consultarDespesasVariaveisMes";
	public static final String CONSULTAR_VALOR_TOTAL_DESPESAS_MES_RELATORIO_RENDIMENTOS = "despesa.consultarValorTotalDespesasMesRelatorioRendimentos";
	public static final String CONSULTAR_DESPESAS_VARIAVEIS_PERIODO_SUM = "despesa.consultarDespesasVariaveisPeriodoSum";
	public static final String CONSULTAR_DESPESAS_VARIAVEIS_PERIODO_RELATORIO_PDF = "despesa.consultarDespesasPeriodo";
	public static final String CONSULTAR_DESPESAS_COM_PARCELAS_PROXIMO_MES_EM_DIANTE = "despesa.consultarDespesasComParcelasProximoMesEmDiante";
	public static final String CONSULTAR_DESPESAS_FIXAS_POR_METODO_PAGAMENTO = "despesa.consultarDespesasFixasPorMetodoPagamento";


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
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_usuario", nullable = false, columnDefinition="int")
	private Usuario usuario;
	
	@Column(name = "valor_total", nullable = false, precision=10, scale=2, columnDefinition="Decimal(10,2)")
	private Double valorTotal;
	
	@Column(name = "descricao", nullable = false, length = 100)
	private String descricao;
	
	@Column(name="total_parcelas")
	private Integer totalParcelas;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = Constantes.FORMATO_DATA_PT_BR)
	@Column(name = "data", nullable = false, length = 13)
	private Date data;
	
	@Column(name="fixa", nullable=false)
	private boolean fixa;//fixa não gera parcela, então em relatorios é date(periodo) ou fixa
	
	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY, mappedBy="despesa", cascade=CascadeType.ALL, orphanRemoval=true)
	private Set<ParcelaDespesa> parcelas;
	
	@Transient
	@DateTimeFormat(pattern = Constantes.FORMATO_DATA_PT_BR)
	private Date inicio;
	
	@Transient
	@DateTimeFormat(pattern = Constantes.FORMATO_DATA_PT_BR)
	private Date fim;

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

	public boolean isFixa() {
		return fixa;
	}

	public void setFixa(boolean fixa) {
		this.fixa = fixa;
	}
	
	@JsonIgnore
	public Date getInicioFormatado() {
		if (inicio == null) {
			SimpleDateFormat sdf = new SimpleDateFormat(Constantes.FORMATO_DATA_PT_BR);
			try {
				inicio = sdf.parse("01/01/1970");
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	
	@JsonIgnore
	public Date getFimFormatado() {
		if (fim == null) {
			SimpleDateFormat sdf = new SimpleDateFormat(Constantes.FORMATO_DATA_PT_BR);
			try {
				fim = sdf.parse("01/01/3000");
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return fim;
	}
	
	public void setFim(Date fim) {
		this.fim = fim;
	}

	public Date getInicio() {
		return inicio;
	}

	public Date getFim() {
		return fim;
	}
	
}
