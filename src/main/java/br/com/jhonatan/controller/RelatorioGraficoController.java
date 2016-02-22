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
import br.com.jhonatan.dto.RelatorioPercentualComprometido12MesesDTO;
import br.com.jhonatan.dto.RelatorioRendimentoGastosDTO;
import br.com.jhonatan.dto.RelatorioResumoDTO;
import br.com.jhonatan.service.RelatorioService;
import br.com.jhonatan.util.Constantes;
import br.com.jhonatan.util.DateUtil;

@Controller
@Scope("request")
public class RelatorioGraficoController {
	
	@Autowired
	private RelatorioService relatorioService;
	
	@RequestMapping(value="/relatorios/iniciar")
	public String init(final ModelMap map) {
		map.addAttribute(Constantes.MESES, DateUtil.getMeses());
		map.addAttribute(Constantes.ANOS, DateUtil.get5AnosAtras5anosAFrente());
		map.addAttribute("mesAtual", DateUtil.getMes(new Date()));
		map.addAttribute("anoAtual", DateUtil.getAno(new Date()));
		return "/relatorios/relatorios";
	}
	
	@RequestMapping(value="/relatorios/resumo", headers=Constantes.ACCEPT_JSON)
	public @ResponseBody RelatorioResumoDTO montarResumoJson(@RequestParam(value=Constantes.MES) final int mes, 
			@RequestParam(value=Constantes.ANO) final int ano) {
		return relatorioService.pesquisarResumo(mes, ano);
	}
	
	@RequestMapping(value="/relatorios/graficoPizza", headers=Constantes.ACCEPT_JSON)
	public @ResponseBody List<RelatorioDespesaPorCategoriaDTO> montarDadosGraficoPizzaJson(
			@RequestParam(value=Constantes.MES) final int mes, @RequestParam(value=Constantes.ANO) final int ano) {
		return relatorioService.pesquisarDadosRelatorioDespesasPorCategoriasAtivas(mes, ano);
	}
	
	@RequestMapping(value="/relatorios/comprasParceladas", headers=Constantes.ACCEPT_JSON)
	public @ResponseBody List<RelatorioComprasParceladasDTO> montarDadosComprasParceladasJson(
			@RequestParam(value=Constantes.MES) final int mes, @RequestParam(value=Constantes.ANO) final int ano) {
		return relatorioService.pesquisarDadosRelatorioComprasParceladas(mes, ano);
	}
	
	@RequestMapping(value="/relatorios/gastosPorMetodoPagamento", headers=Constantes.ACCEPT_JSON)
	public @ResponseBody List<RelatorioGastosPorMetodoPagamentoDTO> montarDadosGastosPorMetodoPagamentoJson(
			@RequestParam(value=Constantes.MES) final int mes, @RequestParam(value=Constantes.ANO) final int ano) {
		return relatorioService.pesquisarDadosRelatorioGastosPorMetodoPagamento(mes, ano);
	}
	
	@RequestMapping(value="/relatorios/gastosVariaveis", headers=Constantes.ACCEPT_JSON)
	public @ResponseBody List<RelatorioComprasNaoParceladasDTO> montarDadosGastosVariaveisJson(
			@RequestParam(value=Constantes.MES) final int mes, @RequestParam(value=Constantes.ANO) final int ano) {
		return relatorioService.pesquisarDadosRelatorioGastosVariaveis(mes, ano);
	}
	
	@RequestMapping(value="/relatorios/gastosFixos", headers=Constantes.ACCEPT_JSON)
	public @ResponseBody List<RelatorioGastosFixosDTO> montarDadosGastosFixosJson() {
		return relatorioService.pesquisarDadosRelatorioGastosFixos();
	}
	
	@RequestMapping(value="/relatorios/rendimentosGastos", headers=Constantes.ACCEPT_JSON)
	public @ResponseBody List<RelatorioRendimentoGastosDTO> montarDadosRendimentosGastosJson() {
		return relatorioService.pesquisarDadosRelatorioRendimentosGastos();
	}
	
	@RequestMapping(value="/relatorios/percentual12Meses", headers=Constantes.ACCEPT_JSON)
	public @ResponseBody List<RelatorioPercentualComprometido12MesesDTO> montarDadosPercentualComprometido12MesesJson() {
		return relatorioService.montarRelatorioPercentualComprometido12Meses();
	}
	
	
}
