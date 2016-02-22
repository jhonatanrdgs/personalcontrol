package br.com.jhonatan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jhonatan.dao.UsuarioDAO;
import br.com.jhonatan.entidades.Usuario;

@Service
public class UsuarioServiceImp implements UsuarioService {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Override
	public boolean logar(String user, String pw) {
		Usuario usuario = usuarioDAO.pesquisarUsuarioPorLoginSenha(user, pw);
		return usuario != null;
	}

}
