package br.com.jhonatan.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.jhonatan.dao.DespesaCarroDAO;
import br.com.jhonatan.dao.UsuarioDAO;
import br.com.jhonatan.dto.DespesaDTO;
import br.com.jhonatan.entidades.DespesaCarro;
import br.com.jhonatan.entidades.ItemDespesaCarro;

@Service
public class DespesaCarroServiceImp implements DespesaCarroService {
	
	@Autowired
	private DespesaCarroDAO despesaCarroDAO;
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private DespesaService despesaService;

	@Override
	public List<DespesaCarro> pesquisarDespesasCarro(DespesaDTO despesaCarro) {
		return despesaCarroDAO.pesquisarDespesasCarro(despesaCarro);
	}

	@Override
	public void salvarOuAtualizarDespesasCarro(DespesaCarro despesaCarro, List<ItemDespesaCarro> itens) {
		if (despesaCarro.getId() == null) {
			for (ItemDespesaCarro item : itens) {
				item.setDespesaCarro(despesaCarro);
			}
			if (despesaCarro.getItemDespesaCarros() == null) {
				despesaCarro.setItemDespesaCarros(new ArrayList<ItemDespesaCarro>());
			}
			despesaCarro.getItemDespesaCarros().addAll(itens);
			despesaCarroDAO.salvar(despesaCarro);
		} else {
			despesaCarroDAO.atualizar(despesaCarro);
		}
		
	}

	@Override
	public DespesaCarro findDespesasCarroById(Long id) {
		return despesaCarroDAO.findById(DespesaCarro.class, id);
	}

	@Override
	@Transactional
	public void excluir(Long id) {
		DespesaCarro despesaCarro = despesaCarroDAO.findById(DespesaCarro.class, id);
		despesaCarroDAO.excluir(despesaCarro);
	}
	

}
