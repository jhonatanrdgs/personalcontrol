package br.com.jhonatan.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	public void setItensDespesaCarro(List<ItemDespesaCarroDTO> itensDespesaCarro) {
		this.itensDespesaCarro = itensDespesaCarro;
	}
	
	

}
