package br.com.jhonatan.util;

import java.math.BigDecimal;

public class NumberUtil {
	
	public static Double normalizarDouble(Double valor, int scale) {
		return new BigDecimal(valor).setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

}
