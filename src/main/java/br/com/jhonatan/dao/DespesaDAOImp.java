package br.com.jhonatan.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.jhonatan.dto.RelatorioComprasNaoParceladasDTO;
import br.com.jhonatan.dto.RelatorioComprasParceladasDTO;
import br.com.jhonatan.dto.RelatorioDespesaPorCategoriaDTO;
import br.com.jhonatan.dto.RelatorioGastosFixosDTO;
import br.com.jhonatan.dto.RelatorioGastosMensaisPdfDTO;
import br.com.jhonatan.dto.RelatorioGastosPorMetodoPagamentoDTO;
import br.com.jhonatan.entidades.Despesa;

@Repository
public class DespesaDAOImp extends GenericDAO<Despesa> implements DespesaDAO {

	private static final long serialVersionUID = -4115300805764206936L;

	@Override
	public List<Despesa> pesquisarDespesas(final Despesa despesa) {
		return criarQueryResultList(Despesa.CONSULTAR_DESPESAS_POR_DESCRICAO_CATEGORIA_METODOPG_DATA,
				despesa.getDescricao(), despesa.getCategoria().getId(), despesa.getMetodoPagamento().getId(), 
				despesa.getInicioFormatado(), despesa.getFimFormatado());
	}
	
	@Override
	public List<Despesa> pesquisarUltimasDespesas(final Despesa despesa) {
		return criarQueryResultListWithLimit(Despesa.CONSULTAR_DESPESAS_POR_DESCRICAO_CATEGORIA_METODOPG_DATA_ULTIMAS, 10,
				despesa.getDescricao(), despesa.getCategoria().getId(), despesa.getMetodoPagamento().getId(), 
				despesa.getInicioFormatado(), despesa.getFimFormatado());
	}

	public Despesa findByIdFetched(final Long id) {
		return criarQuerySingleResult(Despesa.CONSULTAR_DESPESA_POR_ID_FETCH, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RelatorioComprasParceladasDTO> pesquisarDespesasParceladasMes(final int mes, final int ano) {
		return (List<RelatorioComprasParceladasDTO>) criarQueryResultListDTO(Despesa.CONSULTAR_DESPESAS_PARCELADAS_MES, mes, ano);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RelatorioComprasNaoParceladasDTO> pesquisarDespesasVariaveisMes(final int mes, final int ano) {
		return (List<RelatorioComprasNaoParceladasDTO>) criarQueryResultListDTO(Despesa.CONSULTAR_DESPESAS_VARIAVEIS_MES, mes, ano);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RelatorioGastosFixosDTO> pesquisarDespesasFixas() {
		return (List<RelatorioGastosFixosDTO>) criarQueryResultListDTO(Despesa.CONSULTAR_GASTOS_FIXOS);
	}

	@Override
	public Double pesquisarValorTotalDespesasVariaveisMes(final int mes, final int ano) {
		return criarQuerySingleResultSomatorio(Despesa.CONSULTAR_VALOR_TOTAL_DESPESAS_VARIAVEIS_MES, mes, ano);
	}
	
	@Override
	public Double pesquisarSomatorioDespesasFixas() {
		return criarQuerySingleResultSomatorio(Despesa.CONSULTAR_SOMATORIO_DESPESAS_FIXAS);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RelatorioGastosMensaisPdfDTO> pesquisarDespesasPeriodoRelatorioPDF(final Date inicio, final Date fim) {
		return (List<RelatorioGastosMensaisPdfDTO>) criarQueryResultListDTO(Despesa.CONSULTAR_DESPESAS_VARIAVEIS_PERIODO_RELATORIO_PDF, inicio, fim);
	}

	@Override
	public List<Despesa> pesquisarDespesasComParcelasProximoMesEmDiante(final Date proximoMes) {
		return criarQueryResultList(Despesa.CONSULTAR_DESPESAS_COM_PARCELAS_PROXIMO_MES_EM_DIANTE, proximoMes);
	}

	@Override
	public Double pesquisarDespessasFixasPorMetodoPagamento(final Long idMetodoPagamento) {
		return criarQuerySingleResultSomatorio(Despesa.CONSULTAR_DESPESAS_FIXAS_POR_METODO_PAGAMENTO, idMetodoPagamento);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<RelatorioDespesaPorCategoriaDTO> pesquisarDespesasPorCategoriasAtivas(final int mes, final int ano) {
		return (List<RelatorioDespesaPorCategoriaDTO>) criarQueryResultListDTO(Despesa.CONSULTAR_DESPESAS_POR_CATEGORIAS_ATIVAS, mes, ano);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RelatorioGastosPorMetodoPagamentoDTO> pesquisarDespesasPorMetodoPagamentoAtivo(final int mes, final int ano) {
		return (List<RelatorioGastosPorMetodoPagamentoDTO>) criarQueryResultListDTO(Despesa.CONSULTAR_DESPESAS_POR_METODO_PAGAMENTO_ATIVO, mes, ano);
	}
	
}
