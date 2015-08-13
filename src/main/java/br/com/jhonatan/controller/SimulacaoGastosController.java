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

import br.com.jhonatan.dto.RelatorioBarraSimuladorRendimentoGastoDTO;
import br.com.jhonatan.dto.RelatorioLinhaSimuladorRendimentoGastoDTO;
import br.com.jhonatan.entidades.Despesa;
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
	
	private List<RelatorioLinhaSimuladorRendimentoGastoDTO> dadosLinha;
	
	private List<RelatorioBarraSimuladorRendimentoGastoDTO> dadosBarra;
	
	@RequestMapping(value="/simulacao/iniciar")
	public String iniciar(ModelMap map) {
		dadosLinha = null;
		dadosBarra = null;
		Despesa despesa = new Despesa();
		despesa.setData(new Date());
		despesa.setDescricao("Despesa Simulada");
		despesa.setTotalParcelas(1);
		map.addAttribute("simuladorForm", despesa);
		return PAGE;
	}
	
	@RequestMapping(value="/simulacao/simular")
	public String simular(@ModelAttribute("simuladorForm") Despesa despesa, ModelMap map) {
		if (despesa != null && despesa.getData() != null && despesa.getValorTotal() != null) {
			dadosLinha = relatorioService.montarRelatorioLinhaSimulacaoGastos(despesa);
			dadosBarra = relatorioService.montarRelatorioBarraSimulacaoGastos(despesa);
		}
		return PAGE;
	}
	
	@RequestMapping(value="/simulacao/getDadosRelatorioLinha", headers="Accept=application/json")
	public @ResponseBody List<RelatorioLinhaSimuladorRendimentoGastoDTO> getDadosRelatorioLinhaSimulacao() {
		return dadosLinha;
	}
	
	@RequestMapping(value="/simulacao/getDadosRelatorioBarra", headers="Accept=application/json")
	public @ResponseBody List<RelatorioBarraSimuladorRendimentoGastoDTO> getDadosRelatorioBarraSimulacao() {
		return dadosBarra;
	}
}
