package br.com.jhonatan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jhonatan.dao.CategoriaDAO;
import br.com.jhonatan.entidades.Categoria;

@Service
public class CategoriaServiceImpl implements CategoriaService {
	
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

}
