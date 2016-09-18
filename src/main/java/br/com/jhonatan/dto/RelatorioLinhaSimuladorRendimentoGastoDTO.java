package br.com.jhonatan.dto;

public class RelatorioLinhaSimuladorRendimentoGastoDTO {

	private final int mes;
	private final int ano;
	private final Double rendimentos;
	private final Double despesasNaoSimuladas;
	private final Double despesasSimuladas;

	public RelatorioLinhaSimuladorRendimentoGastoDTO(final Double valorDespesasNaoSimuladas, final Double valorDespesasSimuladas,
													 final Double rendimentos, final int mes, final int ano) {
		despesasNaoSimuladas = valorDespesasNaoSimuladas;
		despesasSimuladas = valorDespesasSimuladas;
		this.rendimentos = rendimentos;
		this.mes = mes;
		this.ano = ano;
	}
	public int getMes() {
		return mes;
	}
	
	public int getAno() {
		return ano;
	}
	
	public Double getRendimentos() {
		return rendimentos;
	}
	
	public Double getDespesasNaoSimuladas() {
		return despesasNaoSimuladas;
	}
	
	public Double getDespesasSimuladas() {
		return despesasSimuladas;
	}
	

}
