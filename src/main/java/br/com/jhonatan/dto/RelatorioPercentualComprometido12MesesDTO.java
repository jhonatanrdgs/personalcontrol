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
	
	public void setMes(int mes) {
		this.mes = mes;
	}
	
	public int getAno() {
		return ano;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public Double getPercentual() {
		return percentual;
	}
	
	public void setPercentual(Double percentual) {
		this.percentual = percentual;
	}
	
	

}
