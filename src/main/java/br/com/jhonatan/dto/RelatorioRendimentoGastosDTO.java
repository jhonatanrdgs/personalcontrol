package br.com.jhonatan.dto;

import java.io.Serializable;

public class RelatorioRendimentoGastosDTO extends BaseDTO implements Serializable, Comparable<RelatorioRendimentoGastosDTO> {
	
	private static final long serialVersionUID = 8764665624238789280L;
	
	private int mes;
	private int ano;
	private Double rendimentos;
	private Double despesas;
	
	public RelatorioRendimentoGastosDTO() {}
	
	public RelatorioRendimentoGastosDTO(int mes, int ano, Double despesas) {
		this.mes = mes;
		this.ano = ano;
		this.despesas = despesas;
	}
	
	public RelatorioRendimentoGastosDTO(int mes, int ano, Double despesas, Double rendimentos) {
		this.mes = mes;
		this.ano = ano;
		this.despesas = despesas;
		this.rendimentos = rendimentos;
	}

	public int getMes() {
		return mes;
	}

	public int getAno() {
		return ano;
	}

	public Double getRendimentos() {
		return rendimentos;
	}

	public Double getDespesas() {
		return despesas;
	}

	@Override
	public int compareTo(RelatorioRendimentoGastosDTO o) {
		if (this.ano == o.getAno()) {
			return ((Integer)this.mes).compareTo(o.getMes());
		} else {
			return ((Integer)this.ano).compareTo(o.getAno());
		}
	}
	
}
