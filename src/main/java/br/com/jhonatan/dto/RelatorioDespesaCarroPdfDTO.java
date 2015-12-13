package br.com.jhonatan.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.jhonatan.util.NumberUtil;

public class RelatorioDespesaCarroPdfDTO extends BaseDTO {
	
	private String km;
	private Date data;
	private List<ItemDespesaCarroDTO> itensDespesaCarro;
	
	
	public RelatorioDespesaCarroPdfDTO(String km, Date data) {
		this.km = km;
		this.data = data;
		this.itensDespesaCarro = new ArrayList<ItemDespesaCarroDTO>();
	}
	public String getKm() {
		return km;
	}
	public void setKm(String km) {
		this.km = km;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public List<ItemDespesaCarroDTO> getItensDespesaCarro() {
		return itensDespesaCarro;
	}
	public Double getValorTotal() {
		Double valorTotal = 0D;
		for (ItemDespesaCarroDTO dto : itensDespesaCarro) {
			valorTotal += dto.getValorItem();
		}
		return NumberUtil.normalizarDouble(valorTotal, 2);
	}
	
	
	
	

}
