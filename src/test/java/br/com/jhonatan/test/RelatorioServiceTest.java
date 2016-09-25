package br.com.jhonatan.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import br.com.jhonatan.dto.RelatorioResumoDTO;
import br.com.jhonatan.entidades.Categoria;
import br.com.jhonatan.entidades.Despesa;
import br.com.jhonatan.entidades.MetodoPagamento;
import br.com.jhonatan.entidades.Rendimento;
import br.com.jhonatan.service.CadastrosGeraisService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.jhonatan.service.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "classpath:test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class RelatorioServiceTest {

	@Autowired
	private  RelatorioService relatorioService;

	@Test
	public void testResumo() throws Exception {
		final RelatorioResumoDTO relatorioResumoDTO = relatorioService.pesquisarResumo(9, 2016);

		assertEquals(770.00, relatorioResumoDTO.getTotalGastos(), 0.001);
        assertEquals(650.00, relatorioResumoDTO.getTotalGastosVariaveisPeriodo(), 0.001);
        assertEquals(120.00, relatorioResumoDTO.getTotalGastosFixos(), 0.001);
        assertEquals(4000.00, relatorioResumoDTO.getRendimentos(), 0.001);
        assertEquals(3230.00, relatorioResumoDTO.getSobra(), 0.001);
		assertEquals(19.25, relatorioResumoDTO.getPercentualComprometido(), 0.001);
	}

}