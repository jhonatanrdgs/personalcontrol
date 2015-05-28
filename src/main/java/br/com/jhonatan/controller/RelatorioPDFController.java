package br.com.jhonatan.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.jhonatan.dto.FormRelatorioDTO;
import br.com.jhonatan.util.DateUtil;
import br.com.jhonatan.util.MensagemUtil;

@Controller
@Scope("request")
public class RelatorioPDFController {
	
	private final String PAGE = "/relatorios/relatorioPDF";
	
	@RequestMapping(value="/relatorioPDF")
	public String iniciar(ModelMap map) {
		map.addAttribute("meses", DateUtil.getMeses());
		map.addAttribute("anos", DateUtil.get5AnosAtras5anosAFrente());
		map.addAttribute("relatorioForm", new FormRelatorioDTO());
		return PAGE;
	}
	
	@RequestMapping(value="/relatorioPDF/imprimir")
	@ResponseBody
	public String gerar(@ModelAttribute("relatorioForm") FormRelatorioDTO relatorioForm, ModelMap map, HttpServletResponse response) {
		//TODO trazer os dados, e no relatório agrupar por categoria (colocar o total de cada categoria)
		//TODO colocar o número da parcela na frente do nome do gasto. Ex.: Tenis (1/12)
		
		try {
			gerarPDF(response);
		} catch (Exception e) {
			MensagemUtil.adicionaMensagemErro(map, "Erro ao gerar o PDF " + e.getCause());
		}
		
		//System.out.println(relatorioForm);
		
		return PAGE;
	}

	private void gerarPDF(HttpServletResponse response) throws JRException,	IOException {
		InputStream jasperStream = this.getClass().getResourceAsStream("/reports/gastosMensais.jasper");
		Map<String,Object> params = new HashMap<String,Object>();

		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JREmptyDataSource());//TODO erro aqui... Caused by: java.lang.ClassNotFoundException: org.codehaus.groovy.control.CompilationFailedException

		response.setContentType("application/x-pdf");
		response.setHeader("Content-disposition", "inline; filename=helloWorldReport.pdf");

		final OutputStream outStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
	}
	
}
