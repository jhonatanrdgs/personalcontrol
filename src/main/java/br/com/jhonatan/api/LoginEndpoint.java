package br.com.jhonatan.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.jhonatan.dto.Credenciais;
import br.com.jhonatan.entidades.Usuario;
import br.com.jhonatan.service.UsuarioService;

@Controller
@RequestMapping("/loginApi")
public class LoginEndpoint {
	
	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(method=RequestMethod.POST, value="/logar")
	public @ResponseBody Usuario login(@RequestBody final Credenciais credenciais) {
		return usuarioService.logar(credenciais.getUser(), credenciais.getPw());
	}
	
}
