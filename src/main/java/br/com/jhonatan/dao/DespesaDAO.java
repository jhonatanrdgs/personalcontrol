package br.com.jhonatan.dao;

import java.util.Date;
import java.util.List;

import br.com.jhonatan.dto.DespesaDTO;
import br.com.jhonatan.dto.RelatorioComprasParceladasDTO;
import br.com.jhonatan.dto.RelatorioGastosFixosDTO;
import br.com.jhonatan.dto.RelatorioGastosVariaveisDTO;
import br.com.jhonatan.entidades.Despesa;

public interface DespesaDAO {
	
	public void salvar(Despesa despesa);
	
	public void atualizar(Despesa despesa);
	
	public List<Despesa> pesquisarDespesas(DespesaDTO despesaDTO);
	
	public Despesa findById(Class<Despesa> classe, Long id);

	public Despesa findByIdFetched(Long id);

	public List<RelatorioComprasParceladasDTO> pesquisarDespesasParceladasPeriodo(Date inicio, Date fim);

	public List<RelatorioGastosFixosDTO> pesquisarDespesasFixas();

	public Double pesquisarValorDespesasPorMes(Date inicio, Date fim);

	public Double pesquisarSomatorioDespesasFixas();

	public List<RelatorioGastosVariaveisDTO> pesquisarDespesasVariaveisPeriodo(Date inicio, Date fim);


}
