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
import br.com.jhonatan.dto.RelatorioGastosVariaveisDTO;
import br.com.jhonatan.dto.RelatorioRendimentoGastosDTO;
import br.com.jhonatan.dto.RelatorioTotalGastosMensaisDTO;
import br.com.jhonatan.util.DateUtil;
import br.com.jhonatan.util.NumberUtil;

@Service
public class RelatorioServiceImp implements RelatorioService {
	
	//TODO revisar todas as queries
	
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
		Double totalGastosVariaveisPeriodo = despesaDAO.pesquisarValorDespesasPorMes(inicio, fim);
		totalGastosVariaveisPeriodo = NumberUtil.zeroIfNull(totalGastosVariaveisPeriodo);
		totalGastosVariaveisPeriodo = NumberUtil.normalizarDouble(totalGastosVariaveisPeriodo, 2);
		
		Double totalGastosFixos = despesaDAO.pesquisarSomatorioDespesasFixas();
		totalGastosFixos = NumberUtil.zeroIfNull(totalGastosFixos);
		totalGastosFixos = NumberUtil.normalizarDouble(totalGastosFixos, 2);
		
		Double totalGastos  = totalGastosVariaveisPeriodo + totalGastosFixos;
		totalGastos = NumberUtil.normalizarDouble(totalGastos, 2);
		
		Double rendimentos = rendimentoDAO.pesquisarRendimentosPorMes();
		Double percentualComprometido = null;
		if (rendimentos != null) {
			percentualComprometido = (totalGastos / rendimentos) * 100;
		} else {
			percentualComprometido = 0D;
		}
		percentualComprometido = NumberUtil.normalizarDouble(percentualComprometido, 2);
		
		return new Double[] {totalGastos, totalGastosVariaveisPeriodo, totalGastosFixos, percentualComprometido};
	}

	@Override
	public List<RelatorioDespesaPorCategoriaDTO> pesquisarDadosRelatorioDespesasPorCategoriasAtivas(Date inicio, Date fim) {
		return categoriaDAO.pesquisarDespesasPorCategoriasAtivas(inicio, fim);
	}

	@Override
	public List<RelatorioComprasParceladasDTO> pesquisarDadosRelatorioComprasParceladas(Date inicio, Date fim) {
		return despesaDAO.pesquisarDespesasParceladasPeriodo(inicio, fim);
	}

	@Override
	public List<RelatorioGastosPorMetodoPagamentoDTO> pesquisarDadosRelatorioGastosPorMetodoPagamento(Date inicio, Date fim) {
		return metodoPagamentoDAO.pesquisarDespesasPorMetodoPagamentoAtivo(inicio, fim);
	}
	
	@Override
	public List<RelatorioGastosVariaveisDTO> pesquisarDadosRelatorioGastosVariaveis(Date inicio, Date fim) {
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
			Double valorVariavelMensal = NumberUtil.zeroIfNull(despesaDAO.pesquisarValorDespesasPorMes(inicio, fim));
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
			Double valorVariavelMensal = NumberUtil.zeroIfNull(despesaDAO.pesquisarValorDespesasPorMes(inicio, fim));
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
