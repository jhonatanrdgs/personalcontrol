package br.com.jhonatan.dao;

import java.util.List;

import br.com.jhonatan.entidades.Categoria;

public interface CategoriaDAO {
	
	public void salvar(Categoria categoria);
	
	public void atualizar(Categoria categoria);

	public List<Categoria> pesquisarCategorias(String descricao);

	public Categoria findById(Class<Categoria> classe, Long id);

}
