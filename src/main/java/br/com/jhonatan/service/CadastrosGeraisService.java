package br.com.jhonatan.service;

import java.util.List;

import br.com.jhonatan.entidades.Categoria;
import br.com.jhonatan.entidades.MetodoPagamento;
import br.com.jhonatan.entidades.Rendimento;

interface CadastrosGeraisService {
	
	/**
	 * Salva ou atualiza uma categoria no banco de dados
	 * @param categoria - categoria a ser salva/atualizada
	 */
	void salvarOuAtualizarCategoria(Categoria categoria);

	/**
	 * Pesquisa as categorias por sua descrição ou ativo/inativo
	 * @param descricao - descrição da categoria a ser pesquisada
	 * @param ativa - se a situação da categoria é ativa ou inativa
	 * @return - lista de categorias retornadas de acordo com os parametros
	 */
	List<Categoria> pesquisarCategorias(String descricao, boolean ativa);

	/**
	 * Busca uma categoria por id
	 * @param id - id da categoria
	 * @return - categoria ou null caso nao encontre
	 */
	Categoria pesquisarPorId(Long id);

	/**
	 * Pesquisa todas as categorias ativas no banco de dados
	 * @return - lista de categorias ativas
	 */
	List<Categoria> pesquisarTodasCategoriasAtivas();
	
	/**
	 * Salva ou atualiza um método de pagamento no banco de dados
	 * @param metodoPagamento - método de pagamento a ser salvo/atualizado
	 */
	void salvarOuAtualizarMetodoPagamento(MetodoPagamento metodoPagamento);
	
	/**
	 * Pesquisa os métodos de pagamento por sua descrição ou ativo/inativo
	 * @param descricao - descrição do método de pagamento a ser pesquisado
	 * @param ativo - se a situação do método de pagamento é ativa ou inativa
	 * @return - lista de método de pagamento retornados de acordo com os parametros
	 */
	List<MetodoPagamento> pesquisarMetodosPagamento(String descricao, boolean ativo);
	
	/**
	 * Busca um método de pagamento por id
	 * @param id - id do método de pagamento
	 * @return - método de pagamento ou null caso nao encontre
	 */
	MetodoPagamento findById(Long id);

	/**
	 * Busca todos os métodos de pagamento ativos
	 * @return - lista de métodos de pagamento ativos
	 */
	List<MetodoPagamento> pesquisarTodosMetodosPagamentoAtivos();

	/**
	 * Salva ou atualiza um rendimento no banco de dados
	 * @param rendimento - rendimento a ser salvo/atualizado
	 */
	void salvarOuAtualizarRendimento(Rendimento rendimento);

	/**
	 * Busca o rendimento pelo id
	 * @param id - id do rendimento
	 * @return rendimento ou null caso nao encontre
	 */
	Rendimento findRendimentoById(Long id);

	/**
	 * Pesquisa os rendimentos de uma determinada pessoa
	 * @param nomePessoa - nome da pessoa
	 * @return - lista de rendimentos daquela pessoa
	 */
	List<Rendimento> pesquisarRendimentos(String nomePessoa);

	/**
	 * Exclui (inativa) uma categoria no banco de dados
	 * @param id - id da categoria a ser excluído/inativado
	 */
	void excluirCategoria(Long id);

	/**
	 * Ativa uma categoria no banco de dados
	 * @param id - id da categoria a ser ativada
	 */
	void ativarCategoria(Long id);

	/**
	 * Exclui um rendimento do banco de dados
	 * @param id - id do rendimento a ser excluído
	 */
	void excluirRendimento(Long id);

	/**
	 * Exclui (inativa) um método de pagamento do banco de dados
	 * @param id - id do método de pagamento a ser excluido/inativado
	 */
	void excluirMetodoPagamento(Long id);

	/**
	 * Ativa um método de pagamento no banco de dados
	 * @param id - id do método de pagamento a ser atualizado
	 */
	void ativarMetodoPagamento(Long id);

}
