package br.com.jhonatan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.jhonatan.entidades.MetodoPagamento;
import br.com.jhonatan.service.MetodoPagamentoService;

@Controller
public class MetodoPagamentoController {
	
	//TODO colocar os return como constantes
	
	@Autowired
	private MetodoPagamentoService metodoPagamentoService;

	@RequestMapping(value="/metodoPagamento/listMetodosPagamento")
	public String listMetodosPagamento(ModelMap map) {
		MetodoPagamento metodoPg = new MetodoPagamento();
		map.addAttribute("metodoPagamentoForm", metodoPg);
		return "metodoPagamento/listMetodoPagamento";
	}
	
	@RequestMapping(value="/metodoPagamento/search")
	public String search(@ModelAttribute("metodoPagamentoForm") MetodoPagamento metodoPagamento, ModelMap map) {
		List<MetodoPagamento> metodosPagamento = metodoPagamentoService.pesquisarMetodosPagamento(metodoPagamento.getDescricao());
		map.addAttribute("resultado", metodosPagamento);
		return "metodoPagamento/listMetodoPagamento"; 
	}
	
	@RequestMapping(value="/metodoPagamento/newMetodoPagamento")
	public String newMetodoPagamento(ModelMap map) {
		MetodoPagamento metodoPg = new MetodoPagamento();
		map.addAttribute("metodoPagamentoForm", metodoPg);
		return "metodoPagamento/editMetodoPagamento";
	}
	
	@RequestMapping(value="/metodoPagamento/save")
	public String save(@ModelAttribute("metodoPagamentoForm") MetodoPagamento metodoPagamento, ModelMap map) {
		metodoPagamentoService.salvarOuAtualizar(metodoPagamento);
		//TODO mensagem de sucesso
		return "metodoPagamento/listMetodoPagamento"; 
	}
	
	@RequestMapping(value="/metodoPagamento/edit", method=RequestMethod.GET)
	public String edit(@RequestParam("metodoPagamentoId") Long id, ModelMap map) {
		MetodoPagamento metodoPg = metodoPagamentoService.findById(id);
		map.addAttribute("metodoPagamentoForm", metodoPg);
		return "metodoPagamento/editMetodoPagamento";
	}
	
}
