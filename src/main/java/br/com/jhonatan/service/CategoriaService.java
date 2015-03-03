package br.com.jhonatan.service;

import java.util.List;

import br.com.jhonatan.entidades.Categoria;

public interface CategoriaService {
	
	public void salvarOuAtualizar(Categoria categoria);

	public List<Categoria> pesquisarCategorias(String descricao);

	public Categoria pesquisarPorId(Long id);

}
