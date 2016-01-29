package br.com.jhonatan.dao;

import java.util.List;

import br.com.jhonatan.entidades.DespesaCarro;

public interface DespesaCarroDAO {

	List<DespesaCarro> pesquisarDespesasCarro(DespesaCarro despesaCarro);

	void salvar(DespesaCarro despesaCarro);

	void atualizar(DespesaCarro despesaCarro);

	DespesaCarro findById(Class<DespesaCarro> class1, Long id);

	void excluir(DespesaCarro despesaCarro);

	List<DespesaCarro> pesquisarDespesasCarroPeriodo();

	DespesaCarro findByIdFetched(Long id);

}
