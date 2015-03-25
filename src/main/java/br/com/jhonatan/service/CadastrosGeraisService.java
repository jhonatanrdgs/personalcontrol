package br.com.jhonatan.service;

import java.util.List;

import br.com.jhonatan.entidades.Categoria;
import br.com.jhonatan.entidades.MetodoPagamento;
import br.com.jhonatan.entidades.Rendimento;

public interface CadastrosGeraisService {
	
	//TODO pensar em mundo de isso ficar genérico
	public void salvarOuAtualizarCategoria(Categoria categoria);

	public List<Categoria> pesquisarCategorias(String descricao);

	public Categoria pesquisarPorId(Long id);

	public List<Categoria> pesquisarTodasCategoriasAtivas();
	
	public void salvarOuAtualizarMetodoPagamento(MetodoPagamento metodoPagamento);
	
	public List<MetodoPagamento> pesquisarMetodosPagamento(String descricao);
	
	public MetodoPagamento findById(Long id);

	public List<MetodoPagamento> pesquisarTodosMetodosPagamentoAtivos();

	public void salvarOuAtualizarRendimento(Rendimento rendimento);

	public Rendimento findRendimentoById(Long id);

	public List<Rendimento> pesquisarRendimentos(String nomePessoa);

}
