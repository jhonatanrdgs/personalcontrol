package br.com.jhonatan.dao;

import org.springframework.stereotype.Repository;

import br.com.jhonatan.entidades.Usuario;

@Repository
public class UsuarioDAOImp extends GenericDAO<Usuario> implements UsuarioDAO {

	private static final long serialVersionUID = -8983966129047575094L;

	@Override
	public Usuario pesquisarUsuarioPorLogin(final String login) {
		return criarQuerySingleResult(Usuario.CONSULTAR_POR_LOGIN, login);
	}

	@Override
	public Usuario pesquisarUsuarioPorLoginSenha(final String user, final String pw) {
		return criarQuerySingleResult(Usuario.CONSULTAR_POR_LOGIN_SENHA, user, pw);
	}
	
	

}
