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
	public void salvarOuAtualizarCategoria(Categoria categoria) {
		if (categoria.getId() == null) {
			categoriaDao.salvar(categoria);
		} else {
			categoriaDao.atualizar(categoria);
		}
	}

	@Override
	public List<Categoria> pesquisarCategorias(String descricao, boolean ativa) {
		return categoriaDao.pesquisarCategorias(descricao, ativa);
	}

	@Override
	public Categoria pesquisarPorId(Long id) {
		return categoriaDao.findById(Categoria.class, id);
	}

	@Override
	public List<Categoria> pesquisarTodasCategoriasAtivas() {
		return categoriaDao.pesquisarTodasCategoriasAtivas();
	}
	
	@Override
	public void salvarOuAtualizarMetodoPagamento(MetodoPagamento metodoPagamento) {
		if (metodoPagamento.getId() == null) {
			metodoPagamentoDao.salvar(metodoPagamento);
		} else {
			metodoPagamentoDao.atualizar(metodoPagamento);
		}

	}

	@Override
	public List<MetodoPagamento> pesquisarMetodosPagamento(String descricao, boolean ativo) {
		return metodoPagamentoDao.pesquisarMetodosPagamento(descricao, ativo);
	}

	@Override
	public MetodoPagamento findById(Long id) {
		return metodoPagamentoDao.findById(MetodoPagamento.class, id);
	}

	@Override
	public List<MetodoPagamento> pesquisarTodosMetodosPagamentoAtivos() {
		return metodoPagamentoDao.pesquisarTodosMetodosPagamentoAtivos();
	}

	@Override
	public void salvarOuAtualizarRendimento(Rendimento rendimento) {
		if (rendimento.getId() == null) {
			rendimentoDao.salvar(rendimento);
		} else {
			rendimentoDao.atualizar(rendimento);
		}
		
	}

	@Override
	public Rendimento findRendimentoById(Long id) {
		return rendimentoDao.findById(Rendimento.class, id);
	}

	@Override
	public List<Rendimento> pesquisarRendimentos(String nomePessoa) {
		return rendimentoDao.pesquisarRendimentosPorPessoa(nomePessoa);
	}

	@Override
	public void excluirCategoria(Long id) {
		Categoria categoria = categoriaDao.findById(Categoria.class, id);
		categoria.setAtivo(false);
		categoriaDao.atualizar(categoria);
	}

	@Override
	public void ativarCategoria(Long id) {
		Categoria categoria = categoriaDao.findById(Categoria.class, id);
		categoria.setAtivo(true);
		categoriaDao.atualizar(categoria);
	}

	@Override
	@Transactional
	public void excluirRendimento(Long id) {
		Rendimento rendimento = rendimentoDao.findById(Rendimento.class, id);
		rendimentoDao.excluir(rendimento);
	}

	@Override
	public void excluirMetodoPagamento(Long id) {
		MetodoPagamento metodoPagamento = metodoPagamentoDao.findById(MetodoPagamento.class, id);
		metodoPagamento.setAtivo(false);
		metodoPagamentoDao.atualizar(metodoPagamento);
	}

	@Override
	public void ativarMetodoPagamento(Long id) {
		MetodoPagamento metodoPagamento = metodoPagamentoDao.findById(MetodoPagamento.class, id);
		metodoPagamento.setAtivo(true);
		metodoPagamentoDao.atualizar(metodoPagamento);
	}
	
	
	
}
