package br.com.jhonatan.dto;

public class RelatorioDespesaPorCategoriaDTO {
	
	public RelatorioDespesaPorCategoriaDTO() {
		
	}
	
	public RelatorioDespesaPorCategoriaDTO(String categoria, Double valorTotal) {
		this.categoria = categoria;
		this.valorTotal = valorTotal;
	}
	
	private String categoria;
	private Double valorTotal;
	
	
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
}
