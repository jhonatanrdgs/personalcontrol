package br.com.jhonatan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.jhonatan.dao.DespesaCarroDAO;
import br.com.jhonatan.entidades.DespesaCarro;
import br.com.jhonatan.entidades.ItemDespesaCarro;

@Service
public class DespesaCarroServiceImp implements DespesaCarroService {
	
	@Autowired
	private DespesaCarroDAO despesaCarroDAO;
	
	@Override
	public List<DespesaCarro> pesquisarDespesasCarro(DespesaCarro despesaCarro) {
		return despesaCarroDAO.pesquisarDespesasCarro(despesaCarro);
	}

	@Override
	@Transactional
	public void salvarOuAtualizarDespesasCarro(DespesaCarro despesaCarro, List<ItemDespesaCarro> itens) {
		despesaCarro.getItemDespesaCarros().addAll(itens);
		if (despesaCarro.getId() == null) {
			despesaCarroDAO.salvar(despesaCarro);
		} else {
			despesaCarroDAO.atualizar(despesaCarro);
		}
	}

	@Override
	public DespesaCarro findDespesasCarroById(Long id) {
		return despesaCarroDAO.findByIdFetched(id);
	}

	@Override
	@Transactional
	public void excluir(Long id) {
		DespesaCarro despesaCarro = despesaCarroDAO.findById(DespesaCarro.class, id);
		despesaCarroDAO.excluir(despesaCarro);
	}
	

}
