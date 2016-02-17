package br.com.jhonatan.dto;

import br.com.jhonatan.util.NumberUtil;

public class RelatorioResumoDTO {

	private Double totalGastosVariaveisPeriodo;
	private Double totalGastosFixos; 
	private Double rendimentos;
	
	public RelatorioResumoDTO(Double totalGastosVariaveisPeriodo, Double totalGastosFixos, Double rendimentos) {
		this.totalGastosVariaveisPeriodo = NumberUtil.zeroIfNull(totalGastosVariaveisPeriodo);
		this.totalGastosFixos = NumberUtil.zeroIfNull(totalGastosFixos);
		this.rendimentos = NumberUtil.zeroIfNull(rendimentos);
	}
	
	public Double getTotalGastos() {
		return NumberUtil.normalizarDouble(totalGastosVariaveisPeriodo + totalGastosFixos, 2);
	}
	
	public Double getTotalGastosVariaveisPeriodo() {
		return NumberUtil.normalizarDouble(totalGastosVariaveisPeriodo, 2);
	}
	
	public Double getTotalGastosFixos() {
		return NumberUtil.normalizarDouble(totalGastosFixos, 2);
	}
	
	public Double getPercentualComprometido() {
		return NumberUtil.normalizarDouble((getTotalGastos() / rendimentos) * 100, 2);
	}
	
	public Double getRendimentos() {
		return NumberUtil.normalizarDouble(rendimentos, 2);
	}
	
	public Double getSobra() {
		return NumberUtil.normalizarDouble(rendimentos - getTotalGastos(), 2);
	}
	
}
