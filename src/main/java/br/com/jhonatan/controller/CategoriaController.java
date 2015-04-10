package br.com.jhonatan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.jhonatan.entidades.Categoria;
import br.com.jhonatan.service.CadastrosGeraisService;
import br.com.jhonatan.util.MensagemUtil;

@Controller
@Scope("request")
public class CategoriaController {
	
	private static final String LIST_PAGE = "categoria/listCategoria";
	private static final String EDIT_PAGE = "categoria/editCategoria";
	
	@Autowired
	private CadastrosGeraisService cadastrosGeraisService;
	
	@RequestMapping(value="/categoria/listCategoria")
	public String listDespesas(ModelMap map) {
		Categoria categoriaForm = new Categoria();    
	    map.addAttribute("categoriaForm", categoriaForm);
		return LIST_PAGE;
	}
	
	@RequestMapping(value="/categoria/search")
	public String search(@ModelAttribute("categoriaForm") Categoria categoria, ModelMap map, Pageable pageable) {
		List<Categoria> resultado = cadastrosGeraisService.pesquisarCategorias(categoria.getDescricao(), categoria.isAtivo());
		
		map.addAttribute("resultado", resultado);
		
		if (resultado.isEmpty()) {
			MensagemUtil.adicionaMensagemAlerta(map, "Nenhum registro Encontrado");
		}
		return LIST_PAGE;
	}
	
	@RequestMapping(value="/categoria/newCategoria")
	public String newCategoria(ModelMap map) {
		Categoria categoriaForm = new Categoria();    
	    map.addAttribute("categoriaForm", categoriaForm);
		return EDIT_PAGE;
	}
	
	@RequestMapping(value="/categoria/save")
	public String saveCategoria(@ModelAttribute("categoriaForm") Categoria categoria, ModelMap map) {
		cadastrosGeraisService.salvarOuAtualizarCategoria(categoria);
		MensagemUtil.adicionaMensagemSucesso(map, "Registro inserido/Atualizado com sucesso!");
		return LIST_PAGE; 
	}
	
	@RequestMapping(value="/categoria/edit", method=RequestMethod.GET)
	public String prepareEdit(@RequestParam("categoriaId") Long id, ModelMap map) {
		Categoria categoria = cadastrosGeraisService.pesquisarPorId(id);
		map.addAttribute("categoriaForm", categoria);
		return EDIT_PAGE;
	}
	
	@RequestMapping(value="/categoria/delete")
	public String remove(@RequestParam("categoriaId") Long id, ModelMap map) {
		cadastrosGeraisService.excluirCategoria(id);
		MensagemUtil.adicionaMensagemSucesso(map, "Registro Inativado com sucesso!");
		map.addAttribute("categoriaForm", new Categoria());
		return LIST_PAGE;
	}
	
	@RequestMapping(value="/categoria/ativar")
	public String ativar(@RequestParam("categoriaId") Long id, ModelMap map) {
		cadastrosGeraisService.ativarCategoria(id);
		MensagemUtil.adicionaMensagemSucesso(map, "Registro Ativado com sucesso!");
		map.addAttribute("categoriaForm", new Categoria());
		return LIST_PAGE;
	}
	
}
