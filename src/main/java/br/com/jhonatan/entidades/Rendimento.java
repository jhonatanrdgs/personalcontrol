package br.com.jhonatan.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@NamedQueries({
	
	@NamedQuery(name=Rendimento.CONSULTAR_RENDIMENTOS, 
			query="select sum(r.valor) from Rendimento r"
					+ " where ?1 between dataInicio and Coalesce(dataFim, current_date + 365)"),
			
	@NamedQuery(name=Rendimento.CONSULTAR_RENDIMENTOS_POR_PESSOA,
			query="select r from Rendimento r where upper(r.nomePessoa) like concat('%', upper(?1), '%') or ?1 is null")
	
})

@Entity
@Table(name = "rendimento", schema = "personal_control")
public class Rendimento extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -3336005467530312440L;

	public static final String CONSULTAR_RENDIMENTOS = "rendimento.consultarRendimentos";

	public static final String CONSULTAR_RENDIMENTOS_POR_PESSOA = "rendimento.consultarRendimentoPorPessoa";

	@Id
	@GeneratedValue(generator="rendimento_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="rendimento_seq", sequenceName="rendimento_id_rendimento_seq", schema="personal_control")
	@Column(name = "id_rendimento", unique = true, nullable = false, columnDefinition="bigserial")
	private Long id;
	
	@Column(name="nome_pessoa", length=100, nullable=false)
	private String nomePessoa;
	
	@Column(name = "valor", precision = 10, nullable=false)
	private Double valor;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name="dt_inicio", nullable=false)
	private Date dataInicio;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name="dt_fim", nullable=true)
	private Date dataFim;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	
}
