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

import com.fasterxml.jackson.annotation.JsonIgnore;


@NamedQueries({
	
	@NamedQuery(name=Categoria.CONSULTAR_CATEGORIAS_POR_DESCRICAO, 
			query="from Categoria c where ativo = ?1 and (upper(descricao) like concat('%', upper(?2), '%') or ?2 is null)"),
	
	@NamedQuery(name=Categoria.CONSULTAR_TODAS_CATEGORIAS_ATIVAS, query="from Categoria c where ativo = true order by descricao")
	
})

@Entity
@Table(name = "categoria", schema = "personal_control")
public class Categoria extends AbstractBaseEntity implements Serializable {

	private static final long serialVersionUID = 4064100564382874653L;
	public static final String CONSULTAR_CATEGORIAS_POR_DESCRICAO = "categoria.consultarCategoriasPorDescricao";
	public static final String CONSULTAR_TODAS_CATEGORIAS_ATIVAS = "categoria.consultarTodasCategoriasAtivas";
	
	
	public Categoria() {
		this.ativo = true;
	}

	@Id
	@GeneratedValue(generator="categoria_sequence", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="categoria_sequence", sequenceName="categoria_id_categoria_seq", schema="personal_control")
	@Column(name = "id_categoria", unique = true, nullable = false, columnDefinition="bigserial")
	private Long id;
	
	@Column(name = "descricao", nullable = false, length = 100)
	private String descricao;
	
	@JsonIgnore
	@Column(name="ativo", nullable = false)
	private boolean ativo;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria")
	private Set<Despesa> despesas;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(final String descricao) {
		this.descricao = descricao;
	}
	
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(final boolean ativo) {
		this.ativo = ativo;
	}

	public Set<Despesa> getDespesas() {
		return despesas;
	}

	public void setDespesas(final Set<Despesa> despesas) {
		this.despesas = despesas;
	}
	
}
