package br.com.jhonatan.entidades;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@NamedQueries({
	
	@NamedQuery(name=Usuario.CONSULTAR_POR_LOGIN, 
			query="from Usuario u where login = ?1"),
	
	@NamedQuery(name=Usuario.CONSULTAR_POR_LOGIN_SENHA,
			query="from Usuario u where login = ?1 and senha = ?2")
	
})

@Entity
@Table(name = "usuario")
public class Usuario extends AbstractBaseEntity implements Serializable {

	private static final long serialVersionUID = 129310144023328222L;

	public static final String CONSULTAR_POR_LOGIN = "usuario.consultarPorLogin";
	public static final String CONSULTAR_POR_LOGIN_SENHA = "usuario.consultarPorLoginSenha";

	@Id
	@GeneratedValue(generator="usuario_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="usuario_seq", sequenceName="usuario_id_usuario_seq", schema="personal_control")
	@Column(name = "id_usuario", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "nome_usuario", nullable = false, length = 100)
	private String nomeUsuario;
	
	@Column(name = "login", nullable = false, length = 100)
	private String login;
	
	@Column(name = "senha", nullable = false, length = 500)
	private String senha;
	
	@Column(name = "ativo", nullable = false)
	private boolean ativo;
	
	@Column(name = "permissao", nullable = false, length=20)
	private String permissao;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	private Set<Despesa> despesas;
	
	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(final String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(final String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(final String senha) {
		this.senha = senha;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(final boolean ativo) {
		this.ativo = ativo;
	}

	public String getPermissao() {
		return permissao;
	}

	public void setPermissao(final String permissao) {
		this.permissao = permissao;
	}

	public Set<Despesa> getDespesas() {
		return despesas;
	}

	public void setDespesas(final Set<Despesa> despesas) {
		this.despesas = despesas;
	}

}
