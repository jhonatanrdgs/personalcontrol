package br.com.jhonatan.service;

import java.util.List;

import br.com.jhonatan.entidades.MetodoPagamento;

public interface MetodoPagamentoService {
	
	public void salvarOuAtualizar(MetodoPagamento metodoPagamento);
	
	public List<MetodoPagamento> pesquisarMetodosPagamento(String descricao);
	
	public MetodoPagamento findById(Long id);

}
