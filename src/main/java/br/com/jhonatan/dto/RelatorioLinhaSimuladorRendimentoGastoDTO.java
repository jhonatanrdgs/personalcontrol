package br.com.jhonatan.dto;

public class RelatorioLinhaSimuladorRendimentoGastoDTO {

	private int mes;
	private int ano;
	private Double rendimentos;
	private Double despesasNaoSimuladas;
	private Double despesasSimuladas;

	public RelatorioLinhaSimuladorRendimentoGastoDTO(Double valorDespesasNaoSimuladas, Double valorDespesasSimuladas,
			Double rendimentos, int mes, int ano) {
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
