package br.com.jhonatan.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.jhonatan.dto.GraficoCategoriaDTO;

@Controller
public class RelatorioController {
	
	//TODO colocar período
	
	@RequestMapping(value="/relatorios/iniciar")
	public String init() {
		return "/relatorios/relatorios";
	}
	
	@RequestMapping(value="/relatorios/graficoPizza", headers="Accept=application/json")
	public @ResponseBody List<GraficoCategoriaDTO> montarDadosGraficoPizzaJson() {
		//TODO
		GraficoCategoriaDTO c = new GraficoCategoriaDTO();
		c.setCategoria("Categoria 1");
		c.setValorTotal(12.0);
		List<GraficoCategoriaDTO> resultado = new ArrayList<GraficoCategoriaDTO>();
		resultado.add(c);
		GraficoCategoriaDTO c2 = new GraficoCategoriaDTO();
		c2.setCategoria("Categoria 2");
		c2.setValorTotal(1015.3);
		resultado.add(c2);
		return resultado;
	}
	
	//TODO gastos por mês
	//TODO gastos fixos
	//TODO total gasto por mês (grafico de linha)
	//TODO rendimentos x gastos
	

}
