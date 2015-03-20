package br.com.jhonatan.dto;

import java.io.Serializable;

public class RelatorioTotalGastosMensaisDTO implements Serializable {

	private static final long serialVersionUID = -5176624512076395580L;
	
	private int mes;
	private int ano;
	private Double valorDespesasVariaveis;
	private Double valorDespesasFixas;
	
	public RelatorioTotalGastosMensaisDTO(int mes, int ano, Double valorDespesasVariaveis) {
		this.mes = mes;
		this.ano = ano;
		this.valorDespesasVariaveis = valorDespesasVariaveis;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}
	
	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public Double getValorDespesasVariaveis() {
		return valorDespesasVariaveis;
	}

	public void setValorDespesasVariaveis(Double valorDespesasVariaveis) {
		this.valorDespesasVariaveis = valorDespesasVariaveis;
	}

	public Double getValorDespesasFixas() {
		return valorDespesasFixas;
	}

	public void setValorDespesasFixas(Double valorDespesasFixas) {
		this.valorDespesasFixas = valorDespesasFixas;
	}
	
	public Double getValorTotal() {
		return this.valorDespesasFixas + this.valorDespesasVariaveis;
	}

}
