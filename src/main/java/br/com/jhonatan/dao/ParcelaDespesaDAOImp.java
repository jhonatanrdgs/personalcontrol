package br.com.jhonatan.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.jhonatan.entidades.ParcelaDespesa;


@Repository
public class ParcelaDespesaDAOImp extends GenericDAO<ParcelaDespesa> implements ParcelaDespesaDAO  {

	private static final long serialVersionUID = 1515767679445406862L;

	@Override
	public List<ParcelaDespesa> pesquisarParcelasDaDespesa(Long id) {
		return criarQueryResultList(ParcelaDespesa.CONSULTAR_PARCELAS_POR_ID_DESPESA, id);
	}
	
	public void excluirParcela(Long idParcela) {
		Query q = getEntityManager().createNativeQuery("delete from personal_control.parcela_despesa where id_parcela_despesa = ?1");
		q.setParameter(1, idParcela);
		q.executeUpdate();
	}
	
	

}
