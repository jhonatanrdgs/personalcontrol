package br.com.jhonatan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.jhonatan.entidades.Categoria;
import br.com.jhonatan.service.CategoriaService;

@Controller
public class CategoriaController {
	
	private static final String LIST_PAGE = "categoria/listCategoria";
	private static final String EDIT_PAGE = "categoria/editCategoria";
	
	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping(value="/categoria/listCategoria")
	public String listDespesas(ModelMap map) {
		Categoria categoriaForm = new Categoria();    
	    map.addAttribute("categoriaForm", categoriaForm);
		return LIST_PAGE;
	}
	
	@RequestMapping(value="/categoria/search")
	public String search(@ModelAttribute("categoriaForm") Categoria categoria, ModelMap map) {
		List<Categoria> categorias = categoriaService.pesquisarCategorias(categoria.getDescricao());
		map.addAttribute("resultado", categorias);
		//TODO paginação
		//TODO mensagem se não achar nada
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
		categoriaService.salvarOuAtualizar(categoria);
		//TODO mensagem de sucesso
		return LIST_PAGE; 
	}
	
	@RequestMapping(value="/categoria/edit", method=RequestMethod.GET)
	public String prepareEdit(@RequestParam("categoriaId") Long id, ModelMap map) {
		Categoria categoria = categoriaService.pesquisarPorId(id);
		map.addAttribute("categoriaForm", categoria);
		return EDIT_PAGE;
	}
	
}
