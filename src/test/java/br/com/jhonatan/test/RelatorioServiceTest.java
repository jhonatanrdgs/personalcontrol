package br.com.jhonatan.test;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.jhonatan.dao.DespesaDAO;
import br.com.jhonatan.dto.RelatorioComprasParceladasDTO;
import br.com.jhonatan.service.RelatorioService;
import br.com.jhonatan.service.RelatorioServiceImp;

@RunWith(MockitoJUnitRunner.class)
public class RelatorioServiceTest {

	@Mock
	private DespesaDAO despesaDAO;
	
	@InjectMocks
	private final RelatorioService relatorioService = new RelatorioServiceImp();

	@Test
	public void abrirPagina() throws Exception {
		when(despesaDAO.pesquisarDespesasParceladasMes(anyInt(), anyInt())).thenReturn(new ArrayList<RelatorioComprasParceladasDTO>());
		assertTrue(relatorioService.pesquisarDadosRelatorioComprasParceladas(1, 1).isEmpty());
	}

}