package br.com.jhonatan.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.jhonatan.entidades.Usuario;

@Controller
@RequestMapping("/despesaApi")
public class DespesaEndpoint {
	
	@RequestMapping(method=RequestMethod.GET, value="/listarDespesas", headers="Accept=application/json")
	public @ResponseBody Usuario listarDespesas() {
		Usuario u = new Usuario();
		u.setId(123L);
		return u;
		//TODO
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/salvarDespesa", headers="Accept=application/json")
	public @ResponseBody boolean salvar() {
		return true;
		//TODO
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/atualizarDespesa", headers="Accept=application/json")
	public @ResponseBody boolean atualizar() {
		return true;
		//TODO
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/excluirDespesa", headers="Accept=application/json")
	public @ResponseBody boolean excluir() {
		return true;
		//TODO
	}
	
	

}
