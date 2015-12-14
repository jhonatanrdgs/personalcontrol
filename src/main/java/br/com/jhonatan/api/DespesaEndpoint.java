package br.com.jhonatan.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.jhonatan.dto.DespesaDTO;
import br.com.jhonatan.entidades.Despesa;
import br.com.jhonatan.service.DespesaService;

@Controller
@RequestMapping("/despesaApi")
public class DespesaEndpoint {
	
	@Autowired
	private DespesaService despesaService;
	
	@RequestMapping(method=RequestMethod.GET, value="/listarDespesas", headers="Accept=application/json")
	public @ResponseBody List<Despesa> listarDespesas() {
		return despesaService.pesquisarDespesas(new DespesaDTO()); //TODO parametros
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/salvarDespesa", headers="Accept=application/json")
	public @ResponseBody boolean salvar(@RequestParam("despesa") Despesa despesa) {
		despesaService.salvarOuAtualizar(despesa);//TODO ver o esquema de setar usuário via rest, se funciona bacana.
		return true;
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/atualizarDespesa", headers="Accept=application/json")
	public @ResponseBody boolean atualizar(@RequestParam("despesa") Despesa despesa) {
		despesaService.salvarOuAtualizar(despesa);//TODO ver o esquema de setar usuário via rest, se funciona bacana.
		return true;
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/excluirDespesa", headers="Accept=application/json")
	public @ResponseBody boolean excluir(@RequestParam("despesaId") Long despesaId) {
		despesaService.excluirDespesa(despesaId);
		return true;
	}
	
	

}
