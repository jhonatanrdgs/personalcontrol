package br.com.jhonatan.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.jhonatan.dto.RelatorioComprasParceladasDTO;
import br.com.jhonatan.dto.RelatorioDespesaPorCategoriaDTO;
import br.com.jhonatan.dto.RelatorioGastosFixosDTO;
import br.com.jhonatan.dto.RelatorioGastosPorMetodoPagamentoDTO;
import br.com.jhonatan.dto.RelatorioGastosVariaveisDTO;
import br.com.jhonatan.dto.RelatorioRendimentoGastosDTO;
import br.com.jhonatan.dto.RelatorioTotalGastosMensaisDTO;
import br.com.jhonatan.service.RelatorioService;
import br.com.jhonatan.util.DateUtil;

@Controller
public class RelatorioController {
	
	//TODO mensagem de nenhum dado encontrado está aparecendo duplicada na tela, por causa das várias chamadas js
	//TODO colocar o relatorio de despesa total (do mês atual) na home
	
	@Autowired
	private RelatorioService relatorioService;
	
	@RequestMapping(value="/relatorios/iniciar")
	public String init(ModelMap map) {
		Date inicio = DateUtil.getPrimeiroDiaMes(new Date());
		Date fim = DateUtil.getUltimoDiaMes(new Date());

		map.addAttribute("inicio",inicio);
		map.addAttribute("fim", fim);
		return "/relatorios/relatorios";
	}
	
	@RequestMapping(value="/relatorios/resumo", headers="Accept=application/json")
	public @ResponseBody Double[] montarResumoJson(@RequestParam(value="inicio") Date inicio, @RequestParam(value="fim") Date fim) {
		return relatorioService.pesquisarResumo(inicio, fim);
	}
	
	
	@RequestMapping(value="/relatorios/graficoPizza", headers="Accept=application/json")
	public @ResponseBody List<RelatorioDespesaPorCategoriaDTO> montarDadosGraficoPizzaJson(
			@RequestParam(value="inicio") Date inicio, @RequestParam(value="fim") Date fim) {
		return relatorioService.pesquisarDadosRelatorioDespesasPorCategoriasAtivas(inicio, fim);
	}
	
	
	@RequestMapping(value="/relatorios/comprasParceladas", headers="Accept=application/json")
	public @ResponseBody List<RelatorioComprasParceladasDTO> montarDadosComprasParceladasJson(
			@RequestParam(value="inicio") Date inicio, @RequestParam(value="fim") Date fim) {
		return relatorioService.pesquisarDadosRelatorioComprasParceladas(inicio, fim);
	}
	
	
	@RequestMapping(value="/relatorios/gastosPorMetodoPagamento", headers="Accept=application/json")
	public @ResponseBody List<RelatorioGastosPorMetodoPagamentoDTO> montarDadosGastosPorMetodoPagamentoJson(
			@RequestParam(value="inicio") Date inicio, @RequestParam(value="fim") Date fim) {
		return relatorioService.pesquisarDadosRelatorioGastosPorMetodoPagamento(inicio, fim);
	}
	
	
	@RequestMapping(value="/relatorios/gastosVariaveis", headers="Accept=application/json")
	public @ResponseBody List<RelatorioGastosVariaveisDTO> montarDadosGastosVariaveisJson(
			@RequestParam(value="inicio") Date inicio, @RequestParam(value="fim") Date fim) {
		return relatorioService.pesquisarDadosRelatorioGastosVariaveis(inicio, fim);
	}
	
	
	@RequestMapping(value="/relatorios/gastosFixos", headers="Accept=application/json")
	public @ResponseBody List<RelatorioGastosFixosDTO> montarDadosGastosFixosJson() {
		return relatorioService.pesquisarDadosRelatorioGastosFixos();
	}
	
	
	@RequestMapping(value="/relatorios/gastosPorMes", headers="Accept=application/json")
	public @ResponseBody List<RelatorioTotalGastosMensaisDTO> montarDadosGastosMensaisJson() {
		return relatorioService.pesquisarDadosRelatorioGastosMensais();
	}
	
	
	@RequestMapping(value="/relatorios/rendimentosGastos", headers="Accept=application/json")
	public @ResponseBody List<RelatorioRendimentoGastosDTO> montarDadosRendimentosGastosJson() {
		return relatorioService.pesquisarDadosRelatorioRendimentosGastos();
	}

}
