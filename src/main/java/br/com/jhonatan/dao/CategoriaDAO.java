package br.com.jhonatan.dao;

import java.util.List;

import br.com.jhonatan.entidades.Categoria;

public interface CategoriaDAO {
	
	void salvar(Categoria categoria);
	
	void atualizar(Categoria categoria);

	List<Categoria> pesquisarCategorias(String descricao, boolean ativa);

	Categoria findById(Class<Categoria> classe, Long id);

	List<Categoria> pesquisarTodasCategoriasAtivas();

}
