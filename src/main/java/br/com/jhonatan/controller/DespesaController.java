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

import br.com.jhonatan.dto.DespesaDTO;
import br.com.jhonatan.entidades.Categoria;
import br.com.jhonatan.entidades.Despesa;
import br.com.jhonatan.entidades.MetodoPagamento;
import br.com.jhonatan.service.CategoriaService;
import br.com.jhonatan.service.DespesaService;
import br.com.jhonatan.service.MetodoPagamentoService;

@Controller
public class DespesaController {
	
	private static final String LIST_PAGE = "despesa/listDespesa";
	private static final String EDIT_PAGE = "despesa/editDespesa";
	
	@Autowired
	private DespesaService despesaService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private MetodoPagamentoService metodoPagamentoService;

	@RequestMapping(value="/despesa/listDespesas")
	public String listDespesas(ModelMap map) {
		montaDTO(map);
		montarCombos(map);
		return LIST_PAGE;
	}

	@RequestMapping(value="/despesa/search")
	public String search(@ModelAttribute("despesaForm") DespesaDTO despesaDTO, ModelMap map) {
		List<Despesa> despesas = despesaService.pesquisarDespesas(despesaDTO);//TODO bug na busca sem datas, não está trazendo de todas se as datas estiverem null
		map.addAttribute("resultado", despesas);
		montarCombos(map);
		montaDTO(map);
		return LIST_PAGE;
	}
	
	@RequestMapping(value="/despesa/newDespesa")
	public String newDespesa(ModelMap map) {
		//TODO questão do grupo
		Despesa despesa = new Despesa();
		despesa.setData(new Date());
		despesa.setTotalParcelas(1);
		map.addAttribute("despesaForm", despesa);
		montarCombos(map);
		return EDIT_PAGE;
	}
	
	@RequestMapping(value="/despesa/save")
	public String save(@ModelAttribute("despesaForm") Despesa despesa, ModelMap map) {
		despesaService.salvarOuAtualizar(despesa);
		//TODO mensagem de sucesso
		montaDTO(map);
		return LIST_PAGE;
	}
	
	@RequestMapping(value="/despesa/edit", method=RequestMethod.GET)
	public String edit(@RequestParam("despesaId") Long id, ModelMap map) {
		Despesa despesa = despesaService.findByIdFetched(id);
		map.addAttribute("despesaForm", despesa);
		montarCombos(map);
		return EDIT_PAGE;
	}
	
	private void montaDTO(ModelMap map) {
		DespesaDTO despesaDTO = new DespesaDTO();
		map.addAttribute("despesaForm", despesaDTO);
	}
	
	private void montarCombos(ModelMap map) {
		List<Categoria> categorias = categoriaService.pesquisarTodasCategorias();//TODO, colocar categorias ativas somente, refatorar
		List<MetodoPagamento> metodosPagamento = metodoPagamentoService.pesquisarTodosMetodosPagamento();//TODO, colocar metodos de pagamento ativos somente, refatorar
		map.addAttribute("categorias", categorias);
		map.addAttribute("metodosPagamento", metodosPagamento);
	}
	
}
