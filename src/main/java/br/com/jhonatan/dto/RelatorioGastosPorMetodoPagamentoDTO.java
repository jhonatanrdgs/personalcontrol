package br.com.jhonatan.dto;

import java.io.Serializable;

public class RelatorioGastosPorMetodoPagamentoDTO extends BaseDTO implements Serializable {
	
	private static final long serialVersionUID = 8014931709165636561L;
	
	private final Long idMetodoPagamento;
	private final String metodoPagamento;
	private Double valor;
	
	public RelatorioGastosPorMetodoPagamentoDTO(final Long idMetodoPagamento, final String metodoPagamento, final Double valor) {
		this.idMetodoPagamento = idMetodoPagamento;
		this.metodoPagamento = metodoPagamento;
		this.valor = valor;
	}
	
	public String getMetodoPagamento() {
		return metodoPagamento;
	}

	public Double getValor() {
		return valor;
	}

	public Long getIdMetodoPagamento() {
		return idMetodoPagamento;
	}

	public void adicionarValor(final double valor) {
		this.valor += valor;
		
	}
}
