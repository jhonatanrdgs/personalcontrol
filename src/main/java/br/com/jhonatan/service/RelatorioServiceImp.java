package br.com.jhonatan.service;

import java.util.Collections;
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
		Double totalGastosVariaveisPeriodo = NumberUtil.normalizarDouble(despesaDAO.pesquisarTotalGastosVariaveisPeriodo(inicio, fim), 2);
		Double totalGastosFixos = NumberUtil.normalizarDouble(despesaDAO.pesquisarSomatorioDespesasFixas(), 2);
		Double totalGastos  = (totalGastosVariaveisPeriodo != null ? totalGastosVariaveisPeriodo : 0D) + (totalGastosFixos != null ? totalGastosFixos : 0D);
		totalGastos = NumberUtil.normalizarDouble(totalGastos, 2);
		return new Double[] {totalGastos, totalGastosVariaveisPeriodo, totalGastosFixos};
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
		//TODO verificar, pois se eu não trazer a primeira lista, ele não traz a segunda..
				//a questão é se tiver dados somente em uma lista.
		
		Date seisMesesAtras = DateUtil.getPrimeiroDiaMes(DateUtil.subtrairMeses(new Date(), 6));
		Date seisMesesAFrente = DateUtil.getPrimeiroDiaMes(DateUtil.adicionarMeses(new Date(), 6));
		
		List<RelatorioTotalGastosMensaisDTO> list = despesaDAO.pesquisarValorDespesasPorMes(seisMesesAtras, seisMesesAFrente);
		for (RelatorioTotalGastosMensaisDTO dto : list) {
			dto.setValorDespesasFixas(despesaDAO.pesquisarSomatorioDespesasFixas());
		}
		Collections.sort(list);
		return list;
	}

	@Override
	public List<RelatorioRendimentoGastosDTO> pesquisarDadosRelatorioRendimentosGastos() {
		//TODO verificar, pois se eu não trazer a primeira lista, ele não traz a segunda.. 
				//a questão é se tiver dados somente em uma lista.
		
		Date seisMesesAtras = DateUtil.getPrimeiroDiaMes(DateUtil.subtrairMeses(new Date(), 6));
		Date seisMesesAFrente = DateUtil.getPrimeiroDiaMes(DateUtil.adicionarMeses(new Date(), 6));
		
		List<RelatorioRendimentoGastosDTO> list = despesaDAO.pesquisarValorDespesasPorMesRelatorioRendimentos(seisMesesAtras, seisMesesAFrente);
		Double totalDespesasFixas = despesaDAO.pesquisarSomatorioDespesasFixas();
		if (totalDespesasFixas == null) {
			totalDespesasFixas = 0D;
		}
		for (RelatorioRendimentoGastosDTO dto : list) {
			dto.setDespesas(dto.getDespesas() != null ? dto.getDespesas() + totalDespesasFixas : 0D + totalDespesasFixas);
			dto.setRendimentos(rendimentoDAO.pesquisarRendimentosPorMes());
		}
		Collections.sort(list);
		return list;
	}
	
}
