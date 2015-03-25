package br.com.jhonatan.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

	public static Date getPrimeiroDiaMes(Date date) {
		Calendar c = new GregorianCalendar();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, 1);
		return c.getTime();
	}

	public static Date getUltimoDiaMes(Date date) {
		Calendar c = new GregorianCalendar();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		return c.getTime();
	}
	
	public static Date subtrairMeses(Date date, int meses) {
		Calendar c = new GregorianCalendar();
		c.setTime(date);
		c.add(Calendar.MONTH, -meses);
		return c.getTime();
	}
	
	public static Date adicionarMeses(Date date, int meses) {
		Calendar c = new GregorianCalendar();
		c.setTime(date);
		c.add(Calendar.MONTH, meses);
		return c.getTime();
	}

}
