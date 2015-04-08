package br.com.jhonatan.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author Jhonatan Rodrigues {jhonatan.rdgs@gmail.com}
 * 
 *
 */
@Controller
@Scope("session")
public class HomeController {
	
	private static final String VIEW_INDEX = "index";
	
	@RequestMapping(value="/logged")
	public String init(ModelMap map) {
		return VIEW_INDEX;
	}
	
}
