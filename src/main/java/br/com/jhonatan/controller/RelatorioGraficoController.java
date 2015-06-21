package br.com.jhonatan.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.jhonatan.dto.RelatorioComprasNaoParceladasDTO;
import br.com.jhonatan.dto.RelatorioComprasParceladasDTO;
import br.com.jhonatan.dto.RelatorioDespesaPorCategoriaDTO;
import br.com.jhonatan.dto.RelatorioGastosFixosDTO;
import br.com.jhonatan.dto.RelatorioGastosPorMetodoPagamentoDTO;
import br.com.jhonatan.dto.RelatorioRendimentoGastosDTO;
import br.com.jhonatan.dto.RelatorioTotalGastosMensaisDTO;
import br.com.jhonatan.service.RelatorioService;
import br.com.jhonatan.util.DateUtil;

@Controller
@Scope("request")
public class RelatorioGraficoController {
	
	@Autowired
	private RelatorioService relatorioService;
	
	@RequestMapping(value="/relatorios/iniciar")
	public String init(ModelMap map) {
		map.addAttribute("meses", DateUtil.getMeses());
		map.addAttribute("anos", DateUtil.get5AnosAtras5anosAFrente());
		map.addAttribute("mesAtual", DateUtil.getMes(new Date()));
		map.addAttribute("anoAtual", DateUtil.getAno(new Date()));
		return "/relatorios/relatorios";
	}
	
	@RequestMapping(value="/relatorios/resumo", headers="Accept=application/json")
	public @ResponseBody Double[] montarResumoJson(@RequestParam(value="mes") int mes, @RequestParam(value="ano") int ano) {
		return relatorioService.pesquisarResumo(mes, ano);
	}
	
	
	@RequestMapping(value="/relatorios/graficoPizza", headers="Accept=application/json")
	public @ResponseBody List<RelatorioDespesaPorCategoriaDTO> montarDadosGraficoPizzaJson(
			@RequestParam(value="mes") int mes, @RequestParam(value="ano") int ano) {
		return relatorioService.pesquisarDadosRelatorioDespesasPorCategoriasAtivas(mes, ano);
	}
	
	
	@RequestMapping(value="/relatorios/comprasParceladas", headers="Accept=application/json")
	public @ResponseBody List<RelatorioComprasParceladasDTO> montarDadosComprasParceladasJson(
			@RequestParam(value="mes") int mes, @RequestParam(value="ano") int ano) {
		return relatorioService.pesquisarDadosRelatorioComprasParceladas(mes, ano);
	}
	
	
	@RequestMapping(value="/relatorios/gastosPorMetodoPagamento", headers="Accept=application/json")
	public @ResponseBody List<RelatorioGastosPorMetodoPagamentoDTO> montarDadosGastosPorMetodoPagamentoJson(
			@RequestParam(value="mes") int mes, @RequestParam(value="ano") int ano) {
		return relatorioService.pesquisarDadosRelatorioGastosPorMetodoPagamento(mes, ano);
	}
	
	
	@RequestMapping(value="/relatorios/gastosVariaveis", headers="Accept=application/json")
	public @ResponseBody List<RelatorioComprasNaoParceladasDTO> montarDadosGastosVariaveisJson(
			@RequestParam(value="mes") int mes, @RequestParam(value="ano") int ano) {
		return relatorioService.pesquisarDadosRelatorioGastosVariaveis(mes, ano);
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
