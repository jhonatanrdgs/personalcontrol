package br.com.jhonatan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jhonatan.dao.MetodoPagamentoDAO;
import br.com.jhonatan.entidades.MetodoPagamento;

@Service
public class MetodoPagamentoServiceImp implements MetodoPagamentoService {

	@Autowired
	private MetodoPagamentoDAO metodoPagamentoDao;
	
	@Override
	public void salvarOuAtualizar(MetodoPagamento metodoPagamento) {
		if (metodoPagamento.getId() == null) {
			metodoPagamentoDao.salvar(metodoPagamento);
		} else {
			metodoPagamentoDao.atualizar(metodoPagamento);
		}

	}

	@Override
	public List<MetodoPagamento> pesquisarMetodosPagamento(String descricao) {
		return metodoPagamentoDao.pesquisarMetodosPagamento(descricao);
	}

	@Override
	public MetodoPagamento findById(Long id) {
		return metodoPagamentoDao.findById(MetodoPagamento.class, id);
	}

	@Override
	public List<MetodoPagamento> pesquisarTodosMetodosPagamentoAtivos() {
		return metodoPagamentoDao.pesquisarTodosMetodosPagamentoAtivos();
	}
	
	

}
