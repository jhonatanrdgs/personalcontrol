package br.com.jhonatan.util;

import java.math.BigDecimal;

public final class NumberUtil {
	
	private NumberUtil() {}
	
	public static Double normalizarDouble(final Double valor, final int scale) {
		return new BigDecimal(valor).setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	public static Double zeroIfNull(final Double valor) {
		if (valor == null) {
			return 0D;
		} else {
			return valor;
		}
	}

}
