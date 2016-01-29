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

import br.com.jhonatan.entidades.Rendimento;
import br.com.jhonatan.service.CadastrosGeraisService;
import br.com.jhonatan.util.MensagemUtil;

@Controller
@Scope("request")
public class RendimentoController extends CrudController<Rendimento> {
	
	private static final long serialVersionUID = -9177011140448318596L;
	
	private static final String LIST_PAGE = "rendimento/listRendimento";
	private static final String EDIT_PAGE = "rendimento/editRendimento";
	
	@Autowired
	private CadastrosGeraisService cadastrosGeraisService;
	
	@RequestMapping(value="/rendimento/listRendimento")
	public String list(ModelMap map) {
		Rendimento rendimento = new Rendimento();
		map.addAttribute("rendimentoForm", rendimento);
		return LIST_PAGE;
	}
	
	@RequestMapping(value="/rendimento/search")
	public String search(@ModelAttribute("rendimentoForm") Rendimento rendimento, ModelMap map) {
		List<Rendimento> rendimentos = cadastrosGeraisService.pesquisarRendimentos(rendimento.getNomePessoa());
		map.addAttribute("resultado", rendimentos);
		if (rendimentos.isEmpty()) {
			MensagemUtil.adicionaMensagemAlerta(map, "Nenhum registro Encontrado");
		}
		return LIST_PAGE; 
	}
	
	@RequestMapping(value="/rendimento/newRendimento")
	public String create(ModelMap map) {
		Rendimento rendimento = new Rendimento();
		map.addAttribute("rendimentoForm", rendimento);
		return EDIT_PAGE;
	}
	
	@RequestMapping(value="/rendimento/save")
	public String save(@ModelAttribute("rendimentoForm") Rendimento rendimento, ModelMap map) {
		cadastrosGeraisService.salvarOuAtualizarRendimento(rendimento);
		MensagemUtil.adicionaMensagemSucesso(map, "Registro inserido/Atualizado com sucesso!");
		return LIST_PAGE; 
	}
	
	@RequestMapping(value="/rendimento/edit", method=RequestMethod.GET)
	public String prepareEdit(@RequestParam("rendimentoId") Long id, ModelMap map) {
		Rendimento rendimento = cadastrosGeraisService.findRendimentoById(id);
		map.addAttribute("rendimentoForm", rendimento);
		return EDIT_PAGE;
	}
	
	@RequestMapping(value="/rendimento/delete")
	public String remove(@RequestParam("rendimentoId") Long id, ModelMap map) {
		cadastrosGeraisService.excluirRendimento(id);
		MensagemUtil.adicionaMensagemSucesso(map, "Registro Excluído com sucesso!");
		map.addAttribute("rendimentoForm", new Rendimento());
		return LIST_PAGE;
	}
	

}
