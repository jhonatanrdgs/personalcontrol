package br.com.jhonatan.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.jhonatan.dto.RelatorioDespesaPorCategoriaDTO;
import br.com.jhonatan.service.CategoriaService;
import br.com.jhonatan.util.DateUtil;

@Controller
public class RelatorioController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping(value="/relatorios/iniciar")
	public String init(ModelMap map) {
		Date inicio = DateUtil.getPrimeiroDiaMes(new Date());
		Date fim = DateUtil.getUltimoDiaMes(new Date());

		map.addAttribute("inicio",inicio);
		map.addAttribute("fim", fim);
		return "/relatorios/relatorios";
	}
	
	@RequestMapping(value="/relatorios/graficoPizza", headers="Accept=application/json")
	public @ResponseBody List<RelatorioDespesaPorCategoriaDTO> montarDadosGraficoPizzaJson(
			@RequestParam(value="inicio") Date inicio, @RequestParam(value="fim") Date fim) {
		List<RelatorioDespesaPorCategoriaDTO> resultado = categoriaService.pesquisarDespesasPorCategoriasAtivas(inicio, fim);
		return resultado;
	}
	
	//TODO gastos por mês
	//TODO relatorio de compras parceladas
	//TODO gastos fixos
	//TODO total gasto por mês (grafico de linha)
	//TODO rendimentos x gastos
	//TODO gastos por metodo de pagamento
	
	//TODO todos os relatórios, com exceção do gastos por mês devem ter filtro de datas, sendo que a data na hora de abrir a tela deve ser o mês atual
	

}
