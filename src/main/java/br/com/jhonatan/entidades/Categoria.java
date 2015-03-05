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


@NamedQueries({
	
	@NamedQuery(name=Categoria.CONSULTAR_CATEGORIAS_POR_DESCRICAO, 
			query="from Categoria c where descricao like concat('%', ?1, '%') or ?1 is null"),
	
	@NamedQuery(name=Categoria.CONSULTAR_TODAS_CATEGORIAS, query="from Categoria c")
	
})

@Entity
@Table(name = "categoria", schema = "personal_control")
public class Categoria implements Serializable {

	private static final long serialVersionUID = 4064100564382874653L;
	public static final String CONSULTAR_CATEGORIAS_POR_DESCRICAO = "categoria.consultarCategoriasPorDescricao";
	public static final String CONSULTAR_TODAS_CATEGORIAS = "categoria.consultareTodasCategorias";

	@Id
	@GeneratedValue(generator="categoria_sequence", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="categoria_sequence", sequenceName="categoria_id_categoria_seq", schema="personal_control")
	@Column(name = "id_categoria", unique = true, nullable = false, columnDefinition="bigserial")
	private Long id;
	
	@Column(name = "descricao", nullable = false, length = 100)
	private String descricao;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria")
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
