package br.com.jhonatan.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.jhonatan.dao.DespesaDAO;
import br.com.jhonatan.dao.ParcelaDespesaDAO;
import br.com.jhonatan.dao.UsuarioDAO;
import br.com.jhonatan.entidades.Despesa;
import br.com.jhonatan.entidades.ParcelaDespesa;
import br.com.jhonatan.entidades.Usuario;
import br.com.jhonatan.util.DateUtil;
import br.com.jhonatan.util.NumberUtil;

@Service
public class DespesaServiceImp implements DespesaService {
	
	@Autowired
	private DespesaDAO despesaDAO;
	
	@Autowired
	private ParcelaDespesaDAO parcelaDespesaDAO;
	
	@Autowired 
	private UsuarioDAO usuarioDAO;

	@Override
	@Transactional
	public void salvarOuAtualizar(final Despesa despesa) {
		if (!despesa.isFixa()) {//Fixa não tem parcela
			despesa.setParcelas(montarListaParcelas(despesa));
		} else {
			despesa.setParcelas(new HashSet<ParcelaDespesa>());
		}
		
		if (despesa.getId() == null) {
			final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			final Usuario usuario = usuarioDAO.pesquisarUsuarioPorLogin(authentication.getName());
			despesa.setUsuario(usuario);
			despesaDAO.salvar(despesa);
		} else {
			despesaDAO.atualizar(despesa);
		}
	}

	@Override
	public List<Despesa> pesquisarDespesas(final Despesa despesa) {
		return despesaDAO.pesquisarDespesas(despesa);
	}
	
	@Override
	public List<Despesa> pesquisarUltimasDespesas(final Despesa despesa) {
		return despesaDAO.pesquisarUltimasDespesas(despesa);
	}

	@Override
	public Despesa findById(final Long id) {
		return despesaDAO.findById(Despesa.class, id);
	}

	@Override
	public Despesa findByIdFetched(final Long id) {
		return despesaDAO.findByIdFetched(id);
	}
	
	@Override
	@Transactional
	public void excluirDespesa(final Long id) {
		final Despesa despesa = despesaDAO.findById(Despesa.class, id);
		for (final ParcelaDespesa parcela : despesa.getParcelas()) {
			parcelaDespesaDAO.excluirParcela(parcela.getId());
		}
		despesaDAO.excluir(despesa);
	}
	
	@Override
	@Transactional
	public void adiantarPagamentoParcela(final Long idParcela) {
		final ParcelaDespesa parcela = parcelaDespesaDAO.findById(ParcelaDespesa.class, idParcela);
		parcelaDespesaDAO.excluir(parcela);
	}
	
	@Override
	@Transactional
	public void adiantarPagamentoTodasParcelas(final Long idDespesa) {
		final List<ParcelaDespesa> parcelas = parcelaDespesaDAO.pesquisarParcelasDaDespesa(idDespesa);
		for (final ParcelaDespesa pd : parcelas) {
			parcelaDespesaDAO.excluir(pd);
		}
	}

	@Override
	public List<Despesa> pesquisarDespesasComParcelasProximoMesEmDiante() {
		Date proximoMes = DateUtil.adicionarMeses(new Date(), 1);
		proximoMes = DateUtil.getPrimeiroDiaMes(proximoMes);
		return despesaDAO.pesquisarDespesasComParcelasProximoMesEmDiante(proximoMes);
	}
	
	@Override
	public List<ParcelaDespesa> pesquisarParcelasDaDespesa(final Long id) {
		return parcelaDespesaDAO.pesquisarParcelasDaDespesa(id);
	}

	private Set<ParcelaDespesa> montarListaParcelas(final Despesa despesa) {
		final Set<ParcelaDespesa> parcelas = new HashSet<ParcelaDespesa>();
		final Calendar data = new GregorianCalendar();
		final Double valorParcela = NumberUtil.normalizarDouble(despesa.getValorTotal() / despesa.getTotalParcelas(), 2);
		data.setTime(despesa.getData());
		for (int nrParcela = 0; nrParcela < despesa.getTotalParcelas(); nrParcela++) {
			final ParcelaDespesa parcela = new ParcelaDespesa(data.getTime(), despesa, valorParcela, nrParcela + 1);
			parcelas.add(parcela);
			data.add(Calendar.MONTH, 1);
		}
		return parcelas;
	}

}
