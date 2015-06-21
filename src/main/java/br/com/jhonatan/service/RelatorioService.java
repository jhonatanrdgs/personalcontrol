package br.com.jhonatan.service;

import java.util.List;

import br.com.jhonatan.dto.FormRelatorioDTO;
import br.com.jhonatan.dto.RelatorioComprasNaoParceladasDTO;
import br.com.jhonatan.dto.RelatorioComprasParceladasDTO;
import br.com.jhonatan.dto.RelatorioDespesaCarroPdfDTO;
import br.com.jhonatan.dto.RelatorioDespesaPorCategoriaDTO;
import br.com.jhonatan.dto.RelatorioGastosFixosDTO;
import br.com.jhonatan.dto.RelatorioGastosMensaisPdfDTO;
import br.com.jhonatan.dto.RelatorioGastosPorMetodoPagamentoDTO;
import br.com.jhonatan.dto.RelatorioRendimentoGastosDTO;
import br.com.jhonatan.dto.RelatorioTotalGastosMensaisDTO;

public interface RelatorioService {

	/**
	 * Retorna o valor total das despesas por categorias ativas em um deteminado período
	 * @param mes - data de inicio
	 * @param ano - data final
	 * @return - DTO contendo as categorias com seus respectivos valores
	 */
	List<RelatorioDespesaPorCategoriaDTO> pesquisarDadosRelatorioDespesasPorCategoriasAtivas(int mes, int ano);

	/**
	 * Retorna o valor total das despesas por método de pagamento ativos em um deteminado período
	 * @param mes - data de inicio
	 * @param ano - data final
	 * @return - DTO contendo os métodos de pagamento com seus respectivos valores
	 */
	List<RelatorioGastosPorMetodoPagamentoDTO> pesquisarDadosRelatorioGastosPorMetodoPagamento(int mes, int ano);
	
	/**
	 * Retorna todas as compras parceladas em um determinado período
	 * @param mes - data de inicio
	 * @param ano - data final
	 * @return - DTO contendo todas as compras parceladas do período
	 */
	List<RelatorioComprasParceladasDTO> pesquisarDadosRelatorioComprasParceladas(int mes, int ano);

	/**
	 * Retorna todos os gastos fixos
	 * @return - DTO contendo todos os gastos fixos
	 */
	List<RelatorioGastosFixosDTO> pesquisarDadosRelatorioGastosFixos();

	/**
	 * Retorna o valor total das despesas fixas e variáveis dos últimos 12 meses
	 * @return - DTO contendo as despesas dos ultimos 12 meses
	 */
	List<RelatorioTotalGastosMensaisDTO> pesquisarDadosRelatorioGastosMensais();

	/**
	 * Retorna o valor total das depesas fixas e variáveis e dos rendimentos dos últimos 12 meses
	 * @return - DTO contendo as despesas e rendimentos dos ultimos 12 meses 
	 */
	List<RelatorioRendimentoGastosDTO> pesquisarDadosRelatorioRendimentosGastos();

	/**
	 * Retorna as compras não parceladas de um determinado período
	 * @param mes - data de inicio
	 * @param ano - data final
	 * @return
	 */
	List<RelatorioComprasNaoParceladasDTO> pesquisarDadosRelatorioGastosVariaveis(int mes, int ano);

	/**
	 * Retorna o resumo de gastos de um derterminado periodo
	 * @param mes - data de inicio
	 * @param ano - data final
	 * @return Array de double, sendo: 1 - Total de Gastos Geral, 2 - Total de gastos variáveis (parcelados e não parcelados), 3 - Total de gastos fixos, 4 - Percentual de renda comprometido  
	 */
	Double[] pesquisarResumo(int mes, int ano);
	
	/**
	 * Retorna todas as despesas de um determinado periodo
	 * @param relatorioForm
	 * @return
	 */
	List<RelatorioGastosMensaisPdfDTO> pesquisarDadosRelatorioGastosMensaisPDF(FormRelatorioDTO relatorioForm);

	List<RelatorioDespesaCarroPdfDTO> pesquisarDadosRelatorioDespesaCarro();

}
