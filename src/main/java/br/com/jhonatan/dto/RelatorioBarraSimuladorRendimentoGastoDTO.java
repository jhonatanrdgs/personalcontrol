package br.com.jhonatan.dto;

public class RelatorioBarraSimuladorRendimentoGastoDTO {
	
	private Double percentualSemSimulacao;
	private Double percentualComSimulacao;
	private int mes;
	private int ano;
	
	public RelatorioBarraSimuladorRendimentoGastoDTO(Double percentualSemSimulacao, Double percentualComSimulacao,
			int mes, int ano) {
		this.percentualSemSimulacao = percentualSemSimulacao;
		this.percentualComSimulacao = percentualComSimulacao;
		this.mes = mes;
		this.ano = ano;
	}
	
	public Double getPercentualSemSimulacao() {
		return percentualSemSimulacao;
	}
	
	public Double getPercentualComSimulacao() {
		return percentualComSimulacao;
	}
	
	public int getMes() {
		return mes;
	}
	
	public int getAno() {
		return ano;
	}
	
}
