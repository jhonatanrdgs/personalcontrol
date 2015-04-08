package br.com.jhonatan.service;

import java.util.List;

import br.com.jhonatan.dto.DespesaDTO;
import br.com.jhonatan.entidades.DespesaCarro;
import br.com.jhonatan.entidades.ItemDespesaCarro;

public interface DespesaCarroService {

	List<DespesaCarro> pesquisarDespesasCarro(DespesaDTO despesaCarro);

	void salvarOuAtualizarDespesasCarro(DespesaCarro despesaCarro, List<ItemDespesaCarro> itens);

	DespesaCarro findDespesasCarroById(Long id);

	void excluir(Long id);

}
