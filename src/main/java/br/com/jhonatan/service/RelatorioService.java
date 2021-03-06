package br.com.jhonatan.service;

import java.util.List;

import br.com.jhonatan.dto.FormRelatorioDTO;
import br.com.jhonatan.dto.RelatorioBarraSimuladorRendimentoGastoDTO;
import br.com.jhonatan.dto.RelatorioComprasNaoParceladasDTO;
import br.com.jhonatan.dto.RelatorioComprasParceladasDTO;
import br.com.jhonatan.dto.RelatorioDespesaCarroPdfDTO;
import br.com.jhonatan.dto.RelatorioDespesaPorCategoriaDTO;
import br.com.jhonatan.dto.RelatorioGastosFixosDTO;
import br.com.jhonatan.dto.RelatorioGastosMensaisPdfDTO;
import br.com.jhonatan.dto.RelatorioGastosPorMetodoPagamentoDTO;
import br.com.jhonatan.dto.RelatorioLinhaSimuladorRendimentoGastoDTO;
import br.com.jhonatan.dto.RelatorioPercentualComprometido12MesesDTO;
import br.com.jhonatan.dto.RelatorioRendimentoGastosDTO;
import br.com.jhonatan.dto.RelatorioResumoDTO;
import br.com.jhonatan.entidades.Despesa;

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
	 * Retorna o valor total das depesas fixas e variáveis e dos rendimentos dos últimos 12 meses
	 * @return - DTO contendo as despesas e rendimentos dos ultimos 12 meses 
	 */
	List<RelatorioRendimentoGastosDTO> pesquisarDadosRelatorioRendimentosGastos();

	/**
	 * Retorna as compras não parceladas de um determinado período
	 * @param mes - data de inicio
	 * @param ano - data final
	 * @return lista de despesas para o report
	 */
	List<RelatorioComprasNaoParceladasDTO> pesquisarDadosRelatorioGastosVariaveis(int mes, int ano);

	/**
	 * Retorna o resumo de gastos de um derterminado periodo
	 * @param mes - data de inicio
	 * @param ano - data final
	 * @return dados do relatorio
	 */
	RelatorioResumoDTO pesquisarResumo(int mes, int ano);
	
	/**
	 * Retorna todas as despesas de um determinado periodo
	 * @param relatorioForm form com os dados da busca
	 * @return dados do relatorio
	 */
	List<RelatorioGastosMensaisPdfDTO> pesquisarDadosRelatorioGastosMensaisPDF(FormRelatorioDTO relatorioForm);

	List<RelatorioDespesaCarroPdfDTO> pesquisarDadosRelatorioDespesaCarro();

	List<RelatorioLinhaSimuladorRendimentoGastoDTO> montarRelatorioLinhaSimulacaoGastos(Despesa despesa);

	List<RelatorioBarraSimuladorRendimentoGastoDTO> montarRelatorioBarraSimulacaoGastos(Despesa despesa);
	
	List<RelatorioPercentualComprometido12MesesDTO> montarRelatorioPercentualComprometido12Meses();

}
