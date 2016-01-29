package br.com.jhonatan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.jhonatan.entidades.MetodoPagamento;
import br.com.jhonatan.service.CadastrosGeraisService;
import br.com.jhonatan.util.MensagemUtil;

@Controller
@Scope("request")
public class MetodoPagamentoController extends CrudController<MetodoPagamento> {
	
	private static final long serialVersionUID = 1L;
	private static final String LIST_PAGE = "metodoPagamento/listMetodoPagamento";
	private static final String EDIT_PAGE = "metodoPagamento/editMetodoPagamento";
	
	@Autowired
	private CadastrosGeraisService cadastrosGeraisService;

	@RequestMapping(value="/metodoPagamento/listMetodosPagamento")
	public String list(ModelMap map) {
		MetodoPagamento metodoPg = new MetodoPagamento();
		map.addAttribute("metodoPagamentoForm", metodoPg);
		return LIST_PAGE;
	}
	
	@RequestMapping(value="/metodoPagamento/search")
	public String search(@ModelAttribute("metodoPagamentoForm") MetodoPagamento metodoPagamento, ModelMap map) {
		List<MetodoPagamento> metodosPagamento = cadastrosGeraisService.pesquisarMetodosPagamento(metodoPagamento.getDescricao(), metodoPagamento.isAtivo());
		map.addAttribute("resultado", metodosPagamento);
		if (metodosPagamento.isEmpty()) {
			MensagemUtil.adicionaMensagemAlerta(map, "Nenhum registro Encontrado");
		}
		return LIST_PAGE; 
	}
	
	@RequestMapping(value="/metodoPagamento/newMetodoPagamento")
	public String create(ModelMap map) {
		MetodoPagamento metodoPg = new MetodoPagamento();
		map.addAttribute("metodoPagamentoForm", metodoPg);
		return EDIT_PAGE;
	}
	
	@RequestMapping(value="/metodoPagamento/save")
	public String save(@ModelAttribute("metodoPagamentoForm") MetodoPagamento metodoPagamento, ModelMap map) {
		cadastrosGeraisService.salvarOuAtualizarMetodoPagamento(metodoPagamento);
		MensagemUtil.adicionaMensagemSucesso(map, "Registro inserido/Atualizado com sucesso!");
		return LIST_PAGE; 
	}
	
	@RequestMapping(value="/metodoPagamento/edit", method=RequestMethod.GET)
	public String prepareEdit(@RequestParam("metodoPagamentoId") Long id, ModelMap map) {
		MetodoPagamento metodoPg = cadastrosGeraisService.findById(id);
		map.addAttribute("metodoPagamentoForm", metodoPg);
		return EDIT_PAGE;
	}
	
	@RequestMapping(value="/metodoPagamento/delete")
	public String remove(@RequestParam("metodoPagamentoId") Long id, ModelMap map) {
		cadastrosGeraisService.excluirMetodoPagamento(id);
		MensagemUtil.adicionaMensagemSucesso(map, "Registro Inativado com sucesso!");
		map.addAttribute("metodoPagamentoForm", new MetodoPagamento());
		return LIST_PAGE;
	}
	
	@RequestMapping(value="/metodoPagamento/ativar")
	public String ativar(@RequestParam("metodoPagamentoId") Long id, ModelMap map) {
		cadastrosGeraisService.ativarMetodoPagamento(id);
		MensagemUtil.adicionaMensagemSucesso(map, "Registro Ativado com sucesso!");
		map.addAttribute("metodoPagamentoForm", new MetodoPagamento());
		return LIST_PAGE;
	}
	
}
