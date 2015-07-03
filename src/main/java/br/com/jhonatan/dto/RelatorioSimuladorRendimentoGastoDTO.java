package br.com.jhonatan.dto;

public class RelatorioSimuladorRendimentoGastoDTO {
	
	private int mes;
	private int ano;
	private Double rendimentos;
	private Double despesasNaoSimuladas;
	private Double despesasSimuladas;
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
	public Double getRendimentos() {
		return rendimentos;
	}
	public void setRendimentos(Double rendimentos) {
		this.rendimentos = rendimentos;
	}
	public Double getDespesasNaoSimuladas() {
		return despesasNaoSimuladas;
	}
	public void setDespesasNaoSimuladas(Double despesasNaoSimuladas) {
		this.despesasNaoSimuladas = despesasNaoSimuladas;
	}
	public Double getDespesasSimuladas() {
		return despesasSimuladas;
	}
	public void setDespesasSimuladas(Double despesasSimuladas) {
		this.despesasSimuladas = despesasSimuladas;
	}
	
}
