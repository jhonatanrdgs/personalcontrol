package br.com.jhonatan.entidades;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * DespesaCarro generated by hbm2java
 */
@NamedQueries( {
	@NamedQuery(name=DespesaCarro.CONSULTAR_DESPESA_CARRO_POR_DESCRICAO,
		query="select dc from DespesaCarro dc"
				+ " join fetch dc.categoria c"
				+ " join fetch dc.metodoPagamento mp"
				+ " where (dc.descricao like concat('%', ?1, '%') or ?1 is null)"
				+ " and (c.id = ?2 or ?2 is null)"
				+ " and (mp.id = ?3 or ?3 is null)"
				+ " and (dc.data between ?4 and ?5)")

})

@Entity
@Table(name = "despesa_carro", schema = "personal_control")
@PrimaryKeyJoinColumn(name="id_despesa")  
public class DespesaCarro extends Despesa {

	private static final long serialVersionUID = 598761704442941495L;

	public static final String CONSULTAR_DESPESA_CARRO_POR_DESCRICAO = "despesaCarro.consultarDespesaCarroPorDescricao";

	@Column(name = "km", nullable = false, length = 6)
	private String km;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "despesaCarro", cascade=CascadeType.ALL)
	private Set<ItemDespesaCarro> itemDespesaCarros;

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


}
