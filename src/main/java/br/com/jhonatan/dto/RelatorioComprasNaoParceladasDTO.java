package br.com.jhonatan.dto;

import java.io.Serializable;

public class RelatorioComprasNaoParceladasDTO extends BaseDTO implements Serializable {

	private static final long serialVersionUID = -79530805434613657L;
	
	private String descricao;
	private Double valor;
	
	public RelatorioComprasNaoParceladasDTO(String descricao, Double valor) {
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	

}
