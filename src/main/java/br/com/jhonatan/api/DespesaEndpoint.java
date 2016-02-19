package br.com.jhonatan.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.jhonatan.entidades.Categoria;
import br.com.jhonatan.entidades.Despesa;
import br.com.jhonatan.entidades.MetodoPagamento;
import br.com.jhonatan.service.DespesaService;

@Controller
@RequestMapping("/despesaApi")
public class DespesaEndpoint {
	
	@Autowired
	private DespesaService despesaService;
	
	@RequestMapping(method=RequestMethod.GET, value="/listarDespesas", headers="Accept=application/json")
	public @ResponseBody List<Despesa> listarDespesas() {
		final Despesa despesa = new Despesa();//TODO construtor mais elegante
		despesa.setDescricao("");
		despesa.setCategoria(new Categoria());
		despesa.setMetodoPagamento(new MetodoPagamento());
		return despesaService.pesquisarDespesas(despesa); //TODO parametros
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/salvarDespesa")
	public @ResponseBody boolean salvar(@RequestBody final Despesa despesa) {
		despesaService.salvarOuAtualizar(despesa);
		return true;
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/atualizarDespesa", headers="Accept=application/json")
	public @ResponseBody boolean atualizar(@RequestBody final Despesa despesa) {
		despesaService.salvarOuAtualizar(despesa);
		return true;
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/excluirDespesa", headers="Accept=application/json")
	public @ResponseBody boolean excluir(@RequestParam("despesaId") final Long despesaId) {
		despesaService.excluirDespesa(despesaId);
		return true;
	}
	
	

}
