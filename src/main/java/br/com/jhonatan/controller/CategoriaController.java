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
		List<Categoria> categorias = categoriaService.pesquisarCategorias(categoria.getDescricao());
		map.addAttribute("resultado", categorias);
		//TODO paginação
		//TODO mensagem se não achar nada
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
		//TODO mensagem de sucesso
		return "categoria/listCategoria"; 
	}
	
	@RequestMapping(value="/categoria/edit", method=RequestMethod.GET)
	public String prepareEdit(@RequestParam("categoriaId") Long id, ModelMap map) {
		//TODO jogar a variável correta para a tela e casas o o método new
		Categoria categoriaForm = new Categoria();
		categoriaForm.setId(1L);
		categoriaForm.setDescricao("fumegante");
		 map.addAttribute("categoriaForm", categoriaForm);//TODO buscar no banco para mandar para a tela. tbm preencher os parametros da tela
		return "categoria/editCategoria";
	}
	
	

}
