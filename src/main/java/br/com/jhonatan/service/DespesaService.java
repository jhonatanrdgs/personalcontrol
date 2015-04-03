package br.com.jhonatan.service;

import java.util.List;
import java.util.Set;

import br.com.jhonatan.dto.DespesaDTO;
import br.com.jhonatan.entidades.Despesa;
import br.com.jhonatan.entidades.ParcelaDespesa;

public interface DespesaService {
	
	public void salvarOuAtualizar(Despesa despesa);
	
	public List<Despesa> pesquisarDespesas(DespesaDTO despesaDTO);
	
	public Despesa findById(Long id);

	public Despesa findByIdFetched(Long id);
	
	public Set<ParcelaDespesa> montarListaParcelas(Despesa despesa); 

}
