package br.com.jhonatan.api;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.jhonatan.service.RelatorioService;
import br.com.jhonatan.util.DateUtil;


@Controller
@RequestMapping("/relatorioApi")
public class RelatorioResumoEndpoint {
	
	@Autowired
	private RelatorioService relatorioService;
	
	@RequestMapping(method=RequestMethod.GET, value="/resumo", headers="Accept=application/json")
	public @ResponseBody Double[] montarResumoJson() {
		int mes = DateUtil.getMes(new Date());
		int ano = DateUtil.getAno(new Date());
		return relatorioService.pesquisarResumo(mes, ano);
	}

}
