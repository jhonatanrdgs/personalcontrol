package br.com.jhonatan.service;

import java.util.List;

import br.com.jhonatan.dto.DespesaDTO;
import br.com.jhonatan.entidades.Despesa;

public interface DespesaService {
	
	public void salvarOuAtualizar(Despesa despesa);
	
	public List<Despesa> pesquisarDespesas(DespesaDTO despesaDTO);
	
	public Despesa findById(Long id);

	public Despesa findByIdFetched(Long id);

}
