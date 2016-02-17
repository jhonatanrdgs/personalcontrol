package br.com.jhonatan.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.jhonatan.dto.FormRelatorioDTO;
import br.com.jhonatan.dto.RelatorioDespesaCarroPdfDTO;
import br.com.jhonatan.dto.RelatorioGastosMensaisPdfDTO;
import br.com.jhonatan.service.RelatorioService;
import br.com.jhonatan.util.DateUtil;
import br.com.jhonatan.util.MensagemUtil;

@Controller
@Scope("request")
public class RelatorioPDFController {
	
	private static final String PAGE = "/relatorios/relatorioPDF";
	
	@Autowired
	private RelatorioService relatorioService;
	
	@RequestMapping(value="/relatorioPDF")
	public String iniciar(final ModelMap map) {
		montarParametrosIniciais(map);
		return PAGE;
	}

	@RequestMapping(value="/relatorioPDF/imprimirGastosMensais")
	public String gerarGastosMensais(@ModelAttribute("relatorioForm") final FormRelatorioDTO relatorioForm, 
			final ModelMap map, final HttpServletResponse response) {
		final List<RelatorioGastosMensaisPdfDTO> list = relatorioService.pesquisarDadosRelatorioGastosMensaisPDF(relatorioForm);
		final Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("mes", relatorioForm.getMes());
		parametros.put("ano", relatorioForm.getAno());
		
		//TODO log exception - log geral (criar framework)
		
		try {
			gerarPDF(response, list, parametros, "gastosMensais");
		} catch (Exception e) {
			MensagemUtil.adicionaMensagemErro(map, "Erro ao gerar o PDF " + e);
		}
		montarParametrosIniciais(map);
		return PAGE;
	}
	
	@RequestMapping(value="/relatorioPDF/imprimirDespesasCarro")
	public String gerarDespesasCarro(final ModelMap map, final HttpServletResponse response) {
		final List<RelatorioDespesaCarroPdfDTO> list = relatorioService.pesquisarDadosRelatorioDespesaCarro();
		
		final Map<String, Object> parametros = new HashMap<String, Object>();
		try {
			gerarPDF(response, list, parametros, "despesasCarro");
		} catch (Exception e) {
			MensagemUtil.adicionaMensagemErro(map, "Erro ao gerar o PDF " + e);
		}
		montarParametrosIniciais(map);
		return PAGE;
	}

	private void gerarPDF(final HttpServletResponse response, final List<?> dados, 
			final Map<String, Object> params, final String nomeRelatorio) throws JRException, IOException {
		final InputStream jasperStream = this.getClass().getResourceAsStream("/reports/" + nomeRelatorio +".jasper");
		final JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(dados);

		final JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
		final JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, ds);

		response.setContentType("application/x-pdf");
		response.setHeader("Content-disposition", "inline; filename=" + nomeRelatorio + ".pdf");

		final OutputStream outStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
	}
	
	private void montarParametrosIniciais(final ModelMap map) {
		map.addAttribute("meses", DateUtil.getMeses());
		map.addAttribute("anos", DateUtil.get5AnosAtras5anosAFrente());
		map.addAttribute("relatorioForm", new FormRelatorioDTO());
	}
	
}
