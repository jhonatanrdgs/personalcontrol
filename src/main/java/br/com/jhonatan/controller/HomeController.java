package br.com.jhonatan.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.jhonatan.entidades.Usuario;

/**
 * 
 * @author Jhonatan Rodrigues {jhonatan.rdgs@gmail.com}
 * 
 *
 */
@Controller
public class HomeController {
	
	private static final String VIEW_INDEX = "index";
	
	@RequestMapping(value="/logged")
	@Transactional
	public String init(ModelMap map) {
//		Usuario u = new Usuario();
//		u.setOi("oi");
//		entityManager.persist(u);
		map.addAttribute("bemVindo", "Bem Vindo!");
		return VIEW_INDEX;
	}
	
}
