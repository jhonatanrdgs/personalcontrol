package br.com.jhonatan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jhonatan.dao.CategoriaDAO;
import br.com.jhonatan.entidades.Categoria;

@Service
public class CategoriaServiceImp implements CategoriaService {
	
	@Autowired
	private CategoriaDAO categoriaDao;

	@Override
	public void salvarOuAtualizar(Categoria categoria) {
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
	
	public CategoriaDAO getCategoriaDao() {
		return categoriaDao;
	}

	public void setCategoriaDao(CategoriaDAO categoriaDao) {
		this.categoriaDao = categoriaDao;
	}
	
	
}
