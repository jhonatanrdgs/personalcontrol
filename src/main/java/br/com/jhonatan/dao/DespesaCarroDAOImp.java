package br.com.jhonatan.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.jhonatan.entidades.DespesaCarro;

@Repository
public class DespesaCarroDAOImp extends GenericDAO<DespesaCarro> implements DespesaCarroDAO {

	private static final long serialVersionUID = 7148714862726850718L;

	@Override
	public List<DespesaCarro> pesquisarDespesasCarro(final DespesaCarro despesaCarro) {
		return criarQueryResultList(DespesaCarro.CONSULTAR_DESPESA_CARRO_PERIODO, despesaCarro.getInicioFormatado(), despesaCarro.getFimFormatado());
	}

	@Override
	public List<DespesaCarro> pesquisarDespesasCarroPeriodo() {
		return criarQueryResultList(DespesaCarro.CONSULTAR_TODAS_DESPESAS_CARRO);
	}

	@Override
	public DespesaCarro findByIdFetched(final Long id) {
		return criarQuerySingleResult(DespesaCarro.CONSULTAR_DESPESA_CARRO_POR_ID_FETCHED, id);
	}
	
	

}
