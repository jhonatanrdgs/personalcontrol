package br.com.jhonatan.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.jhonatan.entidades.MetodoPagamento;

@Repository
public class MetodoPagamentoDAOImp extends GenericDAO<MetodoPagamento> implements MetodoPagamentoDAO {

	private static final long serialVersionUID = 6033640884934226485L;

	@Override
	public List<MetodoPagamento> pesquisarMetodosPagamento(final String descricao, final boolean ativo) {
		return criarQueryResultList(MetodoPagamento.CONSULTAR_METODOS_PAGAMENTO_POR_DESCRICAO, ativo, descricao);
	}

	@Override
	public List<MetodoPagamento> pesquisarTodosMetodosPagamentoAtivos() {
		return criarQueryResultList(MetodoPagamento.CONSULTAR_TODOS_METODOS_PAGAMENTO_ATIVOS);
	}

	

}
