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
			query="from Categoria c where ativo = ?1 and (descricao like concat('%', ?2, '%') or ?2 is null)"),
	
	@NamedQuery(name=Categoria.CONSULTAR_TODAS_CATEGORIAS_ATIVAS, query="from Categoria c where ativo = true order by descricao"),
	
	@NamedQuery(name=Categoria.CONSULTAR_DESPESAS_POR_CATEGORIAS_ATIVAS,
		query="select new br.com.jhonatan.dto.RelatorioDespesaPorCategoriaDTO(c.descricao, sum(p.valorParcela)) from Categoria c"
				+ " join c.despesas d"
				+ " join d.parcelas p"
				+ " where c.ativo = true "
				+ " and p.dataParcela between ?1 and ?2"
				+ " and d.fixa = false"
				+ " group by c.descricao")
	
})

@Entity
@Table(name = "categoria", schema = "personal_control")
public class Categoria extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 4064100564382874653L;
	public static final String CONSULTAR_CATEGORIAS_POR_DESCRICAO = "categoria.consultarCategoriasPorDescricao";
	public static final String CONSULTAR_TODAS_CATEGORIAS_ATIVAS = "categoria.consultarTodasCategoriasAtivas";
	public static final String CONSULTAR_DESPESAS_POR_CATEGORIAS_ATIVAS = "categoria.consultarDespesasPorCategoria";
	
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
	
	@Column(name="ativo", nullable = false)
	private boolean ativo;
	
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
	
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Set<Despesa> getDespesas() {
		return despesas;
	}

	public void setDespesas(Set<Despesa> despesas) {
		this.despesas = despesas;
	}
	
}
