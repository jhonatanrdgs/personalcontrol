package br.com.jhonatan.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.jhonatan.dto.DespesaDTO;
import br.com.jhonatan.entidades.Despesa;

@Repository
public class DespesaDAOImp extends GenericDAO<Despesa> implements DespesaDAO {

	private static final long serialVersionUID = -4115300805764206936L;

	@Override
	public List<Despesa> pesquisarDespesas(DespesaDTO despesaDTO) {
		return criarQueryResultList(Despesa.CONSULTAR_DESPESAS_POR_DESCRICAO_CATEGORIA_METODOPG_DATA,
				despesaDTO.getDescricao(), despesaDTO.getCategoriaId(), despesaDTO.getMetodoPagamentoId(), despesaDTO.getInicio(), despesaDTO.getFim());
	}
	
	public Despesa findByIdFetched(Long id) {
		return criarQuerySingleResult(Despesa.CONSULTAR_DESPESA_POR_ID_FETCH, id);
	}


}
