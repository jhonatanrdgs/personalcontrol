package br.com.jhonatan.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.jhonatan.dto.DespesaDTO;
import br.com.jhonatan.entidades.DespesaCarro;

@Repository
public class DespesaCarroDAOImp extends GenericDAO<DespesaCarro> implements DespesaCarroDAO {

	private static final long serialVersionUID = 7148714862726850718L;

	@Override
	public List<DespesaCarro> pesquisarDespesasCarro(DespesaDTO despesaCarro) {
		return criarQueryResultList(DespesaCarro.CONSULTAR_DESPESA_CARRO_POR_DESCRICAO, 
				despesaCarro.getDescricao(), despesaCarro.getCategoriaId(), despesaCarro.getMetodoPagamentoId(),
				despesaCarro.getInicioFormatado(), despesaCarro.getFimFormatado());
	}
	
}
