package br.com.jhonatan.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * ItemDespesaCarro generated by hbm2java
 */
@Entity
@Table(name = "item_despesa_carro", schema = "personal_control")
public class ItemDespesaCarro extends AbstractBaseEntity implements Serializable {

	private static final long serialVersionUID = 4829389151584710492L;

	@Id
	@GeneratedValue(generator="item_despesa_carro_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="item_despesa_carro_seq", sequenceName="item_despesa_carro_id_item_despesa_carro_seq", schema="personal_control")
	@Column(name = "id_item_despesa_carro", unique = true, nullable = false, columnDefinition="bigserial")
	private Long id;
	
	@Column(name = "descricao", nullable = false, length = 100)
	private String descricao;
	
	@Column(name = "valor_item", nullable = false, precision = 10)
	private Double valorItem;

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

	public Double getValorItem() {
		return valorItem;
	}

	public void setValorItem(Double valorItem) {
		this.valorItem = valorItem;
	}
	
}
