package br.com.jhonatan.service;

import java.util.List;

import br.com.jhonatan.entidades.Categoria;
import br.com.jhonatan.entidades.MetodoPagamento;
import br.com.jhonatan.entidades.Rendimento;

public interface CadastrosGeraisService {
	
	//TODO pensar em modo de isso ficar genérico
	public void salvarOuAtualizarCategoria(Categoria categoria);

	public List<Categoria> pesquisarCategorias(String descricao, boolean ativa);

	public Categoria pesquisarPorId(Long id);

	public List<Categoria> pesquisarTodasCategoriasAtivas();
	
	public void salvarOuAtualizarMetodoPagamento(MetodoPagamento metodoPagamento);
	
	public List<MetodoPagamento> pesquisarMetodosPagamento(String descricao, boolean ativo);
	
	public MetodoPagamento findById(Long id);

	public List<MetodoPagamento> pesquisarTodosMetodosPagamentoAtivos();

	public void salvarOuAtualizarRendimento(Rendimento rendimento);

	public Rendimento findRendimentoById(Long id);

	public List<Rendimento> pesquisarRendimentos(String nomePessoa);

	public void excluirCategoria(Long id);

	public void ativarCategoria(Long id);

	public void excluirRendimento(Long id);

	public void excluirMetodoPagamento(Long id);

	public void ativarMetodoPagamento(Long id);

}
