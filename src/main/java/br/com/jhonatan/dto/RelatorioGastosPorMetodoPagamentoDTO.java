package br.com.jhonatan.dto;

import java.io.Serializable;

public class RelatorioGastosPorMetodoPagamentoDTO extends BaseDTO implements Serializable {
	
	private static final long serialVersionUID = 8014931709165636561L;
	
	private Long idMetodoPagamento;
	private String metodoPagamento;
	private Double valor;
	
	public RelatorioGastosPorMetodoPagamentoDTO(Long idMetodoPagamento, String metodoPagamento, Double valor) {
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

	public void adicionarValor(double valor) {
		this.valor += valor;
		
	}
}
