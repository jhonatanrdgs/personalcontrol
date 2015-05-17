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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.jhonatan.util.NumberUtil;

/**
 * DespesaCarro generated by hbm2java
 */
@NamedQueries( {
	@NamedQuery(name=DespesaCarro.CONSULTAR_DESPESA_CARRO_POR_DESCRICAO,
		query="select dc from DespesaCarro dc join fetch dc.itemDespesaCarros"
				+ " where dc.data between ?1 and ?2")

})

@Entity
@Table(name = "despesa_carro", schema = "personal_control")
public class DespesaCarro implements Serializable {

	private static final long serialVersionUID = 598761704442941495L;

	public static final String CONSULTAR_DESPESA_CARRO_POR_DESCRICAO = "despesaCarro.consultarDespesaCarroPorDescricao";
	
	@Id
	@GeneratedValue(generator="despesa_carro_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="despesa_carro_seq", sequenceName="despesa_carro_id_despesa_carro_seq", schema="personal_control")
	@Column(name = "id_despesa_carro", unique = true, nullable = false, columnDefinition="bigserial")
	private Long id;

	@Column(name = "km", nullable = false, length = 6)
	private String km;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date data;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "despesaCarro", cascade=CascadeType.ALL)
	private Set<ItemDespesaCarro> itemDespesaCarros;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKm() {
		return km;
	}

	public void setKm(String km) {
		this.km = km;
	}

	public Set<ItemDespesaCarro> getItemDespesaCarros() {
		return itemDespesaCarros;
	}

	public void setItemDespesaCarros(Set<ItemDespesaCarro> itemDespesaCarros) {
		this.itemDespesaCarros = itemDespesaCarros;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	@Transient
	public Double getValorTotal() {
		Double valorTotal = 0D;
		for (ItemDespesaCarro item : this.itemDespesaCarros) {
			valorTotal += item.getValorItem();
		}
		return NumberUtil.normalizarDouble(valorTotal, 2);
	}
	

}
