package br.com.jhonatan.test;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;

import br.com.jhonatan.controller.CategoriaController;
import br.com.jhonatan.entidades.Categoria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:testes.xml"})
@WebAppConfiguration
public class CategoriaControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private CategoriaController categoriaController;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(categoriaController).build();
	}

	@Test
	public void abrirPagina() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/categoria/listCategoria")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				)
				.andExpect(MockMvcResultMatchers.forwardedUrl("categoria/listCategoria"));

	}

	@Test
	public void pesquisar() throws Exception {
		Categoria c = new Categoria();
		c.setDescricao("");
		MvcResult r = mockMvc.perform(MockMvcRequestBuilders.get("/categoria/search")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.flashAttr("categoriaForm", c)
				)
				.andReturn();
		Assert.isInstanceOf(ArrayList.class, r.getModelAndView().getModelMap().get("resultado"), "Objeto deve ser do tipo ArrayList");

	}
}