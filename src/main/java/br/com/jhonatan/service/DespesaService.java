package br.com.jhonatan.service;

import java.util.List;

import br.com.jhonatan.entidades.Despesa;
import br.com.jhonatan.entidades.ParcelaDespesa;

public interface DespesaService {
	
	/**
	 * Salva uma despesa no banco de dados
	 * As despesas não fixas sempre tem relacionamento com ParcelaDespesa
	 * @param despesa
	 */
	public void salvarOuAtualizar(Despesa despesa);

	/**
	 * Pesquisa no banco de dados as despesas de acordo com os parametros passados
	 * @param despesa
	 * @return lista de despesas recuperadas
	 */
	public List<Despesa> pesquisarDespesas(Despesa despesa);
	
	/**
	 * Busca uma despesa no banco de dados pelo seu id
	 * @param id - id da despesa
	 * @return despesa recuperada ou null caso não encontre
	 */
	public Despesa findById(Long id);

	/**
	 * Busca uma despesa no banco de dados pelo seu id, porém já faz o join com categoria, método pagamento, usuário e parcelas
	 * @param id
	 * @return
	 */
	public Despesa findByIdFetched(Long id);
	
	/**
	 * Exclui uma despesa do banco de dados
	 * @param id - id da despesa
	 */
	public void excluirDespesa(Long id);

	public void adiantarPagamentoParcela(Long idParcela);

	public List<Despesa> pesquisarDespesasComParcelasProximoMesEmDiante();

	public List<ParcelaDespesa> pesquisarParcelasDaDespesa(Long id);

	public void adiantarPagamentoTodasParcelas(Long idDespesa);

}
