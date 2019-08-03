package tomas.reisenman.practice.controller;

import tomas.reisenman.practice.model.Employee;
import tomas.reisenman.practice.service.EmployeeService;
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

import static tomas.reisenman.practice.TestUtil.asJsonString;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeesController.class)
public class EmployeeControllerTest {

	@Autowired
    private MockMvc mvc;
	private EmployeesController controller;
	private String root;

	@MockBean
    private EmployeeService employeeService;

	Long id = 1L;
	String surname = "Perez";
	String name = "Carlos";
	String contactEmail = "juan.carl@jmail.com";

	private Employee testEmployee;

	@Before
	public void setUp() throws Exception {
		controller = new EmployeesController(employeeService);
		root = controller.getClass().getAnnotation(RequestMapping.class).value()[0];

		testEmployee = new Employee();
		testEmployee.setId(id);
		testEmployee.setContactEmail(contactEmail);
		testEmployee.setName(name);
		testEmployee.setSurname(surname);
	}

	@Test
    public void findAllWithEmptyResult() throws Exception {
    	
    	when(employeeService.findAll()).thenReturn(Collections.emptyList());
    	

    	mvc.perform(get(root +"/"))
    							.andDo(print())
    							.andExpect(status().isOk())
    							.andExpect(jsonPath("$", hasSize(0)))
    							.andReturn();	
    }
    
    @Test
    public void findAllWithOneResultElement() throws Exception {
    	


    	when(employeeService.findAll()).thenReturn(Arrays.asList(testEmployee));
    	

        
    	mvc.perform(get(root +"/"))
    							.andDo(print())
    							.andExpect(status().isOk())
    							.andExpect(jsonPath("$", hasSize(1)))
    							.andExpect(jsonPath("$[0].id", is(id.intValue())))
    							.andExpect(jsonPath("$[0].surname", is(surname)))
    							.andExpect(jsonPath("$[0].name", is(name)))
    							.andExpect(jsonPath("$[0].contactEmail", is(contactEmail)))
    							.andReturn();
    }

	@Test
	public void findById() throws Exception {


		when(employeeService.findById(id)).thenReturn(testEmployee);


		mvc.perform(get(root +"/" + id))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(id.intValue())))
				.andExpect(jsonPath("$.surname", is(surname)))
				.andExpect(jsonPath("$.name", is(name)))
				.andExpect(jsonPath("$.contactEmail", is(contactEmail)))
				.andReturn();
	}

	@Test
	public void saveEmployee() throws Exception {


		when(employeeService.saveEmployee(testEmployee)).thenReturn(testEmployee);


		mvc.perform(post(root +"/").contentType(MediaType.APPLICATION_JSON).content(asJsonString(testEmployee)))
				.andDo(print())
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.id", is(id.intValue())))
				.andExpect(jsonPath("$.surname", is(surname)))
				.andExpect(jsonPath("$.name", is(name)))
				.andExpect(jsonPath("$.contactEmail", is(contactEmail)))
				.andReturn();
	}

	@Test
	public void testUpdateByIdShouldReturnSingleEmployee() throws Exception {

		Employee updatedEmployee = new Employee();
		updatedEmployee.setId(id);
		updatedEmployee.setContactEmail("565834");
		updatedEmployee.setName("Juan");
		updatedEmployee.setSurname("Carlos");

		Map<String, String> updatedMap = new HashMap() {{
			put("name", "Juan");
			put("contactEmail", "565834");
			put("surname", "Carlos");
		}};

		when(employeeService.updateEmployee(id,updatedMap)).thenReturn(updatedEmployee);


		mvc.perform(put(root +"/" + id).contentType(MediaType.APPLICATION_JSON).content(asJsonString(updatedMap)))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id", is(updatedEmployee.getId().intValue())))
				.andExpect(jsonPath("$.surname", is(updatedEmployee.getSurname())))
				.andExpect(jsonPath("$.name", is(updatedEmployee.getName())))
				.andExpect(jsonPath("$.contactEmail", is(updatedEmployee.getContactEmail())))
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
