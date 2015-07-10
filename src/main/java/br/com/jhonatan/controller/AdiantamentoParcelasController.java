package br.com.jhonatan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.jhonatan.entidades.Despesa;
import br.com.jhonatan.service.DespesaService;
import br.com.jhonatan.util.MensagemUtil;

@Controller
@Scope("request")
public class AdiantamentoParcelasController {
	
	private final String LIST_PAGE = "adiantamento/listAdiantamentos";
	
	@Autowired
	private DespesaService despesaService;

	@RequestMapping(value="/adiantamento/iniciar")
	public String iniciar(ModelMap map) {
		montarParametrosIniciais(map, null);
		return LIST_PAGE;
	}

	@RequestMapping(value="/adiantamento/search")
	public String pesquisar(@ModelAttribute(value="despesaForm") Despesa despesa, ModelMap map) {
		montarParametrosIniciais(map, despesa.getId());
		map.addAttribute("resultado", despesaService.pesquisarParcelasDaDespesa(despesa.getId()));
		map.addAttribute("idDespesa", despesa.getId());
		return LIST_PAGE;
	}
	
	@RequestMapping(value="/adiantamento/adiantar")
	public String adiantarPagamentoParcela(@RequestParam(value="idParcela") Long idParcela, ModelMap map) {
		despesaService.adiantarPagamentoParcela(idParcela);
		montarParametrosIniciais(map, null);
		MensagemUtil.adicionaMensagemSucesso(map, "Parcela adiantada com sucesso!");
		return LIST_PAGE;
	}
	
	@RequestMapping(value="/adiantamento/adiantarTodas")
	public String adiantarPagamentoTodasParcelas(@RequestParam(value="idDespesa") Long idDespesa, ModelMap map) {
		despesaService.adiantarPagamentoTodasParcelas(idDespesa);
		montarParametrosIniciais(map, null);
		MensagemUtil.adicionaMensagemSucesso(map, "Todas as parcelas foram adiantadas com sucesso!");
		return LIST_PAGE;
	}
	
	private void montarParametrosIniciais(ModelMap map, Long idDespesa) {
		map.addAttribute("despesas", despesaService.pesquisarDespesasComParcelasProximoMesEmDiante());
		Despesa despesa = new Despesa();
		despesa.setId(idDespesa);
		map.addAttribute("despesaForm", despesa);
	}
	
}
