package br.com.jhonatan.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.jhonatan.entidades.Rendimento;

@Repository
public class RendimentoDAOImp extends GenericDAO<Rendimento> implements RendimentoDAO  {

	private static final long serialVersionUID = -7521216311941883574L;

	@Override
	public Double pesquisarRendimentosPorMes() {
		return criarQuerySingleResultSomatorio(Rendimento.CONSULTAR_RENDIMENTOS);
	}

	@Override
	public List<Rendimento> pesquisarRendimentosPorPessoa(String nomePessoa) {
		return criarQueryResultList(Rendimento.CONSULTAR_RENDIMENTOS_POR_PESSOA, nomePessoa);
	}
	
}
