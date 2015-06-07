package br.com.jhonatan.dto;

public class RelatorioGastosMensaisPdfDTO extends BaseDTO {
	
	private String nomeDespesa;
	private Double valorTotalDespesa;
	private Double valorParcela;
	private Integer numeroParcela;
	private Integer totalParcelas;
	private String nomeCategoria;
	
	public RelatorioGastosMensaisPdfDTO(String nomeDespesa, Double valorTotalDespesa, Double valorParcela, 
			Integer numeroParcela, Integer totalParcelas, String nomeCategoria) {
		
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
	public void setNomeDespesa(String nomeDespesa) {
		this.nomeDespesa = nomeDespesa;
	}
	public Double getValorTotalDespesa() {
		return valorTotalDespesa;
	}
	public void setValorTotalDespesa(Double valorTotalDespesa) {
		this.valorTotalDespesa = valorTotalDespesa;
	}
	public Double getValorParcela() {
		return valorParcela;
	}
	public void setValorParcela(Double valorParcela) {
		this.valorParcela = valorParcela;
	}
	public Integer getNumeroParcela() {
		return numeroParcela;
	}
	public void setNumeroParcela(Integer numeroParcela) {
		this.numeroParcela = numeroParcela;
	}
	public Integer getTotalParcelas() {
		return totalParcelas;
	}
	public void setTotalParcelas(Integer totalParcelas) {
		this.totalParcelas = totalParcelas;
	}
	public String getNomeCategoria() {
		return nomeCategoria;
	}
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

}
