package br.com.jhonatan.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope("request")
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) final String error,
			@RequestParam(value = "logout", required = false) final String logout, final ModelAndView model) {

		if (error != null) {
			model.addObject("erro", "Usuário e senha inválidos!");
		}

		if (logout != null) {
			model.addObject("sucesso", "Deslogado com sucesso!");
		}
		model.setViewName("login");

		return model;

	}

}
