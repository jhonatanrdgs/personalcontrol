package br.com.jhonatan.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.jhonatan.entidades.Categoria;
import br.com.jhonatan.entidades.Despesa;
import br.com.jhonatan.entidades.MetodoPagamento;
import br.com.jhonatan.service.CadastrosGeraisService;
import br.com.jhonatan.service.DespesaService;
import br.com.jhonatan.util.Constantes;
import br.com.jhonatan.util.MensagemUtil;

@Controller
@Scope("request")
public class DespesaController extends AbstractCrudController<Despesa> {
	
	private static final long serialVersionUID = 1L;
	private static final String LIST_PAGE = "despesa/listDespesa";
	private static final String EDIT_PAGE = "despesa/editDespesa";
	
	@Autowired
	private DespesaService despesaService;
	
	@Autowired
	private CadastrosGeraisService cadastrosGeraisService;
	
	@RequestMapping(value="/despesa/listDespesas")
	public String list(final ModelMap map) {
		montaDTO(map);
		montarCombos(map);
		return LIST_PAGE;
	}

	@RequestMapping(value="/despesa/search")
	public String search(@ModelAttribute("despesaForm") final Despesa despesa, final ModelMap map) {
		final List<Despesa> despesas = despesaService.pesquisarDespesas(despesa);
		map.addAttribute("resultado", despesas);
		if (despesas.isEmpty()) {
			MensagemUtil.adicionaMensagemAlerta(map, "Nenhum registro Encontrado");
		}
		montarCombos(map);
		montaDTO(map);
		return LIST_PAGE;
	}
	
	@RequestMapping(value="/despesa/newDespesa")
	public String create(final ModelMap map) {
		final Despesa despesa = new Despesa();//TODO construtor mais elegante
		despesa.setData(new Date());
		despesa.setTotalParcelas(1);
		map.addAttribute("despesaForm", despesa);
		montarCombos(map);
		return EDIT_PAGE;
	}
	
	@RequestMapping(value="/despesa/save")
	public String save(@ModelAttribute("despesaForm") final Despesa despesa, final ModelMap map) {
		despesaService.salvarOuAtualizar(despesa);
		montaDTO(map);
		MensagemUtil.adicionaMensagemSucesso(map, "Registro inserido/Atualizado com sucesso!");
		return LIST_PAGE;
	}
	
	@RequestMapping(value="/despesa/edit", method=RequestMethod.GET)
	public String prepareEdit(@RequestParam("despesaId") final Long idDespesa, final ModelMap map) {
		final Despesa despesa = despesaService.findByIdFetched(idDespesa);
		map.addAttribute("despesaForm", despesa);
		montarCombos(map);
		return EDIT_PAGE;
	}
	
	@RequestMapping(value="/despesa/delete")
	public String remove(@RequestParam("despesaId") final Long idDespesa, final ModelMap map) {
		despesaService.excluirDespesa(idDespesa);
		MensagemUtil.adicionaMensagemSucesso(map, "Registro Excluído com sucesso!");
		montaDTO(map);
		montarCombos(map);
		return LIST_PAGE;
	}
	
	private void montaDTO(final ModelMap map) {
		map.addAttribute("despesaForm", new Despesa());
	}
	
	private void montarCombos(final ModelMap map) {
		final List<Categoria> categorias = cadastrosGeraisService.pesquisarTodasCategoriasAtivas();
		final List<MetodoPagamento> metodosPagamento = cadastrosGeraisService.pesquisarTodosMetodosPagamentoAtivos();
		map.addAttribute("categorias", categorias);
		map.addAttribute("metodosPagamento", metodosPagamento);
	}
	
	@InitBinder
	public void initBinder(final WebDataBinder binder) {
		final SimpleDateFormat dateFormat = new SimpleDateFormat(Constantes.FORMATO_DATA_PT_BR);
		binder.registerCustomEditor(Date.class, null, new CustomDateEditor(dateFormat, true));
	}
	
}
