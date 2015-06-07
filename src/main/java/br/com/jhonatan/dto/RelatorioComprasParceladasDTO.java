package br.com.jhonatan.dto;

import java.io.Serializable;

public class RelatorioComprasParceladasDTO extends BaseDTO implements Serializable {
	
	private static final long serialVersionUID = 8792827664179535718L;
	
	private String descricaoDespesa;
	private Double valor;
	
	public RelatorioComprasParceladasDTO(String descricaoDespesa, Double valor) {
		this.descricaoDespesa = descricaoDespesa;
		this.valor = valor;
	}
	
	public String getDescricaoDespesa() {
		return descricaoDespesa;
	}
	public void setDescricaoDespesa(String descricaoDespesa) {
		this.descricaoDespesa = descricaoDespesa;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
	

}
