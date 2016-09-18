package br.com.jhonatan.dao;

import java.util.List;

import br.com.jhonatan.entidades.MetodoPagamento;

interface MetodoPagamentoDAO {

	void salvar(MetodoPagamento metodoPagamento);
	
	void atualizar(MetodoPagamento metodoPagamento);
	
	List<MetodoPagamento> pesquisarMetodosPagamento(String descricao, boolean ativo);
	
	MetodoPagamento findById(Class<MetodoPagamento> classe, Long id);

	List<MetodoPagamento> pesquisarTodosMetodosPagamentoAtivos();

}
