package br.com.jhonatan.dao;

import java.util.List;

import br.com.jhonatan.entidades.ParcelaDespesa;

public interface ParcelaDespesaDAO {
	
	ParcelaDespesa findById(Class<ParcelaDespesa> classe, Long id);

	void excluir(ParcelaDespesa parcela);

	List<ParcelaDespesa> pesquisarParcelasDaDespesa(Long id);

}
