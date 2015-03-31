package br.com.jhonatan.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jhonatan.dao.DespesaCarroDAO;
import br.com.jhonatan.entidades.DespesaCarro;
import br.com.jhonatan.entidades.ItemDespesaCarro;

@Service
public class DespesaCarroServiceImp implements DespesaCarroService {
	
	@Autowired
	private DespesaCarroDAO despesaCarroDAO;

	@Override
	public List<DespesaCarro> pesquisarDespesasCarro(String descricao) {
		return despesaCarroDAO.pesquisarDespesasCarro(descricao);
	}

	@Override
	public void salvarOuAtualizarDespesasCarro(DespesaCarro despesaCarro, List<ItemDespesaCarro> itens) {
		
		//TODO ver parcelado, ou se posso juntar isso com a despesa
		if (despesaCarro.getId() == null) {
			for (ItemDespesaCarro item : itens) {
				item.setDespesaCarro(despesaCarro);
			}
			if (despesaCarro.getItemDespesaCarros() == null) {
				despesaCarro.setItemDespesaCarros(new HashSet<ItemDespesaCarro>());
			}
			despesaCarro.getItemDespesaCarros().addAll(itens);
			despesaCarroDAO.salvar(despesaCarro);
		} else {
			//TODO itens no atualizar
			despesaCarroDAO.atualizar(despesaCarro);
		}
		
	}

	@Override
	public DespesaCarro findDespesasCarroById(Long id) {
		return despesaCarroDAO.findById(DespesaCarro.class, id);
	}
	
	

}
