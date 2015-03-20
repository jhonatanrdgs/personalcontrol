package br.com.jhonatan.dto;

import java.io.Serializable;

public class RelatorioRendimentoGastosDTO implements Serializable {
	
	private static final long serialVersionUID = 8764665624238789280L;
	
	private int mes;
	private int ano;
	private Double rendimentos;
	private Double despesas;
	
	public RelatorioRendimentoGastosDTO(int mes, int ano, Double despesas) {
		this.mes = mes;
		this.ano = ano;
		this.despesas = despesas;
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

	public Double getRendimentos() {
		return rendimentos;//TODO if null, retorna 0, olhar outros relatorios e tbm Service
	}

	public void setRendimentos(Double rendimentos) {
		this.rendimentos = rendimentos;
	}

	public Double getDespesas() {
		return despesas;
	}

	public void setDespesas(Double despesas) {
		this.despesas = despesas;
	}
	
}
