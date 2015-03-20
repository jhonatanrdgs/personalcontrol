package br.com.jhonatan.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.jhonatan.dto.RelatorioGastosPorMetodoPagamentoDTO;
import br.com.jhonatan.entidades.MetodoPagamento;

@Repository
public class MetodoPagamentoDAOImp extends GenericDAO<MetodoPagamento> implements MetodoPagamentoDAO {

	private static final long serialVersionUID = 6033640884934226485L;

	@Override
	public List<MetodoPagamento> pesquisarMetodosPagamento(String descricao) {
		return criarQueryResultList(MetodoPagamento.CONSULTAR_METODOS_PAGAMENTO_POR_DESCRICAO, descricao);
	}

	@Override
	public List<MetodoPagamento> pesquisarTodosMetodosPagamentoAtivos() {
		return criarQueryResultList(MetodoPagamento.CONSULTAR_TODOS_METODOS_PAGAMENTO_ATIVOS);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RelatorioGastosPorMetodoPagamentoDTO> pesquisarDespesasPorMetodoPagamentoAtivo(Date inicio, Date fim) {
		return criarQueryResultListSemTipagem(MetodoPagamento.CONSULTAR_DESPESAS_POR_METODO_PAGAMENTO_ATIVO, inicio, fim);
	}
	
	


}
