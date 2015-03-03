package br.com.jhonatan.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.jhonatan.entidades.Despesa;

@Repository
public class DespesaDAOImp extends GenericDAO<Despesa> implements DespesaDAO {

	private static final long serialVersionUID = -4115300805764206936L;

	@Override
	public List<Despesa> pesquisarDespesas(String descricao, Long idCategoria,
			Long idMetodoPagamento, Date inicio, Date fim) {
		return criarQueryResultList(Despesa.CONSULTAR_DESPESAS_POR_DESCRICAO_CATEGORIA_METODOPG_DATA,
				descricao, idCategoria, idMetodoPagamento, inicio, fim);
	}


}
