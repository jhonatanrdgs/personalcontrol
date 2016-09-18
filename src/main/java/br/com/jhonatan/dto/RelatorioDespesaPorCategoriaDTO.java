package br.com.jhonatan.dto;

public class RelatorioDespesaPorCategoriaDTO extends BaseDTO {
	
	public RelatorioDespesaPorCategoriaDTO() {}
	
	public RelatorioDespesaPorCategoriaDTO(final String categoria, final Double valorTotal) {
		this.categoria = categoria;
		this.valorTotal = valorTotal;
	}
	
	private String categoria;
	private Double valorTotal;
	
	public String getCategoria() {
		return categoria;
	}

	public Double getValorTotal() {
		return valorTotal;
	}
}
