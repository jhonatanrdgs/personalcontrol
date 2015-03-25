package br.com.jhonatan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.jhonatan.entidades.DespesaCarro;
import br.com.jhonatan.service.DespesaCarroService;
import br.com.jhonatan.util.MensagemUtil;

@Controller
public class DespesaCarroController {
	
	private static final String LIST_PAGE = "despesaCarro/listDespesaCarro";
	private static final String EDIT_PAGE = "despesaCarro/editDespesaCarro";
	
	//TODO itemDespesaCarro
	//TODO dto para a tela de consulta 
	//TODO colocar UC no menu
	
	@Autowired
	private DespesaCarroService despesaCarroService;
	
	@RequestMapping(value="/despesaCarro/listDespesaCarro")
	public String listDespesaCarro(ModelMap map) {
		DespesaCarro despesaCarro = new DespesaCarro();
		map.addAttribute("despesaCarroForm", despesaCarro);
		return LIST_PAGE;
	}
	
	@RequestMapping(value="/despesaCarro/search")
	public String search(@ModelAttribute("despesaCarroForm") DespesaCarro despesaCarro, ModelMap map) {
		List<DespesaCarro> despesasCarro = despesaCarroService.pesquisarDespesasCarro(despesaCarro.getDescricao());
		map.addAttribute("resultado", despesasCarro);
		if (despesasCarro.isEmpty()) {
			MensagemUtil.adicionaMensagemAlerta(map, "Nenhum registro Encontrado");
		}
		return LIST_PAGE; 
	}
	
	@RequestMapping(value="/despesaCarro/newDespesaCarro")
	public String newDespesaCarro(ModelMap map) {
		DespesaCarro despesaCarro = new DespesaCarro();
		map.addAttribute("despesaCarroForm", despesaCarro);
		return EDIT_PAGE;
	}
	
	@RequestMapping(value="/despesaCarro/save")
	public String save(@ModelAttribute("despesaCarroForm") DespesaCarro despesaCarro, ModelMap map) {
		despesaCarroService.salvarOuAtualizarDespesasCarro(despesaCarro);
		MensagemUtil.adicionaMensagemSucesso(map, "Registro inserido/Atualizado com sucesso!");
		return LIST_PAGE; 
	}
	
	@RequestMapping(value="/despesaCarro/edit", method=RequestMethod.GET)
	public String edit(@RequestParam("despesaCarroId") Long id, ModelMap map) {
		DespesaCarro despesaCarro = despesaCarroService.findDespesasCarroById(id);
		map.addAttribute("despesaCarroForm", despesaCarro);
		return EDIT_PAGE;
	}

}
