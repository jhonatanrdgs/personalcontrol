package br.com.jhonatan.dto;

import java.io.Serializable;

public class RelatorioComprasParceladasDTO extends BaseDTO implements Serializable {
	
	private static final long serialVersionUID = 8792827664179535718L;
	
	private final String descricaoDespesa;
	private final Double valor;
	private Integer nrParcela;
	private Integer totalParcelas;
	
	public RelatorioComprasParceladasDTO(final String descricaoDespesa, final Double valor) {
		this.descricaoDespesa = descricaoDespesa;
		this.valor = valor;
	}
	
	public RelatorioComprasParceladasDTO(final String descricaoDespesa, final Double valor, final Integer nrParcela, final Integer totalParcelas) {
		this.descricaoDespesa = descricaoDespesa;
		this.valor = valor;
		this.nrParcela = nrParcela;
		this.totalParcelas = totalParcelas;
	}
	
	public String getDescricaoDespesa() {
		return descricaoDespesa + " - " + nrParcela + "/"+totalParcelas;
	}
	
	public Double getValor() {
		return valor;
	}

}
