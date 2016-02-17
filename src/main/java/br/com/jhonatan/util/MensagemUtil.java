package br.com.jhonatan.util;

import org.springframework.ui.ModelMap;

public final class MensagemUtil {
	
	private MensagemUtil() {}

	public static void adicionaMensagemSucesso(final ModelMap map, final String mensagem) {
		map.addAttribute("sucesso", mensagem);
	}
	
	public static void adicionaMensagemErro(final ModelMap map, final String mensagem) {
		map.addAttribute("erro", mensagem);
	}
	
	public static void adicionaMensagemAlerta(final ModelMap map, final String mensagem) {
		map.addAttribute("alerta", mensagem);
	}
	
}
