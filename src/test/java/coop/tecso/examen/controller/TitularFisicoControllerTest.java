package coop.tecso.examen.controller;

import coop.tecso.examen.model.TitularFisico;
import coop.tecso.examen.service.TitularFisicoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static coop.tecso.examen.TestUtil.asJsonString;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TitularFisicoController.class)
public class TitularFisicoControllerTest {

	@Autowired
    private MockMvc mvc;
	private TitularFisicoController controller;
	private String root;

	@MockBean
    private TitularFisicoService titularFisicoService;

	Long id = 1L;
	String apellido = "Perez";
	String nombre = "Carlos";
	String cuit = "34667747";

	private TitularFisico titularFisicoTest;

	@Before
	public void setUp() throws Exception {
		controller = new TitularFisicoController(titularFisicoService);
		root = controller.getClass().getAnnotation(RequestMapping.class).value()[0];

		titularFisicoTest = new TitularFisico();
		titularFisicoTest.setId(id);
		titularFisicoTest.setCuit(cuit);
		titularFisicoTest.setNombre(nombre);
		titularFisicoTest.setApellido(apellido);
	}

	@Test
    public void findAllWithEmptyResult() throws Exception {
    	
    	when(titularFisicoService.findAll()).thenReturn(Collections.emptyList());
    	

    	mvc.perform(get(root +"/"))
    							.andDo(print())
    							.andExpect(status().isOk())
    							.andExpect(jsonPath("$", hasSize(0)))
    							.andReturn();	
    }
    
    @Test
    public void findAllWithOneResultElement() throws Exception {
    	


    	when(titularFisicoService.findAll()).thenReturn(Arrays.asList(titularFisicoTest));
    	

        
    	mvc.perform(get(root +"/"))
    							.andDo(print())
    							.andExpect(status().isOk())
    							.andExpect(jsonPath("$", hasSize(1)))
    							.andExpect(jsonPath("$[0].id", is(id.intValue())))
    							.andExpect(jsonPath("$[0].apellido", is(apellido)))
    							.andExpect(jsonPath("$[0].nombre", is(nombre)))
    							.andExpect(jsonPath("$[0].cuit", is(cuit)))
    							.andReturn();
    }

	@Test
	public void findById() throws Exception {


		when(titularFisicoService.findById(id)).thenReturn(titularFisicoTest);


		mvc.perform(get(root +"/" + id))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(id.intValue())))
				.andExpect(jsonPath("$.apellido", is(apellido)))
				.andExpect(jsonPath("$.nombre", is(nombre)))
				.andExpect(jsonPath("$.cuit", is(cuit)))
				.andReturn();
	}

	@Test
	public void saveTitularFisico() throws Exception {


		when(titularFisicoService.saveTitularFisico(titularFisicoTest)).thenReturn(titularFisicoTest);


		mvc.perform(post(root +"/").contentType(MediaType.APPLICATION_JSON).content(asJsonString(titularFisicoTest)))
				.andDo(print())
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.id", is(id.intValue())))
				.andExpect(jsonPath("$.apellido", is(apellido)))
				.andExpect(jsonPath("$.nombre", is(nombre)))
				.andExpect(jsonPath("$.cuit", is(cuit)))
				.andReturn();
	}

	@Test
	public void testUpdateByIdShouldReturnSingleTitular() throws Exception {

		TitularFisico updatedTitular = new TitularFisico();
		updatedTitular.setId(id);
		updatedTitular.setCuit("565834");
		updatedTitular.setNombre("Juan");
		updatedTitular.setApellido("Carlos");

		Map<String, String> updatedMap = new HashMap() {{
			put("nombre", "Juan");
			put("cuit", "565834");
			put("apellido", "Carlos");
		}};

		when(titularFisicoService.updateTitularJuridico(id,updatedMap)).thenReturn(updatedTitular);


		mvc.perform(put(root +"/" + id).contentType(MediaType.APPLICATION_JSON).content(asJsonString(updatedMap)))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(updatedTitular.getId().intValue())))
				.andExpect(jsonPath("$.apellido", is(updatedTitular.getApellido())))
				.andExpect(jsonPath("$.nombre", is(updatedTitular.getNombre())))
				.andExpect(jsonPath("$.cuit", is(updatedTitular.getCuit())))
				.andReturn();
	}

	@Test
	public void testDelete() throws Exception{


		mvc.perform(delete(root +"/" + 1))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();


	}


	
}
