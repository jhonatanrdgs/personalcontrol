package br.com.jhonatan.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorHandler {

	@RequestMapping(value="/error")
	public String handleError(final HttpServletRequest request, final ModelMap map) {
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
		map.addAttribute("status", statusCode);
		map.addAttribute("exception", throwable);
		return "error";
	}

}
