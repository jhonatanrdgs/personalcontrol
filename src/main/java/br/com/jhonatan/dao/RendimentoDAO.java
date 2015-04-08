package br.com.jhonatan.dao;

import java.util.List;

import br.com.jhonatan.entidades.Rendimento;


public interface RendimentoDAO {

	Double pesquisarRendimentosPorMes();

	void salvar(Rendimento rendimento);

	void atualizar(Rendimento rendimento);

	Rendimento findById(Class<Rendimento> class1, Long id);

	List<Rendimento> pesquisarRendimentosPorPessoa(String nomePessoa);

	void excluir(Rendimento rendimento);

}
