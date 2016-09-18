package br.com.jhonatan.dto;

import java.io.Serializable;

public class RelatorioComprasNaoParceladasDTO extends BaseDTO implements Serializable {

	private static final long serialVersionUID = -79530805434613657L;
	
	private final String descricao;
	private final Double valor;
	
	public RelatorioComprasNaoParceladasDTO(final String descricao, final Double valor) {
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
