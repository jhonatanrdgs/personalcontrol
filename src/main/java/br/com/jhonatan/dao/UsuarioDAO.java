package br.com.jhonatan.dao;

import br.com.jhonatan.entidades.Usuario;

public interface UsuarioDAO {

	Usuario pesquisarUsuarioPorLogin(String login);

}
