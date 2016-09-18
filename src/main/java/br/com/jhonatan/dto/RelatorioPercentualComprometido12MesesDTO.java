package br.com.jhonatan.dto;

public class RelatorioPercentualComprometido12MesesDTO {
	
	private int mes;
	private int ano;
	private Double percentual;
	
	public RelatorioPercentualComprometido12MesesDTO() {}
	
	public RelatorioPercentualComprometido12MesesDTO(final int mes, final int ano, final Double percentual) {
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
