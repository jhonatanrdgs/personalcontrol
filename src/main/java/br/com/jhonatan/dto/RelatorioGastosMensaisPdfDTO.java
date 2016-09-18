package br.com.jhonatan.dto;

public class RelatorioGastosMensaisPdfDTO extends BaseDTO {
	
	private final String nomeDespesa;
	private final Double valorTotalDespesa;
	private final Double valorParcela;
	private final Integer numeroParcela;
	private final Integer totalParcelas;
	private final String nomeCategoria;
	
	public RelatorioGastosMensaisPdfDTO(final String nomeDespesa, final Double valorTotalDespesa, final Double valorParcela,
										final Integer numeroParcela, final Integer totalParcelas, final String nomeCategoria) {
		
		this.nomeDespesa = nomeDespesa;
		this.valorTotalDespesa = valorTotalDespesa;
		this.valorParcela = valorParcela;
		this.numeroParcela = numeroParcela;
		this.totalParcelas = totalParcelas;
		this.nomeCategoria = nomeCategoria;
	}
	
	public String getNomeDespesa() {
		return nomeDespesa;
	}
	
	public Double getValorTotalDespesa() {
		return valorTotalDespesa;
	}
	
	public Double getValorParcela() {
		return valorParcela;
	}
	
	public Integer getNumeroParcela() {
		return numeroParcela;
	}
	
	public Integer getTotalParcelas() {
		return totalParcelas;
	}
	
	public String getNomeCategoria() {
		return nomeCategoria;
	}

}
