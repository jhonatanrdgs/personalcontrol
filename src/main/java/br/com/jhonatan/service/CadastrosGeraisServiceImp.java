package br.com.jhonatan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.jhonatan.dao.CategoriaDAO;
import br.com.jhonatan.dao.MetodoPagamentoDAO;
import br.com.jhonatan.dao.RendimentoDAO;
import br.com.jhonatan.entidades.Categoria;
import br.com.jhonatan.entidades.MetodoPagamento;
import br.com.jhonatan.entidades.Rendimento;

@Service
public class CadastrosGeraisServiceImp implements CadastrosGeraisService {
	
	@Autowired
	private CategoriaDAO categoriaDao;
	
	@Autowired
	private MetodoPagamentoDAO metodoPagamentoDao;
	
	@Autowired
	private RendimentoDAO rendimentoDao;

	@Override
	@Transactional
	public void salvarOuAtualizarCategoria(final Categoria categoria) {
		if (categoria.getId() == null) {
			categoriaDao.salvar(categoria);
		} else {
			categoriaDao.atualizar(categoria);
		}
	}

	@Override
	public List<Categoria> pesquisarCategorias(final String descricao, final boolean ativa) {
		return categoriaDao.pesquisarCategorias(descricao, ativa);
	}

	@Override
	public Categoria pesquisarPorId(final Long id) {
		return categoriaDao.findById(Categoria.class, id);
	}

	@Override
	public List<Categoria> pesquisarTodasCategoriasAtivas() {
		return categoriaDao.pesquisarTodasCategoriasAtivas();
	}
	
	@Override
	@Transactional
	public void salvarOuAtualizarMetodoPagamento(final MetodoPagamento metodoPagamento) {
		if (metodoPagamento.getId() == null) {
			metodoPagamentoDao.salvar(metodoPagamento);
		} else {
			metodoPagamentoDao.atualizar(metodoPagamento);
		}
	}

	@Override
	public List<MetodoPagamento> pesquisarMetodosPagamento(final String descricao, final boolean ativo) {
		return metodoPagamentoDao.pesquisarMetodosPagamento(descricao, ativo);
	}

	@Override
	public MetodoPagamento findById(final Long id) {
		return metodoPagamentoDao.findById(MetodoPagamento.class, id);
	}

	@Override
	public List<MetodoPagamento> pesquisarTodosMetodosPagamentoAtivos() {
		return metodoPagamentoDao.pesquisarTodosMetodosPagamentoAtivos();
	}

	@Override
	@Transactional
	public void salvarOuAtualizarRendimento(final Rendimento rendimento) {
		if (rendimento.getId() == null) {
			rendimentoDao.salvar(rendimento);
		} else {
			rendimentoDao.atualizar(rendimento);
		}
	}

	@Override
	public Rendimento findRendimentoById(final Long id) {
		return rendimentoDao.findById(Rendimento.class, id);
	}

	@Override
	public List<Rendimento> pesquisarRendimentos(final String nomePessoa) {
		return rendimentoDao.pesquisarRendimentosPorPessoa(nomePessoa);
	}

	@Override
	@Transactional
	public void excluirCategoria(final Long id) {
		final Categoria categoria = categoriaDao.findById(Categoria.class, id);
		categoria.setAtivo(false);
		categoriaDao.atualizar(categoria);
	}

	@Override
	@Transactional
	public void ativarCategoria(final Long id) {
		final Categoria categoria = categoriaDao.findById(Categoria.class, id);
		categoria.setAtivo(true);
		categoriaDao.atualizar(categoria);
	}

	@Override
	@Transactional
	public void excluirRendimento(final Long id) {
		final Rendimento rendimento = rendimentoDao.findById(Rendimento.class, id);
		rendimentoDao.excluir(rendimento);
	}

	@Override
	@Transactional
	public void excluirMetodoPagamento(final Long id) {
		final MetodoPagamento metodoPagamento = metodoPagamentoDao.findById(MetodoPagamento.class, id);
		metodoPagamento.setAtivo(false);
		metodoPagamentoDao.atualizar(metodoPagamento);
	}

	@Override
	@Transactional
	public void ativarMetodoPagamento(final Long id) {
		final MetodoPagamento metodoPagamento = metodoPagamentoDao.findById(MetodoPagamento.class, id);
		metodoPagamento.setAtivo(true);
		metodoPagamentoDao.atualizar(metodoPagamento);
	}
	
}
