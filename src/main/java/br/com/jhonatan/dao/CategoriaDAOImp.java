package br.com.jhonatan.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.jhonatan.entidades.Categoria;

@Repository
public class CategoriaDAOImp extends GenericDAO<Categoria> implements CategoriaDAO  {

	private static final long serialVersionUID = 974619289469912497L;

	@Override
	public List<Categoria> pesquisarCategorias(final String descricao, final boolean ativa) {
		return criarQueryResultList(Categoria.CONSULTAR_CATEGORIAS_POR_DESCRICAO, ativa, descricao);
	}

	@Override
	public List<Categoria> pesquisarTodasCategoriasAtivas() {
		return criarQueryResultList(Categoria.CONSULTAR_TODAS_CATEGORIAS_ATIVAS);
	}

}