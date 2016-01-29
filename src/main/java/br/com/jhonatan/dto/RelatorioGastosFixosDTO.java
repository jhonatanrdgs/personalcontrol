package br.com.jhonatan.dto;

import java.io.Serializable;

public class RelatorioGastosFixosDTO extends BaseDTO implements Serializable {

	private static final long serialVersionUID = -79530805434613657L;
	
	private String descricao;
	private Double valor;
	
	public RelatorioGastosFixosDTO(String descricao, Double valor) {
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public Double getValor() {
		return valor;
	}

}
