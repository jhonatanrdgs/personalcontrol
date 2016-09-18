package br.com.jhonatan.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jhonatan.dao.DespesaCarroDAO;
import br.com.jhonatan.dao.DespesaDAO;
import br.com.jhonatan.dao.RendimentoDAO;
import br.com.jhonatan.dto.FormRelatorioDTO;
import br.com.jhonatan.dto.ItemDespesaCarroDTO;
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
import br.com.jhonatan.entidades.DespesaCarro;
import br.com.jhonatan.entidades.ItemDespesaCarro;
import br.com.jhonatan.util.DateUtil;
import br.com.jhonatan.util.NumberUtil;

@Service
public class RelatorioServiceImp implements RelatorioService {
	
	@Autowired
	private DespesaDAO despesaDAO;
	
	@Autowired
	private RendimentoDAO rendimentoDAO;
	
	@Autowired
	private DespesaCarroDAO despesaCarroDAO;
	
	@Override
	public RelatorioResumoDTO pesquisarResumo(final int mes, final int ano) {
		final Date data = DateUtil.getPrimeiroDiaMes(mes - 1, ano);
		final RelatorioResumoDTO dto = new RelatorioResumoDTO(
				despesaDAO.pesquisarValorTotalDespesasVariaveisMes(mes, ano), despesaDAO.pesquisarSomatorioDespesasFixas(),
				rendimentoDAO.pesquisarRendimentosPorMes(data));
		
		return dto;
	}

	@Override
	public List<RelatorioDespesaPorCategoriaDTO> pesquisarDadosRelatorioDespesasPorCategoriasAtivas(final int mes, final int ano) {
		return despesaDAO.pesquisarDespesasPorCategoriasAtivas(mes, ano);
	}

	@Override
	public List<RelatorioGastosPorMetodoPagamentoDTO> pesquisarDadosRelatorioGastosPorMetodoPagamento(final int mes, final int ano) {
		final List<RelatorioGastosPorMetodoPagamentoDTO> lista = despesaDAO.pesquisarDespesasPorMetodoPagamentoAtivo(mes, ano);
		for (final RelatorioGastosPorMetodoPagamentoDTO dto : lista) {
			dto.adicionarValor(NumberUtil.zeroIfNull(despesaDAO.pesquisarDespessasFixasPorMetodoPagamento(dto.getIdMetodoPagamento())));
		}
		return lista;
	}
	
	@Override
	public List<RelatorioComprasParceladasDTO> pesquisarDadosRelatorioComprasParceladas(final int mes, final int ano) {
		return despesaDAO.pesquisarDespesasParceladasMes(mes, ano);
	}
	
	@Override
	public List<RelatorioComprasNaoParceladasDTO> pesquisarDadosRelatorioGastosVariaveis(final int mes, final int ano) {
		return despesaDAO.pesquisarDespesasVariaveisMes(mes, ano);
	}

	@Override
	public List<RelatorioGastosFixosDTO> pesquisarDadosRelatorioGastosFixos() {
		return despesaDAO.pesquisarDespesasFixas();
	}

	@Override
	public List<RelatorioRendimentoGastosDTO> pesquisarDadosRelatorioRendimentosGastos() {
		Date inicio = DateUtil.getPrimeiroDiaMes(DateUtil.subtrairMeses(new Date(), 6));
		
		final List<RelatorioRendimentoGastosDTO> list = new ArrayList<RelatorioRendimentoGastosDTO>();
		final Double valorDespesasFixas = NumberUtil.zeroIfNull(despesaDAO.pesquisarSomatorioDespesasFixas());
		for (int i = 0; i <= 12; i++) {
			final Double rendimentos = NumberUtil.zeroIfNull(rendimentoDAO.pesquisarRendimentosPorMes(inicio));
			final int mes = DateUtil.getMes(inicio);
			final int ano = DateUtil.getAno(inicio);
			
			final Double valorVariavelMensal = NumberUtil.zeroIfNull(despesaDAO.pesquisarValorTotalDespesasVariaveisMes(mes, ano));
			final Double valorDespesas = valorVariavelMensal + valorDespesasFixas;
			final RelatorioRendimentoGastosDTO dto = new RelatorioRendimentoGastosDTO(mes, ano, valorDespesas, rendimentos);
			list.add(dto);
			inicio = DateUtil.adicionarMeses(inicio, 1);
		}
		return list;
	}

	@Override
	public List<RelatorioGastosMensaisPdfDTO> pesquisarDadosRelatorioGastosMensaisPDF(final FormRelatorioDTO relatorioForm) {
		final Date inicio = DateUtil.getPrimeiroDiaMes(relatorioForm.getMes(), relatorioForm.getAno());
		final Date fim = DateUtil.getUltimoDiaMes(relatorioForm.getMes(), relatorioForm.getAno());
		return despesaDAO.pesquisarDespesasPeriodoRelatorioPDF(inicio, fim);
	}

