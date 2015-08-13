package br.com.jhonatan.dto;

public class RelatorioBarraSimuladorRendimentoGastoDTO {
	
	private Double percentualSemSimulacao;
	private Double percentualComSimulacao;
	private int mes;
	private int ano;
	
	public Double getPercentualSemSimulacao() {
		return percentualSemSimulacao;
	}
	public void setPercentualSemSimulacao(Double percentualSemSimulacao) {
		this.percentualSemSimulacao = percentualSemSimulacao;
	}
	public Double getPercentualComSimulacao() {
		return percentualComSimulacao;
	}
	public void setPercentualComSimulacao(Double percentualComSimulacao) {
		this.percentualComSimulacao = percentualComSimulacao;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	
}
