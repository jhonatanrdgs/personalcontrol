package br.com.jhonatan.dto;

public class ItemDespesaCarroDTO extends BaseDTO {
	
	private String descricao;
	private Double valorItem;
	
	public ItemDespesaCarroDTO(String descricao, Double valorItem) {
		this.descricao = descricao;
		this.valorItem = valorItem;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getValorItem() {
		return valorItem;
	}
	public void setValorItem(Double valorItem) {
		this.valorItem = valorItem;
	}
	
	

}
