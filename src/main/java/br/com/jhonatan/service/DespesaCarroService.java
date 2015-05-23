package br.com.jhonatan.service;

import java.util.List;

import br.com.jhonatan.dto.DespesaDTO;
import br.com.jhonatan.entidades.DespesaCarro;
import br.com.jhonatan.entidades.ItemDespesaCarro;

public interface DespesaCarroService {

	/**
	 * Pesquisa as despesas do carro de acordo com os paramentros passados
	 * @param despesaCarro - parametros
	 * @return - lista de despesas do carro
	 */
	List<DespesaCarro> pesquisarDespesasCarro(DespesaDTO despesaCarro);

	/**
	 * Salva ou atualiza uma despesa carro no banco de dados
	 * @param despesaCarro - DespesaCarro a ser salva/atualizada
	 * @param itens - itens de despesa do carro que devem ser salvas juntamente com a despesaCarro
	 */
	void salvarOuAtualizarDespesasCarro(DespesaCarro despesaCarro, List<ItemDespesaCarro> itens);

	/**
	 * Busca uma despesa carro pelo id no banco de dados
	 * @param id - id da despesaCarro
	 * @return - DespesaCarro
	 */
	DespesaCarro findDespesasCarroById(Long id);

	/**
	 * Exclui uma despesa carro do banco de dados
	  * @param id - id da despesaCarro
	 */
	void excluir(Long id);

}
