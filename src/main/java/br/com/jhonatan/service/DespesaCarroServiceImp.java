package br.com.jhonatan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jhonatan.dao.DespesaCarroDAO;
import br.com.jhonatan.entidades.DespesaCarro;

@Service
public class DespesaCarroServiceImp implements DespesaCarroService {
	
	@Autowired
	private DespesaCarroDAO despesaCarroDAO;

	@Override
	public List<DespesaCarro> pesquisarDespesasCarro(String descricao) {
		return despesaCarroDAO.pesquisarDespesasCarro(descricao);
	}

	@Override
	public void salvarOuAtualizarDespesasCarro(DespesaCarro despesaCarro) {
		//TODO ver parcelado, ou se posso juntar isso com a despesa
		if (despesaCarro.getId() == null) {
			despesaCarroDAO.salvar(despesaCarro);
		} else {
			despesaCarroDAO.atualizar(despesaCarro);
		}
		
	}

	@Override
	public DespesaCarro findDespesasCarroById(Long id) {
		return despesaCarroDAO.findById(DespesaCarro.class, id);
	}
	
	

}
