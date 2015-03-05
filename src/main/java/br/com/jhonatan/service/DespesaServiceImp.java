package br.com.jhonatan.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import br.com.jhonatan.dao.DespesaDAO;
import br.com.jhonatan.dao.UsuarioDAO;
import br.com.jhonatan.entidades.Despesa;
import br.com.jhonatan.entidades.Usuario;

@Service
public class DespesaServiceImp implements DespesaService {
	
	@Autowired
	private DespesaDAO despesaDAO;
	
	@Autowired UsuarioDAO usuarioDAO;

	@Override
	public void salvarOuAtualizar(Despesa despesa) {
		if (despesa.getId() == null) {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			Usuario usuario = usuarioDAO.pesquisarUsuarioPorLogin(authentication.getName());
			despesa.setUsuario(usuario);
			//TODO compras parceladas
			despesaDAO.salvar(despesa);
		} else {
			despesaDAO.atualizar(despesa);
		}
	}


	@Override
	public List<Despesa> pesquisarDespesas(String descricao, Long idCategoria,
			Long idMetodoPagamento, Date inicio, Date fim) {
		return despesaDAO.pesquisarDespesas(descricao, idCategoria, idMetodoPagamento, inicio, fim);
	}

	@Override
	public Despesa findById(Long id) {
		return despesaDAO.findById(Despesa.class, id);
	}

}