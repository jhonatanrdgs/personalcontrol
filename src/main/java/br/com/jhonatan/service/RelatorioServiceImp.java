package br.com.jhonatan.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jhonatan.dao.CategoriaDAO;
import br.com.jhonatan.dao.DespesaDAO;
import br.com.jhonatan.dao.MetodoPagamentoDAO;
import br.com.jhonatan.dao.RendimentoDAO;
import br.com.jhonatan.dto.RelatorioComprasParceladasDTO;
import br.com.jhonatan.dto.RelatorioDespesaPorCategoriaDTO;
import br.com.jhonatan.dto.RelatorioGastosFixosDTO;
import br.com.jhonatan.dto.RelatorioGastosPorMetodoPagamentoDTO;
import br.com.jhonatan.dto.RelatorioComprasNaoParceladasDTO;
import br.com.jhonatan.dto.RelatorioRendimentoGastosDTO;
import br.com.jhonatan.dto.RelatorioTotalGastosMensaisDTO;
import br.com.jhonatan.util.DateUtil;
import br.com.jhonatan.util.NumberUtil;

@Service
public class RelatorioServiceImp implements RelatorioService {
	
	@Autowired
	private CategoriaDAO categoriaDAO;
	
	@Autowired
	private DespesaDAO despesaDAO;
	
	@Autowired
	private MetodoPagamentoDAO metodoPagamentoDAO;
	
	@Autowired
	private RendimentoDAO rendimentoDAO;
	
	@Override
	public Double[] pesquisarResumo(Date inicio, Date fim) {
		Double totalGastosVariaveisPeriodo = NumberUtil.zeroIfNull(despesaDAO.pesquisarValorTotalDespesasVariaveisPeriodo(inicio, fim));
		totalGastosVariaveisPeriodo = NumberUtil.normalizarDouble(totalGastosVariaveisPeriodo, 2);
		
		Double totalGastosFixos = NumberUtil.zeroIfNull(despesaDAO.pesquisarSomatorioDespesasFixas());
		totalGastosFixos = NumberUtil.normalizarDouble(totalGastosFixos, 2);
		
		Double totalGastos  = totalGastosVariaveisPeriodo + totalGastosFixos;
		totalGastos = NumberUtil.normalizarDouble(totalGastos, 2);
		
		Double rendimentos = NumberUtil.zeroIfNull(rendimentoDAO.pesquisarRendimentosPorMes());
		Double percentualComprometido = (totalGastos / rendimentos) * 100;
		percentualComprometido = NumberUtil.normalizarDouble(percentualComprometido, 2);
		
		return new Double[] {totalGastos, totalGastosVariaveisPeriodo, totalGastosFixos, percentualComprometido};
	}

	@Override
	public List<RelatorioDespesaPorCategoriaDTO> pesquisarDadosRelatorioDespesasPorCategoriasAtivas(Date inicio, Date fim) {
		return categoriaDAO.pesquisarDespesasPorCategoriasAtivas(inicio, fim);
	}

	@Override
	public List<RelatorioGastosPorMetodoPagamentoDTO> pesquisarDadosRelatorioGastosPorMetodoPagamento(Date inicio, Date fim) {
		return metodoPagamentoDAO.pesquisarDespesasPorMetodoPagamentoAtivo(inicio, fim);
	}
	
	@Override
	public List<RelatorioComprasParceladasDTO> pesquisarDadosRelatorioComprasParceladas(Date inicio, Date fim) {
		return despesaDAO.pesquisarDespesasParceladasPeriodo(inicio, fim);
	}
	
	@Override
	public List<RelatorioComprasNaoParceladasDTO> pesquisarDadosRelatorioGastosVariaveis(Date inicio, Date fim) {
		return despesaDAO.pesquisarDespesasVariaveisPeriodo(inicio, fim);
	}

	@Override
	public List<RelatorioGastosFixosDTO> pesquisarDadosRelatorioGastosFixos() {
		return despesaDAO.pesquisarDespesasFixas();
	}

	@Override
	public List<RelatorioTotalGastosMensaisDTO> pesquisarDadosRelatorioGastosMensais() {
		Date inicio = DateUtil.getPrimeiroDiaMes(DateUtil.subtrairMeses(new Date(), 6));
		
		List<RelatorioTotalGastosMensaisDTO> list = new ArrayList<RelatorioTotalGastosMensaisDTO>();
		Double valorDespesasFixas = NumberUtil.zeroIfNull(despesaDAO.pesquisarSomatorioDespesasFixas());
		for (int i = 0; i < 13; i++) {
			Date fim = DateUtil.getUltimoDiaMes(inicio);
			RelatorioTotalGastosMensaisDTO dto = new RelatorioTotalGastosMensaisDTO();
			Double valorVariavelMensal = NumberUtil.zeroIfNull(despesaDAO.pesquisarValorTotalDespesasVariaveisPeriodo(inicio, fim));
			dto.setValorDespesasVariaveis(valorVariavelMensal);
			dto.setValorDespesasFixas(valorDespesasFixas);
			dto.setMes(DateUtil.getMes(inicio));
			dto.setAno(DateUtil.getAno(fim));
			list.add(dto);
			inicio = DateUtil.adicionarMeses(inicio, 1);
		}
		
		return list;
	}

	@Override
	public List<RelatorioRendimentoGastosDTO> pesquisarDadosRelatorioRendimentosGastos() {
		Date inicio = DateUtil.getPrimeiroDiaMes(DateUtil.subtrairMeses(new Date(), 6));
		
		List<RelatorioRendimentoGastosDTO> list = new ArrayList<RelatorioRendimentoGastosDTO>();
		Double valorDespesasFixas = NumberUtil.zeroIfNull(despesaDAO.pesquisarSomatorioDespesasFixas());
		Double rendimentos = NumberUtil.zeroIfNull(rendimentoDAO.pesquisarRendimentosPorMes());
		for (int i = 0; i < 13; i++) {
			Date fim = DateUtil.getUltimoDiaMes(inicio);
			RelatorioRendimentoGastosDTO dto = new RelatorioRendimentoGastosDTO();
			Double valorVariavelMensal = NumberUtil.zeroIfNull(despesaDAO.pesquisarValorTotalDespesasVariaveisPeriodo(inicio, fim));
			dto.setDespesas(valorVariavelMensal + valorDespesasFixas);
			dto.setRendimentos(rendimentos);
			dto.setMes(DateUtil.getMes(inicio));
			dto.setAno(DateUtil.getAno(inicio));
			list.add(dto);
			inicio = DateUtil.adicionarMeses(inicio, 1);
		}
		return list;
	}
	
}
