package br.com.jhonatan.util;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

public final class DateUtil {//Se a classe é somente utilitária e só tem métodos static, colocar como final e criar construtor privado
	
	private DateUtil() {}

	public static Date getPrimeiroDiaMes(final Date date) {
		final Calendar c = new GregorianCalendar();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, 1);
		return c.getTime();
	}

	public static Date getUltimoDiaMes(final Date date) {
		final Calendar c = new GregorianCalendar();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		return c.getTime();
	}
	
	public static Date subtrairMeses(final Date date, final int meses) {
		final Calendar c = new GregorianCalendar();
		c.setTime(date);
		c.add(Calendar.MONTH, -meses);
		return c.getTime();
	}
	
	public static Date adicionarMeses(final Date date, final int meses) {
		final Calendar c = new GregorianCalendar();
		c.setTime(date);
		c.add(Calendar.MONTH, meses);
		return c.getTime();
	}
	
	public static int getMes(final Date data) {
		final Calendar c = new GregorianCalendar();
		c.setTime(data);
		return c.get(Calendar.MONTH) + 1;
	}
	
	public static int getAno(final Date data) {
		final Calendar c = new GregorianCalendar();
		c.setTime(data);
		return c.get(Calendar.YEAR);
	}
	
	public static List<String> getMeses() {
		final Locale localeBrasil = new Locale("pt", "br");
		final String[] arrayMeses = DateFormatSymbols.getInstance(localeBrasil).getMonths();
		final List<String> meses = new ArrayList<String>(Arrays.asList(arrayMeses));
		meses.remove(12);//Removendo mês fantasma
		return meses;
	}

	public static List<Integer> get5AnosAtras5anosAFrente() {
		final Calendar c = new GregorianCalendar();
		final Integer anoAtual = c.get(Calendar.YEAR);
		final Set<Integer> anos = new TreeSet<Integer>();
		anos.add(anoAtual);
		for (int i = 1; i < 6; i++) {
			anos.add(anoAtual - i);
			anos.add(anoAtual + i);
		}
		return new ArrayList<Integer>(anos);
	}
	
	public static Date getPrimeiroDiaMes(final Integer mes, final Integer ano) {
		final Calendar c = new GregorianCalendar();
		c.set(Calendar.MONTH, mes);
		c.set(Calendar.YEAR, ano);
		c.set(Calendar.DAY_OF_MONTH, 1);
		return c.getTime();
	}
	
	public static Date getUltimoDiaMes(final Integer mes, final Integer ano) {
		final Calendar c = new GregorianCalendar();
		c.set(Calendar.MONTH, mes);
		c.set(Calendar.YEAR, ano);
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		return c.getTime();
	}
	
}
