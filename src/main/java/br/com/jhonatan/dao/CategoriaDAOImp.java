package br.com.jhonatan.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import br.com.jhonatan.dto.RelatorioDespesaPorCategoriaDTO;
import br.com.jhonatan.entidades.Categoria;

@Repository
public class CategoriaDAOImp extends GenericDAO<Categoria> implements CategoriaDAO  {

	private static final long serialVersionUID = 974619289469912497L;

	@Override
	public List<Categoria> pesquisarCategorias(String descricao, boolean ativa, Pageable pageable) {
		return criarQueryResultList(Categoria.CONSULTAR_CATEGORIAS_POR_DESCRICAO, ativa, descricao);
	}

	@Override
	public List<Categoria> pesquisarTodasCategoriasAtivas() {
		return criarQueryResultList(Categoria.CONSULTAR_TODAS_CATEGORIAS_ATIVAS);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RelatorioDespesaPorCategoriaDTO> pesquisarDespesasPorCategoriasAtivas(Date inicio, Date fim) {
		return criarQueryResultListSemTipagem(Categoria.CONSULTAR_DESPESAS_POR_CATEGORIAS_ATIVAS, inicio, fim);
	}
	
	
	
	
}