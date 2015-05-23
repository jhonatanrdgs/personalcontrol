package br.com.jhonatan.service;

import java.util.Date;
import java.util.List;

import br.com.jhonatan.dto.RelatorioComprasParceladasDTO;
import br.com.jhonatan.dto.RelatorioDespesaPorCategoriaDTO;
import br.com.jhonatan.dto.RelatorioGastosFixosDTO;
import br.com.jhonatan.dto.RelatorioGastosPorMetodoPagamentoDTO;
import br.com.jhonatan.dto.RelatorioComprasNaoParceladasDTO;
import br.com.jhonatan.dto.RelatorioRendimentoGastosDTO;
import br.com.jhonatan.dto.RelatorioTotalGastosMensaisDTO;

public interface RelatorioService {

	List<RelatorioDespesaPorCategoriaDTO> pesquisarDadosRelatorioDespesasPorCategoriasAtivas(Date inicio, Date fim);

	List<RelatorioComprasParceladasDTO> pesquisarDadosRelatorioComprasParceladas(Date inicio, Date fim);

	List<RelatorioGastosPorMetodoPagamentoDTO> pesquisarDadosRelatorioGastosPorMetodoPagamento(Date inicio, Date fim);

	List<RelatorioGastosFixosDTO> pesquisarDadosRelatorioGastosFixos();

	List<RelatorioTotalGastosMensaisDTO> pesquisarDadosRelatorioGastosMensais();

	List<RelatorioRendimentoGastosDTO> pesquisarDadosRelatorioRendimentosGastos();

	List<RelatorioComprasNaoParceladasDTO> pesquisarDadosRelatorioGastosVariaveis(Date inicio, Date fim);

	Double[] pesquisarResumo(Date inicio, Date fim);

}
