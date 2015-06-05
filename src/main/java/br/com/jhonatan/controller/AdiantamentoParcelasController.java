package br.com.jhonatan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.jhonatan.service.DespesaService;

@Controller
@Scope("request")
public class AdiantamentoParcelasController {
	
	private final String LIST_PAGE = "/despesa/listAdiantamento";
	//private final String EDIT_PAGE = "/despesa/editAdiantamento";
	
	@Autowired
	private DespesaService despesaService;
	
	@RequestMapping(value="/despesa/listAdiantamento")
	public String iniciar(ModelMap map) {
		//List<Despesa> despesasParceladas = despesaService.pesquisarDespesasParceladas();
		//map.addAttribute("comprasParceladas", despesasParceladas);
		return LIST_PAGE;
	}
	
	@RequestMapping(value="/despesa/searchAdiantamento")
	public String pesquisar(ModelMap map) {
		
		//TODO form para isso
		return LIST_PAGE;
	}
	
	@RequestMapping(value="/despesa/realizarAdiantamento")
	public String realizarAdiantamento(@RequestParam("idParcela") Long idParcela, ModelMap map) {
		return LIST_PAGE;
	}
	
	//TODO na tela terá uma seleção de compras parcelas
	//Assim que clicar no buscar ele tras todas as parcelas daquela compra
	//vai ter um botão na tabela de resultados que o botão "Marcar como paga" (ou algo parecido)
	//que irá marcar a parcela como paga (ela não deverá aparecer mais nas despesas)
	
	//Nos relatórios, no PDF anual (ainda a criar) tem que aparecer as pagas e as não pagas..
	//Nos relatórios da página inicial (gastos por mês e Rendimento x Gastos) tem que somar as pagas e as não pagas
	//Somente nos relatórios do menu relatórios que muda essa informação.
	
	//TODO criar job que seta todas as compras parceladas do mes passado como pagas
	

}
