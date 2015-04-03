package br.com.jhonatan.service;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

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
		despesaCarro.setUsuario(usuarioDAO.pesquisarUsuarioPorLogin(SecurityContextHolder.getContext().getAuthentication().getName()));
		
		if (despesaCarro.getId() == null) {
			despesaCarro.setParcelas(despesaService.montarListaParcelas(despesaCarro));//TODO melhorar isso, passar para aspecto (proxy)
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
