package br.com.jhonatan.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.jhonatan.entidades.Categoria;
import br.com.jhonatan.entidades.MetodoPagamento;
import br.com.jhonatan.service.CadastrosGeraisService;


@Controller
@RequestMapping("/cadastrosGeraisApi")
public class CadastrosGeraisEndpoint {

	@Autowired
	private CadastrosGeraisService cadastrosGeraisService;
	
	@RequestMapping(method=RequestMethod.GET, value="/getCategorias", headers="Accept=application/json")
	public @ResponseBody List<Categoria> categorias() {
		return cadastrosGeraisService.pesquisarTodasCategoriasAtivas();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getMetodosPagamento", headers="Accept=application/json")
	public @ResponseBody List<MetodoPagamento> metodosPagamento() {
		return cadastrosGeraisService.pesquisarTodosMetodosPagamentoAtivos();
	}
	
}
