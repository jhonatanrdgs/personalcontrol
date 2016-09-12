package br.com.jhonatan.dao;

import java.util.List;

import br.com.jhonatan.dto.RelatorioGastosPorMetodoPagamentoDTO;
import br.com.jhonatan.entidades.MetodoPagamento;

public interface MetodoPagamentoDAO {

	public void salvar(MetodoPagamento metodoPagamento);
	
	public void atualizar(MetodoPagamento metodoPagamento);
	
	public List<MetodoPagamento> pesquisarMetodosPagamento(String descricao, boolean ativo);
	
	public MetodoPagamento findById(Class<MetodoPagamento> classe, Long id);

	public List<MetodoPagamento> pesquisarTodosMetodosPagamentoAtivos();

}
