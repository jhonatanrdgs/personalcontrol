package br.com.jhonatan.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.jhonatan.dto.FormRelatorioDTO;
import br.com.jhonatan.util.DateUtil;

@Controller
@Scope("request")
public class RelatorioPDFController {
	
	private final String PAGE = "/relatorios/relatorioPDF";
	
	@RequestMapping(value="/relatorioPDF")
	public String iniciar(ModelMap map) {
		map.addAttribute("meses", DateUtil.getMeses());
		map.addAttribute("anos", DateUtil.get5AnosAtras5anosAFrente());
		map.addAttribute("relatorioForm", new FormRelatorioDTO());
		return PAGE;
	}
	
	@RequestMapping(value="/relatorioPDF/imprimir")
	public String gerar(@ModelAttribute("relatorioForm") FormRelatorioDTO relatorioForm) {
		System.out.println(relatorioForm);
		//TODO trazer os dados, e no relatório agrupar por categoria (colocar o total de cada categoria)
		//TODO colocar o número da parcela na frente do nome do gasto. Ex.: Tenis (1/12)
		return PAGE;
	}
	
}
