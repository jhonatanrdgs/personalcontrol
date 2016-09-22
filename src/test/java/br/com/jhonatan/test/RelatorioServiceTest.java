package br.com.jhonatan.test;

import static org.junit.Assert.assertEquals;

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
	public void abrirPagina() throws Exception {
		assertEquals(200, relatorioService.pesquisarResumo(1, 1).getTotalGastos(), 0.001);
	}

}