package br.com.jhonatan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.jhonatan.entidades.Categoria;
import br.com.jhonatan.service.CategoriaService;

@Controller
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping(value="/categoria/listCategoria")
	public String listDespesas(ModelMap map) {
		Categoria categoriaForm = new Categoria();    
	    map.addAttribute("categoriaForm", categoriaForm);
		return "categoria/listCategoria";
	}
	
	@RequestMapping(value="/categoria/search")
	public String search(@ModelAttribute("categoriaForm") Categoria categoria, ModelMap map) {
		System.out.println("teste");
		//TODO
		return "categoria/listCategoria"; 
	}
	
	@RequestMapping(value="/categoria/newCategoria")
	public String newCategoria(ModelMap map) {
		Categoria categoriaForm = new Categoria();    
	    map.addAttribute("categoriaForm", categoriaForm);
		return "categoria/editCategoria";
	}
	
	@RequestMapping(value="/categoria/save")
	public String saveCategoria(@ModelAttribute("categoriaForm") Categoria categoria, ModelMap map) {
		categoriaService.salvarOuAtualizar(categoria);
		return "categoria/listCategoria"; 
	}
	
	

}
