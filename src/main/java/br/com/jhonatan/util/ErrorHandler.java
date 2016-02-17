package br.com.jhonatan.util;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorHandler {
	
	@RequestMapping(value="/error")
	public String handleError() {
		return "error";
	}

}
