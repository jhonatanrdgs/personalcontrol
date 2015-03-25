package br.com.jhonatan.service;

import java.util.List;

import br.com.jhonatan.entidades.DespesaCarro;

public interface DespesaCarroService {

	List<DespesaCarro> pesquisarDespesasCarro(String descricao);

	void salvarOuAtualizarDespesasCarro(DespesaCarro despesaCarro);

	DespesaCarro findDespesasCarroById(Long id);

}
