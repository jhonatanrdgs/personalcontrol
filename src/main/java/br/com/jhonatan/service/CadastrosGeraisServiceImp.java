package br.com.jhonatan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<Categoria> pesquisarCategorias(String descricao) {
		return categoriaDao.pesquisarCategorias(descricao);
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
	public List<MetodoPagamento> pesquisarMetodosPagamento(String descricao) {
		return metodoPagamentoDao.pesquisarMetodosPagamento(descricao);
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
	

}
