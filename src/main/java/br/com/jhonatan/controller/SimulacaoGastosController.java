package br.com.jhonatan.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.jhonatan.dto.RelatorioSimuladorRendimentoGastoDTO;
import br.com.jhonatan.entidades.Categoria;
import br.com.jhonatan.entidades.Despesa;
import br.com.jhonatan.entidades.MetodoPagamento;
import br.com.jhonatan.service.CadastrosGeraisService;
import br.com.jhonatan.service.RelatorioService;

@Controller
@Scope("session")
public class SimulacaoGastosController {

	private static final String PAGE = "simulacao/simulador";
	
	@Autowired
	private CadastrosGeraisService cadastrosGeraisService;
	
	@Autowired
	private RelatorioService relatorioService;
	
	List<RelatorioSimuladorRendimentoGastoDTO> dados;
	
	@RequestMapping(value="/simulacao/iniciar")
	public String iniciar(ModelMap map) {
		dados = null;
		Despesa despesa = new Despesa();
		despesa.setData(new Date());
		despesa.setDescricao("Despesa Simulada");
		despesa.setTotalParcelas(1);
		map.addAttribute("simuladorForm", despesa);
		montarCombos(map);
		return PAGE;
	}
	
	@RequestMapping(value="/simulacao/simular")
	public String simular(@ModelAttribute("simuladorForm") Despesa despesa, ModelMap map) {
		//TODO colocar na tela um gráfico só, com 3 linhas (rendimentos, gastos sem simulação e gastos com simulação)
		dados = relatorioService.montarRelatorioSimulacaoGastos(despesa);
		return PAGE;
	}
	
	@RequestMapping(value="/simulacao/getDados", headers="Accept=application/json")
	public @ResponseBody List<RelatorioSimuladorRendimentoGastoDTO> getDadosSemSimulacao() {
		return dados;
	}
	
	private void montarCombos(ModelMap map) {
		List<Categoria> categorias = cadastrosGeraisService.pesquisarTodasCategoriasAtivas();
		List<MetodoPagamento> metodosPagamento = cadastrosGeraisService.pesquisarTodosMetodosPagamentoAtivos();
		map.addAttribute("categorias", categorias);
		map.addAttribute("metodosPagamento", metodosPagamento);
	}
}
