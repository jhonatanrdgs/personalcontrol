package br.com.jhonatan.entidades;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "usuario", schema = "personal_control")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 129310144023328222L;

	@Id
	@GeneratedValue(generator="usuario_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="usuario_seq", sequenceName="usuario_id_usuario_seq", schema="personal_control")
	@Column(name = "id_usuario", unique = true, nullable = false, columnDefinition="bigserial")
	private Long id;
	
	@Column(name = "nome_usuario", nullable = false, length = 100)
	private String nomeUsuario;
	
	@Column(name = "login", nullable = false, length = 100)
	private String login;
	
	@Column(name = "senha", nullable = false, length = 500)
	private String senha;
	
	@Column(name = "ativo", nullable = false)
	private boolean ativo;
	
	@Column(name = "permissao", nullable = false)
	private Long permissao;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	private Set<Despesa> despesas;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuario_grupo", schema = "personal_control", 
		joinColumns = { 
			@JoinColumn(name = "id_usuario", nullable = false, updatable = false, columnDefinition="int") 
		}, 
		inverseJoinColumns = { 
			@JoinColumn(name = "id_grupo", nullable = false, updatable = false, columnDefinition="int") 
		})
	private Set<Grupo> grupos;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	private Set<Rendimento> rendimentos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Long getPermissao() {
		return permissao;
	}

	public void setPermissao(Long permissao) {
		this.permissao = permissao;
	}

	public Set<Despesa> getDespesas() {
		return despesas;
	}

	public void setDespesas(Set<Despesa> despesas) {
		this.despesas = despesas;
	}

	public Set<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(Set<Grupo> grupos) {
		this.grupos = grupos;
	}

	public Set<Rendimento> getRendimentos() {
		return rendimentos;
	}

	public void setRendimentos(Set<Rendimento> rendimentos) {
		this.rendimentos = rendimentos;
	}

}
