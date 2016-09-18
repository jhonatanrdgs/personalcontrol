package br.com.jhonatan.dto;

public class FormRelatorioDTO extends BaseDTO {
	
	private Integer mes;
	private Integer ano;

	public Integer getMes() {
		return mes;
	}

	public void setMes(final Integer mes) {
		this.mes = mes;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(final Integer ano) {
		this.ano = ano;
	}
	
	
}
