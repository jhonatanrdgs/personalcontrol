package br.com.jhonatan.dto;

import java.io.Serializable;

public class RelatorioGastosPorMetodoPagamentoDTO implements Serializable {
	
	private static final long serialVersionUID = 8014931709165636561L;
	
	private String metodoPagamento;
	private Double valor;
	
	public RelatorioGastosPorMetodoPagamentoDTO(String metodoPagamento, Double valor) {
		this.metodoPagamento = metodoPagamento;
		this.valor = valor;
	}
	
	public String getMetodoPagamento() {
		return metodoPagamento;
	}
	public void setMetodoPagamento(String metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	

}
