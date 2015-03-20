package br.com.jhonatan.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jhonatan.dao.CategoriaDAO;
import br.com.jhonatan.dao.DespesaDAO;
import br.com.jhonatan.dao.MetodoPagamentoDAO;
import br.com.jhonatan.dao.RendimentoDAO;
import br.com.jhonatan.dto.RelatorioComprasParceladasDTO;
import br.com.jhonatan.dto.RelatorioDespesaPorCategoriaDTO;
import br.com.jhonatan.dto.RelatorioGastosFixosDTO;
import br.com.jhonatan.dto.RelatorioGastosPorMetodoPagamentoDTO;
import br.com.jhonatan.dto.RelatorioGastosVariaveisDTO;
import br.com.jhonatan.dto.RelatorioRendimentoGastosDTO;
import br.com.jhonatan.dto.RelatorioTotalGastosMensaisDTO;

@Service
public class RelatorioServiceImp implements RelatorioService {
	
	@Autowired
	private CategoriaDAO categoriaDAO;
	
	@Autowired
	private DespesaDAO despesaDAO;
	
	@Autowired
	private MetodoPagamentoDAO metodoPagamentoDAO;
	
	@Autowired
	private RendimentoDAO rendimentoDAO;

	@Override
	public List<RelatorioDespesaPorCategoriaDTO> pesquisarDadosRelatorioDespesasPorCategoriasAtivas(Date inicio, Date fim) {
		return categoriaDAO.pesquisarDespesasPorCategoriasAtivas(inicio, fim);
	}

	@Override
	public List<RelatorioComprasParceladasDTO> pesquisarDadosRelatorioComprasParceladas(Date inicio, Date fim) {
		return despesaDAO.pesquisarDespesasParceladasPeriodo(inicio, fim);
	}

	@Override
	public List<RelatorioGastosPorMetodoPagamentoDTO> pesquisarDadosRelatorioGastosPorMetodoPagamento(Date inicio, Date fim) {
		return metodoPagamentoDAO.pesquisarDespesasPorMetodoPagamentoAtivo(inicio, fim);
	}
	
	@Override
	public List<RelatorioGastosVariaveisDTO> pesquisarDadosRelatorioGastosVariaveis(Date inicio, Date fim) {
		return despesaDAO.pesquisarDespesasVariaveisPeriodo(inicio, fim);
	}

	@Override
	public List<RelatorioGastosFixosDTO> pesquisarDadosRelatorioGastosFixos() {
		return despesaDAO.pesquisarDespesasFixas();
	}

	@Override
	public List<RelatorioTotalGastosMensaisDTO> pesquisarDadosRelatorioGastosMensais() {
		//TODO verificar, pois se eu não trazer a primeira lista, ele não traz a segunda..
				//a questão é se tiver dados somente em uma lista.
		//TODO trazer ultimos 12 meses
		List<RelatorioTotalGastosMensaisDTO> list = despesaDAO.pesquisarValorDespesasPorMes();//TODO Fazer ordenação
		for (RelatorioTotalGastosMensaisDTO dto : list) {
			dto.setValorDespesasFixas(despesaDAO.pesquisarDespesasFixasMesAno(dto.getMes(), dto.getAno()));
		}
		return list;
	}

	@Override
	public List<RelatorioRendimentoGastosDTO> pesquisarDadosRelatorioRendimentosGastos() {
		//TODO verificar, pois se eu não trazer a primeira lista, ele não traz a segunda.. 
				//a questão é se tiver dados somente em uma lista.
		//TODO trazer ultimos 12 meses
		List<RelatorioRendimentoGastosDTO> list = despesaDAO.pesquisarValorDespesasPorMesRelatorioRendimentos();//TODO fazer ordenação
		for (RelatorioRendimentoGastosDTO dto : list) {
			dto.setDespesas(dto.getDespesas() != null ? dto.getDespesas() : 0D + despesaDAO.pesquisarDespesasFixasMesAno(dto.getMes(), dto.getAno()));
			dto.setRendimentos(rendimentoDAO.pesquisarRendimentosPorMes());
		}
		return list;
	}
	
}
