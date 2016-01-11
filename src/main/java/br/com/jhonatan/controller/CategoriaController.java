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

import br.com.jhonatan.entidades.Categoria;
import br.com.jhonatan.service.CadastrosGeraisService;
import br.com.jhonatan.util.MensagemUtil;

@Controller
@Scope("request")
public class CategoriaController extends CrudController<Categoria> {
	
	private static final long serialVersionUID = 3796302478381791588L;
	private static final String LIST_PAGE = "categoria/listCategoria";
	private static final String EDIT_PAGE = "categoria/editCategoria";
	
	@Autowired
	private CadastrosGeraisService cadastrosGeraisService;
	
	@RequestMapping(value="/categoria/listCategoria")
	public String list(final ModelMap map) {
	    map.addAttribute(FORM, new Categoria());
		return LIST_PAGE;
	}
	
	@RequestMapping(value="/categoria/search")
	public String search(@ModelAttribute(FORM) final Categoria categoria, final ModelMap map) {
		final List<Categoria> resultado = cadastrosGeraisService.pesquisarCategorias(categoria.getDescricao(), categoria.isAtivo());
		
		map.addAttribute("resultado", resultado);
		
		if (resultado.isEmpty()) {
			MensagemUtil.adicionaMensagemAlerta(map, "Nenhum registro Encontrado");
		}
		return LIST_PAGE;
	}
	
	@RequestMapping(value="/categoria/newCategoria")
	public String create(final ModelMap map) {
	    map.addAttribute(FORM, new Categoria());
		return EDIT_PAGE;
	}
	
	@RequestMapping(value="/categoria/save")
	public String save(@ModelAttribute(FORM) final Categoria categoria, final ModelMap map) {
		cadastrosGeraisService.salvarOuAtualizarCategoria(categoria);
		MensagemUtil.adicionaMensagemSucesso(map, "Registro inserido/Atualizado com sucesso!");
		return LIST_PAGE;
	}
	
	@RequestMapping(value="/categoria/edit", method=RequestMethod.GET)
	public String prepareEdit(@RequestParam("categoriaId") final Long id, final ModelMap map) {
		Categoria categoria = cadastrosGeraisService.pesquisarPorId(id);
		map.addAttribute(FORM, categoria);
		return EDIT_PAGE;
	}
	
	@RequestMapping(value="/categoria/delete")
	public String remove(@RequestParam("categoriaId") final Long id, final ModelMap map) {
		cadastrosGeraisService.excluirCategoria(id);
		MensagemUtil.adicionaMensagemSucesso(map, "Registro Inativado com sucesso!");
		map.addAttribute(FORM, new Categoria());
		return LIST_PAGE;
	}
	
	@RequestMapping(value="/categoria/ativar")
	public String ativar(@RequestParam("categoriaId") final Long id, final ModelMap map) {
		cadastrosGeraisService.ativarCategoria(id);
		MensagemUtil.adicionaMensagemSucesso(map, "Registro Ativado com sucesso!");
		map.addAttribute(FORM, new Categoria());
		return LIST_PAGE;
	}
	
}
