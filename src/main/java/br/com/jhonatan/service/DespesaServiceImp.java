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

import br.com.jhonatan.dao.DespesaDAO;
import br.com.jhonatan.dao.UsuarioDAO;
import br.com.jhonatan.dto.DespesaDTO;
import br.com.jhonatan.entidades.Despesa;
import br.com.jhonatan.entidades.ParcelaDespesa;
import br.com.jhonatan.entidades.Usuario;

@Service
public class DespesaServiceImp implements DespesaService {
	
	@Autowired
	private DespesaDAO despesaDAO;
	
	@Autowired UsuarioDAO usuarioDAO;

	@Override
	public void salvarOuAtualizar(Despesa despesa) {
		if (despesa.getId() == null) {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			Usuario usuario = usuarioDAO.pesquisarUsuarioPorLogin(authentication.getName());
			despesa.setUsuario(usuario);
			if (!despesa.isFixa()) {//Fixa não tem parcela
				despesa.setParcelas(montarListaParcelas(despesa));
			}
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
	
	public Set<ParcelaDespesa> montarListaParcelas(Despesa despesa) {
		Set<ParcelaDespesa> parcelas = new HashSet<ParcelaDespesa>();
		Calendar data = new GregorianCalendar();
		data.setTime(despesa.getData());
		Double valorParcela = despesa.getValorTotal() / despesa.getTotalParcelas();
		for (int i = 0; i < despesa.getTotalParcelas(); i++) {
			ParcelaDespesa parcela = new ParcelaDespesa();
			parcela.setDataParcela(data.getTime());
			parcela.setDespesa(despesa);
			parcela.setNumeroParcela(i + 1);
			parcela.setValorParcela(valorParcela);
			parcelas.add(parcela);
			
			data.add(Calendar.MONTH, 1);
		}
		return parcelas;
	}

}
