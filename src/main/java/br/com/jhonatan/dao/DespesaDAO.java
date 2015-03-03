package br.com.jhonatan.dao;

import java.util.Date;
import java.util.List;

import br.com.jhonatan.entidades.Despesa;

public interface DespesaDAO {
	
	public void salvar(Despesa despesa);
	
	public void atualizar(Despesa despesa);
	
	public List<Despesa> pesquisarDespesas(String descricao, Long idCategoria, Long idMetodoPagamento, Date inicio, Date fim);
	
	public Despesa findById(Class<Despesa> classe, Long id);

}
