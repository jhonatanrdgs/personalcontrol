package br.com.jhonatan.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.jhonatan.util.NumberUtil;

public class RelatorioDespesaCarroPdfDTO extends BaseDTO {
	
	private final String km;
	private final Date data;
	private final List<ItemDespesaCarroDTO> itensDespesaCarro;
	
	
	public RelatorioDespesaCarroPdfDTO(final String km, final Date data) {
		this.km = km;
		this.data = data;
		this.itensDespesaCarro = new ArrayList<ItemDespesaCarroDTO>();
	}
	public String getKm() {
		return km;
	}
	
	public Date getData() {
		return data;
	}

	public List<ItemDespesaCarroDTO> getItensDespesaCarro() {
		return itensDespesaCarro;
	}
	public Double getValorTotal() {
		Double valorTotal = 0D;
		for (final ItemDespesaCarroDTO dto : itensDespesaCarro) {
			valorTotal += dto.getValorItem();
		}
		return NumberUtil.normalizarDouble(valorTotal, 2);
	}
	
	
	
	

}
