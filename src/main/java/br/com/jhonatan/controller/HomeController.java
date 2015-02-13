package br.com.jhonatan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author Jhonatan Rodrigues {jhonatan.rdgs@gmail.com}
 * 
 *
 */
@Controller
public class HomeController {
	
	private static final String VIEW_INDEX = "index";
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String init(ModelMap map) {
		map.addAttribute("bemVindo", "Bem Vindo!");
		return VIEW_INDEX;
	}

}
