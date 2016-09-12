package br.com.jhonatan.dao;

import java.util.Date;
import java.util.List;

import br.com.jhonatan.dto.RelatorioComprasNaoParceladasDTO;
import br.com.jhonatan.dto.RelatorioComprasParceladasDTO;
import br.com.jhonatan.dto.RelatorioDespesaPorCategoriaDTO;
import br.com.jhonatan.dto.RelatorioGastosFixosDTO;
import br.com.jhonatan.dto.RelatorioGastosMensaisPdfDTO;
import br.com.jhonatan.dto.RelatorioGastosPorMetodoPagamentoDTO;
import br.com.jhonatan.entidades.Despesa;

public interface DespesaDAO {
	
	void salvar(Despesa despesa);
	
	void atualizar(Despesa despesa);
	
	List<Despesa> pesquisarDespesas(Despesa despesa);
	
	Despesa findById(Class<Despesa> classe, Long id);

	Despesa findByIdFetched(Long id);

	List<RelatorioComprasParceladasDTO> pesquisarDespesasParceladasMes(int mes, int ano);

	List<RelatorioGastosFixosDTO> pesquisarDespesasFixas();

	Double pesquisarValorTotalDespesasVariaveisMes(int mes, int ano);

	Double pesquisarSomatorioDespesasFixas();

	List<RelatorioComprasNaoParceladasDTO> pesquisarDespesasVariaveisMes(int mes, int ano);

	void excluir(Despesa despesa);

	List<RelatorioGastosMensaisPdfDTO> pesquisarDespesasPeriodoRelatorioPDF(Date inicio, Date fim);

	List<Despesa> pesquisarDespesasComParcelasProximoMesEmDiante(Date proximoMes);

	Double pesquisarDespessasFixasPorMetodoPagamento(Long idMetodoPagamento);

	List<Despesa> pesquisarUltimasDespesas(Despesa despesa);
	
	List<RelatorioDespesaPorCategoriaDTO> pesquisarDespesasPorCategoriasAtivas(int mes, int ano);
	
	List<RelatorioGastosPorMetodoPagamentoDTO> pesquisarDespesasPorMetodoPagamentoAtivo(int mes, int ano);

}