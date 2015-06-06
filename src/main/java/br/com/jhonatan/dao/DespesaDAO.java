package br.com.jhonatan.dao;

import java.util.Date;
import java.util.List;

import br.com.jhonatan.dto.DespesaDTO;
import br.com.jhonatan.dto.RelatorioComprasNaoParceladasDTO;
import br.com.jhonatan.dto.RelatorioComprasParceladasDTO;
import br.com.jhonatan.dto.RelatorioGastosFixosDTO;
import br.com.jhonatan.dto.RelatorioGastosMensaisPdfDTO;
import br.com.jhonatan.entidades.Despesa;

public interface DespesaDAO {
	
	public void salvar(Despesa despesa);
	
	public void atualizar(Despesa despesa);
	
	public List<Despesa> pesquisarDespesas(DespesaDTO despesaDTO);
	
	public Despesa findById(Class<Despesa> classe, Long id);

	public Despesa findByIdFetched(Long id);

	public List<RelatorioComprasParceladasDTO> pesquisarDespesasParceladasPeriodo(Date inicio, Date fim);

	public List<RelatorioGastosFixosDTO> pesquisarDespesasFixas();

	public Double pesquisarValorTotalDespesasVariaveisPeriodo(Date inicio, Date fim);

	public Double pesquisarSomatorioDespesasFixas();

	public List<RelatorioComprasNaoParceladasDTO> pesquisarDespesasVariaveisPeriodo(Date inicio, Date fim);

	public void excluir(Despesa despesa);

	public List<RelatorioGastosMensaisPdfDTO> pesquisarDespesasPeriodoRelatorioPDF(Date inicio, Date fim);

}
