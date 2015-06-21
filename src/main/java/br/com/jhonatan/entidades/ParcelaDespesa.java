package br.com.jhonatan.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="parcela_despesa", schema="personal_control")
public class ParcelaDespesa extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1826390808208462216L;

	@Id
	@GeneratedValue(generator="parcela_despesa_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="parcela_despesa_seq", sequenceName="parcela_despesa_id_parcela_despesa_seq", schema="personal_control")
	@Column(name = "id_parcela_despesa", unique = true, nullable = false, columnDefinition="bigserial")
	private Long id;
	
	@Column(name="numero_parcela", nullable=false)
	private Integer numeroParcela;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_parcela", nullable=false)
	private Date dataParcela;
	
	@Column(name="valor_parcela", nullable = true, precision=10, scale=2, columnDefinition="Decimal(10,2)")
	private Double valorParcela;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_despesa", columnDefinition="int")
	private Despesa despesa;

	public Integer getNumeroParcela() {
		return numeroParcela;
	}

	public void setNumeroParcela(Integer numeroParcela) {
		this.numeroParcela = numeroParcela;
	}

	public Date getDataParcela() {
		return dataParcela;
	}

	public void setDataParcela(Date dataParcela) {
		this.dataParcela = dataParcela;
	}

	public Despesa getDespesa() {
		return despesa;
	}

	public void setDespesa(Despesa despesa) {
		this.despesa = despesa;
	}

	public Long getId() {
		return id;
	}

	public Double getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(Double valorParcela) {
		this.valorParcela = valorParcela;
	}

}
