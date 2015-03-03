package br.com.jhonatan.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.jhonatan.entidades.Categoria;
import br.com.jhonatan.entidades.Despesa;
import br.com.jhonatan.entidades.MetodoPagamento;
import br.com.jhonatan.service.CategoriaService;
import br.com.jhonatan.service.DespesaService;
import br.com.jhonatan.service.MetodoPagamentoService;

@Controller
public class DespesaController {
	
	@Autowired
	private DespesaService despesaService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private MetodoPagamentoService metodoPagamentoService;

	@RequestMapping(value="/despesa/listDespesas")
	public String listDespesas(ModelMap map) {
		//TODO preencher e colocar combos na tela
		Despesa despesa = new Despesa();
		despesa.setCategoria(new Categoria());
		despesa.setMetodoPagamento(new MetodoPagamento());
		map.addAttribute("despesaForm", despesa);
		return "despesa/listDespesa";
	}
	
	@RequestMapping(value="/despesa/search")
	public String search(@ModelAttribute("despesaForm") Despesa despesa, ModelMap map) {
		List<Despesa> despesas = despesaService.pesquisarDespesas
				(despesa.getDescricao(), despesa.getCategoria().getId(),
						despesa.getMetodoPagamento().getId(), new Date(), new Date());//TODO arrumar datas
		map.addAttribute("resultado", despesas);
		return "despesa/listDespesa";
	}
	
	@RequestMapping(value="/despesa/newDespesa")
	public String newDespesa(ModelMap map) {
		//TODO preencher e colocar combos na tela
		Despesa despesa = new Despesa();
		map.addAttribute("despesaForm", despesa);
		return "despesa/editDespesa";
	}
	
	@RequestMapping(value="/despesa/save")
	public String save(@ModelAttribute("despesaForm") Despesa despesa, ModelMap map) {
		despesaService.salvarOuAtualizar(despesa);
		//TODO mensagem de sucesso
		return "despesa/listDespesa";
	}
	
	@RequestMapping(value="/despesa/edit", method=RequestMethod.GET)
	public String edit(@RequestParam("despesaId") Long id, ModelMap map) {
		//TODO preencher e colocar combos na tela
		Despesa despesa = despesaService.findById(id);
		map.addAttribute("despesaForm", despesa);
		return "despesa/editDespesa";
	}
	
	//TODO btn voltar
	
}
