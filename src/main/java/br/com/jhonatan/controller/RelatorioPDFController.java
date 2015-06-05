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
	
	private final String PAGE = "/relatorios/relatorioPDF";
	
	@Autowired
	private RelatorioService relatorioService;
	
	@RequestMapping(value="/relatorioPDF")
	public String iniciar(ModelMap map) {
		montarParametrosIniciais(map);
		return PAGE;
	}

	@RequestMapping(value="/relatorioPDF/imprimirGastosMensais")
	public String gerarGastosMensais(@ModelAttribute("relatorioForm") FormRelatorioDTO relatorioForm, ModelMap map, HttpServletResponse response) {
		List<RelatorioGastosMensaisPdfDTO> list = relatorioService.pesquisarDadosRelatorioGastosMensais(relatorioForm);
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("mes", relatorioForm.getMes());
		parametros.put("ano", relatorioForm.getAno());
		
		//TODO arrumar pom (tem duas versões do spring)
		//TODO arrumar questão de ter a mesma config de banco no persistence e no ds
		//TODO bug na despesa carro, se coloco acento nos itens mata formatação..
		//TODO poder editar/excluir os esquemas da despesacarro
		//TODO logs
		
		try {
			gerarPDF(response, list, parametros, "gastosMensais");
		} catch (Exception e) {
			MensagemUtil.adicionaMensagemErro(map, "Erro ao gerar o PDF " + e);
		}
		montarParametrosIniciais(map);
		return PAGE;
	}
	
	@RequestMapping(value="/relatorioPDF/imprimirDespesasCarro")
	public String gerarDespesasCarro(ModelMap map, HttpServletResponse response) {
		List<RelatorioDespesaCarroPdfDTO> list = relatorioService.pesquisarDadosRelatorioDespesaCarro();
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		try {
			gerarPDF(response, list, parametros, "despesasCarro");
		} catch (Exception e) {
			MensagemUtil.adicionaMensagemErro(map, "Erro ao gerar o PDF " + e);
		}
		montarParametrosIniciais(map);
		return PAGE;
	}

	private void gerarPDF(HttpServletResponse response, List<?> dados, Map<String, Object> params, String nomeRelatorio) throws JRException, IOException {
		InputStream jasperStream = this.getClass().getResourceAsStream("/reports/" + nomeRelatorio +".jasper");
		JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(dados);

		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, ds);

		response.setContentType("application/x-pdf");
		response.setHeader("Content-disposition", "inline; filename=" + nomeRelatorio + ".pdf");

		final OutputStream outStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
	}
	
	private void montarParametrosIniciais(ModelMap map) {
		map.addAttribute("meses", DateUtil.getMeses());
		map.addAttribute("anos", DateUtil.get5AnosAtras5anosAFrente());
		map.addAttribute("relatorioForm", new FormRelatorioDTO());
	}
	
}
