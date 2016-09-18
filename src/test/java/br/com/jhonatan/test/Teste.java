package br.com.jhonatan.test;

import static org.junit.Assert.assertEquals;

import br.com.jhonatan.dao.DespesaDAO;
import br.com.jhonatan.entidades.Despesa;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "classpath:general-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class Teste {

    @Autowired
    private DespesaDAO despesaDAO;

    @Test
    public void bla() {
        final Despesa d = despesaDAO.findById(Despesa.class, 1L);
        assertEquals("teste", d.getDescricao());
    }

}
