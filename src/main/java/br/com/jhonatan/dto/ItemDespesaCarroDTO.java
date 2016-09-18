package br.com.jhonatan.dto;

public class ItemDespesaCarroDTO extends BaseDTO {
	
	private String descricao;
	private Double valorItem;
	
	public ItemDespesaCarroDTO(final String descricao, final Double valorItem) {
		this.descricao = descricao;
		this.valorItem = valorItem;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(final String descricao) {
		this.descricao = descricao;
	}
	public Double getValorItem() {
		return valorItem;
	}
	public void setValorItem(final Double valorItem) {
		this.valorItem = valorItem;
	}
	
	

}