	@Override
	public List<RelatorioDespesaCarroPdfDTO> pesquisarDadosRelatorioDespesaCarro() {
		final List<DespesaCarro> list = despesaCarroDAO.pesquisarDespesasCarroPeriodo();
		final List<RelatorioDespesaCarroPdfDTO> dtos = new ArrayList<RelatorioDespesaCarroPdfDTO>();
		for (final DespesaCarro dc : list) {
			final RelatorioDespesaCarroPdfDTO dto = new RelatorioDespesaCarroPdfDTO(dc.getKm(), dc.getData());
			for (final ItemDespesaCarro idc : dc.getItemDespesaCarros()) {
				final ItemDespesaCarroDTO idcDTO = new ItemDespesaCarroDTO(idc.getDescricao(), idc.getValorItem());
				dto.getItensDespesaCarro().add(idcDTO);
			}
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public List<RelatorioLinhaSimuladorRendimentoGastoDTO> montarRelatorioLinhaSimulacaoGastos(final Despesa despesa) {
		Date inicio = DateUtil.getPrimeiroDiaMes(despesa.getData());
		
		final List<RelatorioLinhaSimuladorRendimentoGastoDTO> list = new ArrayList<RelatorioLinhaSimuladorRendimentoGastoDTO>();
		final Double valorDespesasFixas = NumberUtil.zeroIfNull(despesaDAO.pesquisarSomatorioDespesasFixas());
		
		final Double valorParcelaDespesa = despesa.getValorTotal() / despesa.getTotalParcelas();
		
		for (int i = 0; i < despesa.getTotalParcelas(); i++) {
			final Double rendimentos = NumberUtil.zeroIfNull(rendimentoDAO.pesquisarRendimentosPorMes(inicio));
			final int mes = DateUtil.getMes(inicio);
			final int ano = DateUtil.getAno(inicio);
			
			final Double valorVariavelMensal = NumberUtil.zeroIfNull(despesaDAO.pesquisarValorTotalDespesasVariaveisMes(mes, ano));
			final Double valorDespesasNaoSimuladas = valorVariavelMensal + valorDespesasFixas;
			final Double valorDespesasSimuladas = valorVariavelMensal + valorDespesasFixas + valorParcelaDespesa;
			final RelatorioLinhaSimuladorRendimentoGastoDTO dto =
				new RelatorioLinhaSimuladorRendimentoGastoDTO(valorDespesasNaoSimuladas, valorDespesasSimuladas, rendimentos, mes, ano);
			list.add(dto);
			inicio = DateUtil.adicionarMeses(inicio, 1);
		}
		return list;
	}

	@Override
	public List<RelatorioBarraSimuladorRendimentoGastoDTO> montarRelatorioBarraSimulacaoGastos(final Despesa despesa) {
		Date inicio = DateUtil.getPrimeiroDiaMes(despesa.getData());
		
		final List<RelatorioBarraSimuladorRendimentoGastoDTO> list = new ArrayList<RelatorioBarraSimuladorRendimentoGastoDTO>();
		final Double valorDespesasFixas = NumberUtil.zeroIfNull(despesaDAO.pesquisarSomatorioDespesasFixas());
		final Double valorParcela = despesa.getValorTotal() / despesa.getTotalParcelas();
		
		for (int i = 0; i < despesa.getTotalParcelas(); i++) {
			final Double rendimentos = NumberUtil.zeroIfNull(rendimentoDAO.pesquisarRendimentosPorMes(inicio));
			final int mes = DateUtil.getMes(inicio);
			final int ano = DateUtil.getAno(inicio);
			final Double valorVariavelMensal = NumberUtil.zeroIfNull(despesaDAO.pesquisarValorTotalDespesasVariaveisMes(mes, ano));
			Double totalGastos = valorDespesasFixas + valorVariavelMensal;
			final Double percentualSemSimulacao = (totalGastos / rendimentos) * 100;
			totalGastos += valorParcela;
			final Double percentualComSimulacao = (totalGastos / rendimentos) * 100;
			
			final RelatorioBarraSimuladorRendimentoGastoDTO dto =
					new RelatorioBarraSimuladorRendimentoGastoDTO(percentualSemSimulacao, percentualComSimulacao, mes, ano);
			list.add(dto);
			inicio = DateUtil.adicionarMeses(inicio, 1);
		}
		return list;
	}

	@Override
	public List<RelatorioPercentualComprometido12MesesDTO> montarRelatorioPercentualComprometido12Meses() {
		Date inicio = DateUtil.getPrimeiroDiaMes(new Date());
		
		final List<RelatorioPercentualComprometido12MesesDTO> list = new ArrayList<RelatorioPercentualComprometido12MesesDTO>();
		final Double valorDespesasFixas = NumberUtil.zeroIfNull(despesaDAO.pesquisarSomatorioDespesasFixas());
		
		for (int i = 0; i < 12; i++) {
			final int mes = DateUtil.getMes(inicio);
			final int ano = DateUtil.getAno(inicio);
			final Double rendimentos = NumberUtil.zeroIfNull(rendimentoDAO.pesquisarRendimentosPorMes(inicio));
			final Double valorVariavelMensal = NumberUtil.zeroIfNull(despesaDAO.pesquisarValorTotalDespesasVariaveisMes(mes, ano));
			final Double totalGastos = valorDespesasFixas + valorVariavelMensal;
			final Double percentual = (totalGastos / rendimentos) * 100;
			final RelatorioPercentualComprometido12MesesDTO dto = new RelatorioPercentualComprometido12MesesDTO(ano, mes, percentual);
			list.add(dto);
			inicio = DateUtil.adicionarMeses(inicio, 1);
		}
		
		return list;
	}
	
}
