package br.com.jhonatan.util;

import org.springframework.ui.ModelMap;

public class MensagemUtil {

	//TODO internacionalizar mensagens
	
	public static void adicionaMensagemSucesso(ModelMap map, String mensagem) {
		map.addAttribute("sucesso", mensagem);
	}
	
	public static void adicionaMensagemErro(ModelMap map, String mensagem) {
		map.addAttribute("erro", mensagem);
	}
	
	public static void adicionaMensagemAlerta(ModelMap map, String mensagem) {
		map.addAttribute("alerta", mensagem);
	}
	
}
