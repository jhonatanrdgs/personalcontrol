package br.com.jhonatan.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.jhonatan.dto.DespesaDTO;
import br.com.jhonatan.entidades.Categoria;
import br.com.jhonatan.entidades.DespesaCarro;
import br.com.jhonatan.entidades.ItemDespesaCarro;
import br.com.jhonatan.entidades.MetodoPagamento;
import br.com.jhonatan.service.CadastrosGeraisService;
import br.com.jhonatan.service.DespesaCarroService;
import br.com.jhonatan.util.MensagemUtil;

@Controller
public class DespesaCarroController {
	
	private static final String LIST_PAGE = "despesaCarro/listDespesaCarro";
	private static final String EDIT_PAGE = "despesaCarro/editDespesaCarro";
	
	//TODO maxlenght nos campos
	
	@Autowired
	private DespesaCarroService despesaCarroService;
	
	@Autowired
	private CadastrosGeraisService cadastrosGeraisService;
	
	private List<ItemDespesaCarro> itens;
	
	@RequestMapping(value="/despesaCarro/listDespesaCarro")
	public String listDespesaCarro(ModelMap map) {
		DespesaDTO dto = new DespesaDTO();
		map.addAttribute("despesaCarroForm", dto);
		montarCombos(map);
		return LIST_PAGE;
	}
	
	@RequestMapping(value="/despesaCarro/search")
	public String search(@ModelAttribute("despesaCarroForm") DespesaDTO despesaCarro, ModelMap map) {
		List<DespesaCarro> despesasCarro = despesaCarroService.pesquisarDespesasCarro(despesaCarro);
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
		montarCombos(map);
		itens = new ArrayList<ItemDespesaCarro>();
		return EDIT_PAGE;
	}
	
	@RequestMapping(value="/despesaCarro/add", headers="Accept=application/json")
	public @ResponseBody List<ItemDespesaCarro> add(@RequestParam(value="descricao") String descricao, @RequestParam(value="valor") Double valor) {
		ItemDespesaCarro item = new ItemDespesaCarro();
		item.setDescricao(descricao);
		item.setValorItem(valor);
		itens.add(item);
		return itens;
	}
	
	@RequestMapping(value="/despesaCarro/save")
	public String save(@ModelAttribute("despesaCarroForm") DespesaCarro despesaCarro, ModelMap map) {
		despesaCarroService.salvarOuAtualizarDespesasCarro(despesaCarro, itens);
		MensagemUtil.adicionaMensagemSucesso(map, "Registro inserido/Atualizado com sucesso!");
		DespesaDTO dto = new DespesaDTO();
		map.addAttribute("despesaCarroForm", dto);
		return LIST_PAGE; 
	}
	
	@RequestMapping(value="/despesaCarro/edit", method=RequestMethod.GET)
	public String edit(@RequestParam("despesaCarroId") Long id, ModelMap map) {
		DespesaCarro despesaCarro = despesaCarroService.findDespesasCarroById(id);
		map.addAttribute("despesaCarroForm", despesaCarro);
		montarCombos(map);
		return EDIT_PAGE;
	}
	
	private void montarCombos(ModelMap map) {
		List<Categoria> categorias = cadastrosGeraisService.pesquisarTodasCategoriasAtivas();
		List<MetodoPagamento> metodosPagamento = cadastrosGeraisService.pesquisarTodosMetodosPagamentoAtivos();
		map.addAttribute("categorias", categorias);
		map.addAttribute("metodosPagamento", metodosPagamento);
	}

}