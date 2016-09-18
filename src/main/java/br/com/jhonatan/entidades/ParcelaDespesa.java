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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;


@NamedQueries({
	
	@NamedQuery(name=ParcelaDespesa.CONSULTAR_PARCELAS_POR_ID_DESPESA,
			query="select pd from ParcelaDespesa pd"
					+ " where pd.despesa.id = ?1 order by pd.dataParcela")
	
})

@Entity
@Table(name="parcela_despesa", schema="personal_control")
@SQLDelete(sql="UPDATE personal_control.parcela_despesa SET paga = 'true' WHERE id_parcela_despesa = ?")
@Where(clause="paga = 'false'")
public class ParcelaDespesa extends AbstractBaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1826390808208462216L;

	public static final String CONSULTAR_PARCELAS_POR_ID_DESPESA = "parcelaDespesa.consultarParcelasPorIdDespesa";

	@Id
	@GeneratedValue(generator="parcela_despesa_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="parcela_despesa_seq", sequenceName="parcela_despesa_id_parcela_despesa_seq", schema="personal_control")
	@Column(name = "id_parcela_despesa", unique = true, nullable = false)
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
	
	@Column(name="paga")
	private boolean paga;
	
	public ParcelaDespesa() {}
	
	public ParcelaDespesa(final Date dataParcela, final Despesa despesa, final double valorParcela, final Integer numeroParcela) {
		this.dataParcela = dataParcela;
		this.despesa = despesa;
		this.valorParcela = valorParcela;
		this.numeroParcela = numeroParcela;
	}

	public Integer getNumeroParcela() {
		return numeroParcela;
	}

	public void setNumeroParcela(final Integer numeroParcela) {
		this.numeroParcela = numeroParcela;
	}

	public Date getDataParcela() {
		return dataParcela;
	}

	public void setDataParcela(final Date dataParcela) {
		this.dataParcela = dataParcela;
	}

	public Despesa getDespesa() {
		return despesa;
	}

	public void setDespesa(final Despesa despesa) {
		this.despesa = despesa;
	}

	public Long getId() {
		return id;
	}

	public Double getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(final Double valorParcela) {
		this.valorParcela = valorParcela;
	}

	public boolean isPaga() {
		return paga;
	}

	public void setPaga(final boolean paga) {
		this.paga = paga;
	}
	
}
