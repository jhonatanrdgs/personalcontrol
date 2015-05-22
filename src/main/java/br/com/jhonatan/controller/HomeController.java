package br.com.jhonatan.controller;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.jhonatan.entidades.Despesa;
import br.com.jhonatan.entidades.ParcelaDespesa;
import br.com.jhonatan.util.NumberUtil;

/**
 * 
 * @author Jhonatan Rodrigues {jhonatan.rdgs@gmail.com}
 * 
 *
 */
@Controller
@Scope("session")
public class HomeController {
	
	private static final String VIEW_INDEX = "index";
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@RequestMapping(value="/logged")
	@Transactional
	public String init(ModelMap map) {
		Query q = entityManager.createQuery("select d from Despesa d");
		List<Despesa> despesas = q.getResultList();
		for (Despesa despesa : despesas) {
			if (despesa.getTotalParcelas() > 1) {
				despesa.getParcelas().addAll(montarListaParcelas(despesa));
			}
			entityManager.merge(despesa);
		}
		return VIEW_INDEX;
	}
	
	public Set<ParcelaDespesa> montarListaParcelas(Despesa despesa) {
		Set<ParcelaDespesa> parcelas = new HashSet<ParcelaDespesa>();
		Calendar data = new GregorianCalendar();
		Double valorParcela = NumberUtil.normalizarDouble(despesa.getValorTotal() / despesa.getTotalParcelas(), 2);
		data.setTime(despesa.getData());
		for (int i = 0; i < despesa.getTotalParcelas(); i++) {
			ParcelaDespesa parcela = new ParcelaDespesa();
			parcela.setDataParcela(data.getTime());
			parcela.setDespesa(despesa);
			parcela.setValorParcela(valorParcela);
			parcela.setNumeroParcela(i + 1);
			parcelas.add(parcela);
			
			data.add(Calendar.MONTH, 1);
		}
		return parcelas;
	}
	
}
