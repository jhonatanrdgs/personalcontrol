package br.com.jhonatan.test.dao;

import static org.junit.Assert.assertEquals;

import br.com.jhonatan.dao.DespesaDAO;
import br.com.jhonatan.entidades.Despesa;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations = "classpath:test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DespesaDAOTest {

    @Autowired
    private DespesaDAO despesaDAO;

    @Test
    @Transactional
    @Rollback
    public void testFindById() {
        final Despesa d = despesaDAO.findById(Despesa.class, 1L);
        assertEquals("teste", d.getDescricao());
    }

}
