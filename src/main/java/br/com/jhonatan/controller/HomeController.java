package br.com.jhonatan.controller;

import java.io.Serializable;
import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.jhonatan.util.DateUtil;

/**
 * 
 * @author Jhonatan Rodrigues {jhonatan.rdgs@gmail.com}
 * 
 *
 */
@Controller
@Scope("session")
public class HomeController implements Serializable {
	
	private static final long serialVersionUID = 7404680020429281937L;
	private static final String VIEW_INDEX = "index";
	
	@RequestMapping(value="/logged")
	public String init(final ModelMap map) {
		map.addAttribute("mesAtual", DateUtil.getMes(new Date()));
		map.addAttribute("anoAtual", DateUtil.getAno(new Date()));
		return VIEW_INDEX;
	}
	
}
