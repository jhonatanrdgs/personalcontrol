package br.com.jhonatan.service;

import java.util.Calendar;
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
import br.com.jhonatan.dao.UsuarioDAO;
import br.com.jhonatan.dto.DespesaDTO;
import br.com.jhonatan.entidades.Despesa;
import br.com.jhonatan.entidades.ParcelaDespesa;
import br.com.jhonatan.entidades.Usuario;
import br.com.jhonatan.util.NumberUtil;

@Service
public class DespesaServiceImp implements DespesaService {
	
	@Autowired
	private DespesaDAO despesaDAO;
	
	@Autowired 
	private UsuarioDAO usuarioDAO;

	@Override
	public void salvarOuAtualizar(Despesa despesa) {
		if (!despesa.isFixa()) {//Fixa não tem parcela
			despesa.setParcelas(montarListaParcelas(despesa));
		}
		
		if (despesa.getId() == null) {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			Usuario usuario = usuarioDAO.pesquisarUsuarioPorLogin(authentication.getName());
			despesa.setUsuario(usuario);
			despesaDAO.salvar(despesa);
		} else {
			despesaDAO.atualizar(despesa);
		}
	}

	@Override
	public List<Despesa> pesquisarDespesas(DespesaDTO despesaDTO) {
		return despesaDAO.pesquisarDespesas(despesaDTO);
	}

	@Override
	public Despesa findById(Long id) {
		return despesaDAO.findById(Despesa.class, id);
	}

	@Override
	public Despesa findByIdFetched(Long id) {
		return despesaDAO.findByIdFetched(id);
	}
	
	@Override
	@Transactional
	public void excluirDespesa(Long id) {
		Despesa despesa = despesaDAO.findById(Despesa.class, id);
		despesaDAO.excluir(despesa);
		
	}

	private Set<ParcelaDespesa> montarListaParcelas(Despesa despesa) {
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
