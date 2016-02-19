package br.com.jhonatan.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorHandler {
	
	@RequestMapping(value="/error")
	public String handleError(HttpServletRequest request) {
		return "error";
	}

}
