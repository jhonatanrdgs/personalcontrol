package br.com.jhonatan.service;

import java.util.List;

import br.com.jhonatan.entidades.Despesa;
import br.com.jhonatan.entidades.ParcelaDespesa;

public interface DespesaService {
	
	/**
	 * Salva uma despesa no banco de dados
	 * As despesas não fixas sempre tem relacionamento com ParcelaDespesa
	 * @param despesa despesa a ser salva
	 */
	void salvarOuAtualizar(Despesa despesa);

	/**
	 * Pesquisa no banco de dados as despesas de acordo com os parametros passados
	 * @param despesa dados para a busca da despesa
	 * @return lista de despesas recuperadas
	 */
	List<Despesa> pesquisarDespesas(Despesa despesa);
	
	/**
	 * Busca uma despesa no banco de dados pelo seu id
	 * @param id - id da despesa
	 * @return despesa recuperada ou null caso não encontre
	 */
	Despesa findById(Long id);

	/**
	 * Busca uma despesa no banco de dados pelo seu id, porém já faz o join com categoria, método pagamento, usuário e parcelas
	 * @param id id da despesa a ser procurada
	 * @return despesa com fetch
	 */
	Despesa findByIdFetched(Long id);
	
	/**
	 * Exclui uma despesa do banco de dados
	 * @param id - id da despesa
	 */
	void excluirDespesa(Long id);

	void adiantarPagamentoParcela(Long idParcela);

	List<Despesa> pesquisarDespesasComParcelasProximoMesEmDiante();

	List<ParcelaDespesa> pesquisarParcelasDaDespesa(Long id);

	void adiantarPagamentoTodasParcelas(Long idDespesa);

	List<Despesa> pesquisarUltimasDespesas(Despesa despesa);

}
