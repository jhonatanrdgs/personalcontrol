package br.com.jhonatan.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.jhonatan.dto.DespesaDTO;
import br.com.jhonatan.dto.RelatorioComprasNaoParceladasDTO;
import br.com.jhonatan.dto.RelatorioComprasParceladasDTO;
import br.com.jhonatan.dto.RelatorioGastosFixosDTO;
import br.com.jhonatan.dto.RelatorioGastosMensaisPdfDTO;
import br.com.jhonatan.entidades.Despesa;

@Repository
public class DespesaDAOImp extends GenericDAO<Despesa> implements DespesaDAO {

	private static final long serialVersionUID = -4115300805764206936L;

	@Override
	public List<Despesa> pesquisarDespesas(DespesaDTO despesaDTO) {
		return criarQueryResultList(Despesa.CONSULTAR_DESPESAS_POR_DESCRICAO_CATEGORIA_METODOPG_DATA,
				despesaDTO.getDescricao(), despesaDTO.getCategoriaId(), despesaDTO.getMetodoPagamentoId(), 
				despesaDTO.getInicioFormatado(), despesaDTO.getFimFormatado());
	}
	
	public Despesa findByIdFetched(Long id) {
		return criarQuerySingleResult(Despesa.CONSULTAR_DESPESA_POR_ID_FETCH, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RelatorioComprasParceladasDTO> pesquisarDespesasParceladasMes(int mes, int ano) {
		return (List<RelatorioComprasParceladasDTO>) criarQueryResultListDTO(Despesa.CONSULTAR_DESPESAS_PARCELADAS_MES, mes, ano);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RelatorioComprasNaoParceladasDTO> pesquisarDespesasVariaveisMes(int mes, int ano) {
		return (List<RelatorioComprasNaoParceladasDTO>) criarQueryResultListDTO(Despesa.CONSULTAR_DESPESAS_VARIAVEIS_MES, mes, ano);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RelatorioGastosFixosDTO> pesquisarDespesasFixas() {
		return (List<RelatorioGastosFixosDTO>) criarQueryResultListDTO(Despesa.CONSULTAR_GASTOS_FIXOS);
	}

	@Override
	public Double pesquisarValorTotalDespesasVariaveisMes(int mes, int ano) {
		return criarQuerySingleResultSomatorio(Despesa.CONSULTAR_VALOR_TOTAL_DESPESAS_VARIAVEIS_MES, mes, ano);
	}
	
	@Override
	public Double pesquisarSomatorioDespesasFixas() {
		return criarQuerySingleResultSomatorio(Despesa.CONSULTAR_SOMATORIO_DESPESAS_FIXAS);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RelatorioGastosMensaisPdfDTO> pesquisarDespesasPeriodoRelatorioPDF(Date inicio, Date fim) {
		return (List<RelatorioGastosMensaisPdfDTO>) criarQueryResultListDTO(Despesa.CONSULTAR_DESPESAS_VARIAVEIS_PERIODO_RELATORIO_PDF, inicio, fim);
	}

	@Override
	public List<Despesa> pesquisarDespesasComParcelasProximoMesEmDiante(Date proximoMes) {
		return criarQueryResultList(Despesa.CONSULTAR_DESPESAS_COM_PARCELAS_PROXIMO_MES_EM_DIANTE, proximoMes);
	}

	@Override
	public Double pesquisarDespessasFixasPorMetodoPagamento(Long idMetodoPagamento) {
		return criarQuerySingleResultSomatorio(Despesa.CONSULTAR_DESPESAS_FIXAS_POR_METODO_PAGAMENTO, idMetodoPagamento);
	}
	
}
