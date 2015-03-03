package br.com.jhonatan.service;

import java.util.Date;
import java.util.List;

import br.com.jhonatan.entidades.Despesa;

public interface DespesaService {
	
	public void salvarOuAtualizar(Despesa despesa);
	
	public List<Despesa> pesquisarDespesas(String descricao, Long idCategoria,
			Long idMetodoPagamento, Date inicio, Date fim);
	
	public Despesa findById(Long id);

}
