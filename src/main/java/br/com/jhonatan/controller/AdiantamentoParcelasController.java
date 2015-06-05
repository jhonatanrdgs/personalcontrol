package br.com.jhonatan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.jhonatan.entidades.Despesa;
import br.com.jhonatan.service.DespesaService;

@Controller
@Scope("request")
public class AdiantamentoParcelasController {
	
	private final String LIST_PAGE = "/despesa/listAdiantamento";
	private final String EDIT_PAGE = "/despesa/editAdiantamento";
	
	@Autowired
	private DespesaService despesaService;
	
	@RequestMapping(value="/despesa/listAdiantamento")
	public String iniciar(ModelMap map) {
		List<Despesa> despesasParceladas = despesaService.pesquisarDespesasParceladas();
		map.addAttribute("comprasParceladas", despesasParceladas);
		return LIST_PAGE;
	}
	
	//TODO na tela terá uma seleção de compras parcelas
	//Assim que clicar no buscar ele tras todas as parcelas daquela compra
	//vai ter um botão na tabela de resultados que o botão "Marcar como paga" (ou algo parecido)
	//que irá marcar a parcela como paga (ela não deverá aparecer mais nas despesas)
	

}
