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
	
	public static int getMes(Date data) {
		Calendar c = new GregorianCalendar();
		c.setTime(data);
		return c.get(Calendar.MONTH) + 1;
	}
	
	public static int getAno(Date data) {
		Calendar c = new GregorianCalendar();
		c.setTime(data);
		return c.get(Calendar.YEAR);
	}
	
	public static List<String> getMeses() {
		Locale localeBrasil = new Locale("pt", "br");
		String[] arrayMeses = DateFormatSymbols.getInstance(localeBrasil).getMonths();
		List<String> meses = new ArrayList<String>(Arrays.asList(arrayMeses));
		meses.remove(12);//Removendo mês fantasma
		return meses;
	}

	public static List<Integer> get5AnosAtras5anosAFrente() {
		Calendar c = new GregorianCalendar();
		Integer anoAtual = c.get(Calendar.YEAR);
		Set<Integer> anos = new TreeSet<Integer>();
		anos.add(anoAtual);
		for (int i = 1; i < 6; i++) {
			anos.add(anoAtual - i);
			anos.add(anoAtual + i);
		}
		return new ArrayList<Integer>(anos);
	}
	
	public static Date getPrimeiroDiaMes(Integer mes, Integer ano) {
		Calendar c = new GregorianCalendar();
		c.set(Calendar.MONTH, mes);
		c.set(Calendar.YEAR, ano);
		c.set(Calendar.DAY_OF_MONTH, 1);
		return c.getTime();
	}
	
	public static Date getUltimoDiaMes(Integer mes, Integer ano) {
		Calendar c = new GregorianCalendar();
		c.set(Calendar.MONTH, mes);
		c.set(Calendar.YEAR, ano);
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		return c.getTime();
	}

}
