package br.com.jhonatan.dto;

public class RelatorioBarraSimuladorRendimentoGastoDTO {
	
	private final Double percentualSemSimulacao;
	private final Double percentualComSimulacao;
	private final int mes;
	private final int ano;
	
	public RelatorioBarraSimuladorRendimentoGastoDTO(final Double percentualSemSimulacao, final Double percentualComSimulacao,
													 final int mes, final int ano) {
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
