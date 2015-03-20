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
	
	//TODO criar uma service por conjunto de negócio ou por menu
	//TODO criar entidade genérica
	
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
	
	//TODO colocar no inicio da tela
	//- total gasto no mês
	//- total de despesas fixas
	//- total de despesas variáveis
	//- relatórios
	
	@RequestMapping(value="/relatorios/graficoPizza", headers="Accept=application/json")
	public @ResponseBody List<RelatorioDespesaPorCategoriaDTO> montarDadosGraficoPizzaJson(
			@RequestParam(value="inicio") Date inicio, @RequestParam(value="fim") Date fim) {
		return relatorioService.pesquisarDadosRelatorioDespesasPorCategoriasAtivas(inicio, fim);
	}
	
	//TODO relatorio de compras parceladas (tem filtro de data)
	@RequestMapping(value="/relatorios/comprasParceladas", headers="Accept=application/json")
	public @ResponseBody List<RelatorioComprasParceladasDTO> montarDadosComprasParceladasJson(
			@RequestParam(value="inicio") Date inicio, @RequestParam(value="fim") Date fim) {
		return relatorioService.pesquisarDadosRelatorioComprasParceladas(inicio, fim);
	}
	
	//TODO gastos por metodo de pagamento (tem filtro de data)
	@RequestMapping(value="/relatorios/gastosPorMetodoPagamento", headers="Accept=application/json")
	public @ResponseBody List<RelatorioGastosPorMetodoPagamentoDTO> montarDadosGastosPorMetodoPagamentoJson(
			@RequestParam(value="inicio") Date inicio, @RequestParam(value="fim") Date fim) {
		return relatorioService.pesquisarDadosRelatorioGastosPorMetodoPagamento(inicio, fim);
	}
	
	//TODO gastos variáveis (com filtro de data)
	@RequestMapping(value="/relatorios/gastosVariaveis", headers="Accept=application/json")
	public @ResponseBody List<RelatorioGastosVariaveisDTO> montarDadosGastosVariaveisJson(
			@RequestParam(value="inicio") Date inicio, @RequestParam(value="fim") Date fim) {
		return relatorioService.pesquisarDadosRelatorioGastosVariaveis(inicio, fim);
	}
	
	//TODO gastos fixos (sem filtro de data)
	@RequestMapping(value="/relatorios/gastosFixos", headers="Accept=application/json")
	public @ResponseBody List<RelatorioGastosFixosDTO> montarDadosGastosFixosJson() {
		return relatorioService.pesquisarDadosRelatorioGastosFixos();
	}
	
	
	//TODO gastos(total) por mês (sem filtro de data, gráfico de linha)
	@RequestMapping(value="/relatorios/gastosPorMes", headers="Accept=application/json")
	public @ResponseBody List<RelatorioTotalGastosMensaisDTO> montarDadosGastosMensaisJson() {
		return relatorioService.pesquisarDadosRelatorioGastosMensais();
	}
	
	//TODO rendimentos x gastos (sem filtro de data, mostrar por uma quantidade de meses, padrão 12)
	@RequestMapping(value="/relatorios/rendimentosGastos", headers="Accept=application/json")
	public @ResponseBody List<RelatorioRendimentoGastosDTO> montarDadosRendimentosGastosJson() {
		return relatorioService.pesquisarDadosRelatorioRendimentosGastos();//TODO não foi criado na service ainda
	}

}
