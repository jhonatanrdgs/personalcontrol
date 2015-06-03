package br.com.jhonatan.service;

import java.util.Date;
import java.util.List;

import br.com.jhonatan.dto.FormRelatorioDTO;
import br.com.jhonatan.dto.RelatorioComprasNaoParceladasDTO;
import br.com.jhonatan.dto.RelatorioComprasParceladasDTO;
import br.com.jhonatan.dto.RelatorioDespesaPorCategoriaDTO;
import br.com.jhonatan.dto.RelatorioGastosFixosDTO;
import br.com.jhonatan.dto.RelatorioGastosPorMetodoPagamentoDTO;
import br.com.jhonatan.dto.RelatorioPDFDTO;
import br.com.jhonatan.dto.RelatorioRendimentoGastosDTO;
import br.com.jhonatan.dto.RelatorioTotalGastosMensaisDTO;

public interface RelatorioService {

	/**
	 * Retorna o valor total das despesas por categorias ativas em um deteminado período
	 * @param inicio - data de inicio
	 * @param fim - data final
	 * @return - DTO contendo as categorias com seus respectivos valores
	 */
	List<RelatorioDespesaPorCategoriaDTO> pesquisarDadosRelatorioDespesasPorCategoriasAtivas(Date inicio, Date fim);

	/**
	 * Retorna o valor total das despesas por método de pagamento ativos em um deteminado período
	 * @param inicio - data de inicio
	 * @param fim - data final
	 * @return - DTO contendo os métodos de pagamento com seus respectivos valores
	 */
	List<RelatorioGastosPorMetodoPagamentoDTO> pesquisarDadosRelatorioGastosPorMetodoPagamento(Date inicio, Date fim);
	
	/**
	 * Retorna todas as compras parceladas em um determinado período
	 * @param inicio - data de inicio
	 * @param fim - data final
	 * @return - DTO contendo todas as compras parceladas do período
	 */
	List<RelatorioComprasParceladasDTO> pesquisarDadosRelatorioComprasParceladas(Date inicio, Date fim);

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
	 * @param inicio - data de inicio
	 * @param fim - data final
	 * @return
	 */
	List<RelatorioComprasNaoParceladasDTO> pesquisarDadosRelatorioGastosVariaveis(Date inicio, Date fim);

	/**
	 * Retorna o resumo de gastos de um derterminado periodo
	 * @param inicio - data de inicio
	 * @param fim - data final
	 * @return Array de double, sendo: 1 - Total de Gastos Geral, 2 - Total de gastos variáveis (parcelados e não parcelados), 3 - Total de gastos fixos, 4 - Percentual de renda comprometido  
	 */
	Double[] pesquisarResumo(Date inicio, Date fim);
	
	/**
	 * Retorna todas as despesas de um determinado periodo
	 * @param relatorioForm
	 * @return
	 */
	List<RelatorioPDFDTO> pesquisarDespesasPeriodo(FormRelatorioDTO relatorioForm);

}
