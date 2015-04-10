package br.com.jhonatan.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;

import br.com.jhonatan.dto.RelatorioDespesaPorCategoriaDTO;
import br.com.jhonatan.entidades.Categoria;

public interface CategoriaDAO {
	
	public void salvar(Categoria categoria);
	
	public void atualizar(Categoria categoria);

	public List<Categoria> pesquisarCategorias(String descricao, boolean ativa, Pageable pageable);

	public Categoria findById(Class<Categoria> classe, Long id);

	public List<Categoria> pesquisarTodasCategoriasAtivas();

	public List<RelatorioDespesaPorCategoriaDTO> pesquisarDespesasPorCategoriasAtivas(Date inicio, Date fim);

}
