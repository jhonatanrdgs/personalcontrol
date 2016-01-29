package br.com.jhonatan.dto;

public class RelatorioPercentualComprometido12MesesDTO {
	
	private int mes;
	private int ano;
	private Double percentual;
	
	public RelatorioPercentualComprometido12MesesDTO() {}
	
	public RelatorioPercentualComprometido12MesesDTO(int mes, int ano, Double percentual) {
		this.mes = mes;
		this.ano = ano;
		this.percentual = percentual;
	}
	
	public int getMes() {
		return mes;
	}
	
	public int getAno() {
		return ano;
	}
	
	public Double getPercentual() {
		return percentual;
	}
	
}
