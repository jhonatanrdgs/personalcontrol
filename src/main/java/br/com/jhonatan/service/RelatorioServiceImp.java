package br.com.jhonatan.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jhonatan.dao.CategoriaDAO;
import br.com.jhonatan.dao.DespesaCarroDAO;
import br.com.jhonatan.dao.DespesaDAO;
import br.com.jhonatan.dao.MetodoPagamentoDAO;
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
import br.com.jhonatan.entidades.Despesa;
import br.com.jhonatan.entidades.DespesaCarro;
import br.com.jhonatan.entidades.ItemDespesaCarro;
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
	
	@Autowired
	private DespesaCarroDAO despesaCarroDAO;
	
	@Override
	public Double[] pesquisarResumo(int mes, int ano) {
		Double totalGastosVariaveisPeriodo = NumberUtil.zeroIfNull(despesaDAO.pesquisarValorTotalDespesasVariaveisMes(mes, ano));
		totalGastosVariaveisPeriodo = NumberUtil.normalizarDouble(totalGastosVariaveisPeriodo, 2);
		
		Double totalGastosFixos = NumberUtil.zeroIfNull(despesaDAO.pesquisarSomatorioDespesasFixas());
		totalGastosFixos = NumberUtil.normalizarDouble(totalGastosFixos, 2);
		
		Double totalGastos  = totalGastosVariaveisPeriodo + totalGastosFixos;
		totalGastos = NumberUtil.normalizarDouble(totalGastos, 2);
		
		Date data = DateUtil.getPrimeiroDiaMes(mes - 1, ano);
		Double rendimentos = NumberUtil.zeroIfNull(rendimentoDAO.pesquisarRendimentosPorMes(data));
		Double percentualComprometido = (totalGastos / rendimentos) * 100;
		percentualComprometido = NumberUtil.normalizarDouble(percentualComprometido, 2);
		
		Double sobra = NumberUtil.normalizarDouble(rendimentos - totalGastos, 2);
		
		return new Double[] {totalGastos, totalGastosVariaveisPeriodo, totalGastosFixos, percentualComprometido, rendimentos, sobra};
	}

	@Override
	public List<RelatorioDespesaPorCategoriaDTO> pesquisarDadosRelatorioDespesasPorCategoriasAtivas(int mes, int ano) {
		return categoriaDAO.pesquisarDespesasPorCategoriasAtivas(mes, ano);
	}

	@Override
	public List<RelatorioGastosPorMetodoPagamentoDTO> pesquisarDadosRelatorioGastosPorMetodoPagamento(int mes, int ano) {
		List<RelatorioGastosPorMetodoPagamentoDTO> lista = metodoPagamentoDAO.pesquisarDespesasPorMetodoPagamentoAtivo(mes, ano);
		for (RelatorioGastosPorMetodoPagamentoDTO dto : lista) {
			dto.setValor(dto.getValor() + NumberUtil.zeroIfNull(despesaDAO.pesquisarDespessasFixasPorMetodoPagamento(dto.getIdMetodoPagamento())));
		}
		return lista;
	}
	
	@Override
	public List<RelatorioComprasParceladasDTO> pesquisarDadosRelatorioComprasParceladas(int mes, int ano) {
		return despesaDAO.pesquisarDespesasParceladasMes(mes, ano);
	}
	
	@Override
	public List<RelatorioComprasNaoParceladasDTO> pesquisarDadosRelatorioGastosVariaveis(int mes, int ano) {
		return despesaDAO.pesquisarDespesasVariaveisMes(mes, ano);
	}

	@Override
	public List<RelatorioGastosFixosDTO> pesquisarDadosRelatorioGastosFixos() {
		return despesaDAO.pesquisarDespesasFixas();
	}

	@Override
	public List<RelatorioRendimentoGastosDTO> pesquisarDadosRelatorioRendimentosGastos() {
		Date inicio = DateUtil.getPrimeiroDiaMes(DateUtil.subtrairMeses(new Date(), 6));
		
		List<RelatorioRendimentoGastosDTO> list = new ArrayList<RelatorioRendimentoGastosDTO>();
		Double valorDespesasFixas = NumberUtil.zeroIfNull(despesaDAO.pesquisarSomatorioDespesasFixas());
		for (int i = 0; i <= 12; i++) {
			Double rendimentos = NumberUtil.zeroIfNull(rendimentoDAO.pesquisarRendimentosPorMes(inicio));
			int mes = DateUtil.getMes(inicio);
			int ano = DateUtil.getAno(inicio);
			
			RelatorioRendimentoGastosDTO dto = new RelatorioRendimentoGastosDTO();
			Double valorVariavelMensal = NumberUtil.zeroIfNull(despesaDAO.pesquisarValorTotalDespesasVariaveisMes(mes, ano));
			dto.setDespesas(valorVariavelMensal + valorDespesasFixas);
			dto.setRendimentos(rendimentos);
			dto.setMes(mes);
			dto.setAno(ano);
			list.add(dto);
			inicio = DateUtil.adicionarMeses(inicio, 1);
		}
		return list;
	}

	@Override
	public List<RelatorioGastosMensaisPdfDTO> pesquisarDadosRelatorioGastosMensaisPDF(FormRelatorioDTO relatorioForm) {
		Date inicio = DateUtil.getPrimeiroDiaMes(relatorioForm.getMes(), relatorioForm.getAno());
		Date fim = DateUtil.getUltimoDiaMes(relatorioForm.getMes(), relatorioForm.getAno());
		return despesaDAO.pesquisarDespesasPeriodoRelatorioPDF(inicio, fim);
	}

	@Override
	public List<RelatorioDespesaCarroPdfDTO> pesquisarDadosRelatorioDespesaCarro() {
		List<DespesaCarro> list = despesaCarroDAO.pesquisarDespesasCarroPeriodo(); 
		List<RelatorioDespesaCarroPdfDTO> dtos = new ArrayList<RelatorioDespesaCarroPdfDTO>();
		for (DespesaCarro dc : list) {
			RelatorioDespesaCarroPdfDTO dto = new RelatorioDespesaCarroPdfDTO(dc.getKm(), dc.getData());
			for (ItemDespesaCarro idc : dc.getItemDespesaCarros()) {
				ItemDespesaCarroDTO idcDTO = new ItemDespesaCarroDTO(idc.getDescricao(), idc.getValorItem());
				dto.getItensDespesaCarro().add(idcDTO);
			}
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public List<RelatorioLinhaSimuladorRendimentoGastoDTO> montarRelatorioLinhaSimulacaoGastos(Despesa despesa) {
		Date inicio = DateUtil.getPrimeiroDiaMes(despesa.getData());
		
		List<RelatorioLinhaSimuladorRendimentoGastoDTO> list = new ArrayList<RelatorioLinhaSimuladorRendimentoGastoDTO>();
		Double valorDespesasFixas = NumberUtil.zeroIfNull(despesaDAO.pesquisarSomatorioDespesasFixas());
		
		Double valorParcelaDespesa = despesa.getValorTotal() / despesa.getTotalParcelas();
		
		for (int i = 0; i < despesa.getTotalParcelas(); i++) {
			Double rendimentos = NumberUtil.zeroIfNull(rendimentoDAO.pesquisarRendimentosPorMes(inicio));
			int mes = DateUtil.getMes(inicio);
			int ano = DateUtil.getAno(inicio);
			
			RelatorioLinhaSimuladorRendimentoGastoDTO dto = new RelatorioLinhaSimuladorRendimentoGastoDTO();
			Double valorVariavelMensal = NumberUtil.zeroIfNull(despesaDAO.pesquisarValorTotalDespesasVariaveisMes(mes, ano));
			dto.setDespesasNaoSimuladas(valorVariavelMensal + valorDespesasFixas);
			dto.setDespesasSimuladas(valorVariavelMensal + valorDespesasFixas + valorParcelaDespesa);
			dto.setRendimentos(rendimentos);
			dto.setMes(mes);
			dto.setAno(ano);
			list.add(dto);
			inicio = DateUtil.adicionarMeses(inicio, 1);
		}
		return list;
	}

	@Override
	public List<RelatorioBarraSimuladorRendimentoGastoDTO> montarRelatorioBarraSimulacaoGastos(Despesa despesa) {
		Date inicio = DateUtil.getPrimeiroDiaMes(despesa.getData());
		
		List<RelatorioBarraSimuladorRendimentoGastoDTO> list = new ArrayList<RelatorioBarraSimuladorRendimentoGastoDTO>();
		Double valorDespesasFixas = NumberUtil.zeroIfNull(despesaDAO.pesquisarSomatorioDespesasFixas());
		Double valorParcela = despesa.getValorTotal() / despesa.getTotalParcelas();
		
		for (int i = 0; i < despesa.getTotalParcelas(); i++) {
			Double rendimentos = NumberUtil.zeroIfNull(rendimentoDAO.pesquisarRendimentosPorMes(inicio));
			int mes = DateUtil.getMes(inicio);
			int ano = DateUtil.getAno(inicio);
			Double valorVariavelMensal = NumberUtil.zeroIfNull(despesaDAO.pesquisarValorTotalDespesasVariaveisMes(mes, ano));
			Double totalGastos = valorDespesasFixas + valorVariavelMensal;
			Double percentualSemSimulacao = (totalGastos / rendimentos) * 100;
			totalGastos += valorParcela;
			Double percentualComSimulacao = (totalGastos / rendimentos) * 100;
			RelatorioBarraSimuladorRendimentoGastoDTO dto = new RelatorioBarraSimuladorRendimentoGastoDTO();
			dto.setPercentualSemSimulacao(percentualSemSimulacao);
			dto.setPercentualComSimulacao(percentualComSimulacao);
			dto.setMes(mes);
			dto.setAno(ano);
			
			list.add(dto);
			
			inicio = DateUtil.adicionarMeses(inicio, 1);
		}
		return list;
	}

	@Override
	public List<RelatorioPercentualComprometido12MesesDTO> montarRelatorioPercentualComprometido12Meses() {
		Date inicio = DateUtil.getPrimeiroDiaMes(new Date());
		
		List<RelatorioPercentualComprometido12MesesDTO> list = new ArrayList<RelatorioPercentualComprometido12MesesDTO>();
		Double valorDespesasFixas = NumberUtil.zeroIfNull(despesaDAO.pesquisarSomatorioDespesasFixas());
		
		for (int i = 0; i < 12; i++) {
			int mes = DateUtil.getMes(inicio);
			int ano = DateUtil.getAno(inicio);
			Double rendimentos = NumberUtil.zeroIfNull(rendimentoDAO.pesquisarRendimentosPorMes(inicio));
			Double valorVariavelMensal = NumberUtil.zeroIfNull(despesaDAO.pesquisarValorTotalDespesasVariaveisMes(mes, ano));
			Double totalGastos = valorDespesasFixas + valorVariavelMensal;
			RelatorioPercentualComprometido12MesesDTO dto = new RelatorioPercentualComprometido12MesesDTO();
			
			dto.setAno(ano);
			dto.setMes(mes);
			dto.setPercentual((totalGastos / rendimentos) * 100);
			list.add(dto);
			
			inicio = DateUtil.adicionarMeses(inicio, 1);
		}
		
		return list;
	}
	
}
