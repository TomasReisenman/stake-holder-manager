package tomas.reisenman.practice.service;

import tomas.reisenman.practice.model.Employee;
import tomas.reisenman.practice.repository.EmployeeRepo;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class EmployeeServiceTest {

    private EmployeeService employeeService;

    @Mock
    private EmployeeRepo employeeRepo;

    Long id = 1L;
    String surname = "Perez";
    String name = "Carlos";
    String contactEmail = "per.carl@jmail.com";

    private Employee testEmployee;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        employeeService = new EmployeeService(employeeRepo);

        testEmployee = new Employee();
        testEmployee.setId(id);
        testEmployee.setContactEmail(contactEmail);
        testEmployee.setName(name);
        testEmployee.setSurname(surname);
    }


    @Test
    public void findAllShouldReturnSingleValue() {

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(testEmployee);

        when(employeeRepo.findAll()).thenReturn(employeeList);

        assertThat(employeeService.findAll(),equalTo(employeeList));
    }

    @Test
    public void findById() {

        when(employeeRepo.findById(anyLong())).thenReturn(Optional.ofNullable(testEmployee));
        assertThat(employeeService.findById(1L),equalTo(testEmployee));
    }

    @Test
    public void updateEmployee() {

        Employee updatedEmployee = new Employee();
        updatedEmployee.setId(id);
        updatedEmployee.setContactEmail("per.carl@jmail.com");
        updatedEmployee.setName("Juan");
        updatedEmployee.setSurname("Carlos");

        Map<String, String> updatedMap = new HashMap() {{
            put("name", "Juan");
            put("contactEmail", "565834");
            put("surname", "Carlos");
        }};


        when(employeeRepo.findById(any(Long.class))).thenReturn(Optional.of(testEmployee));

        when(employeeRepo.save(updatedEmployee)).thenReturn(updatedEmployee);
        assertThat(employeeService.updateEmployee(1L,updatedMap),equalTo(updatedEmployee));
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void saveEmployee() {

        when(employeeRepo.save(testEmployee)).thenReturn(testEmployee);

        assertThat(employeeService.saveEmployee(testEmployee),equalTo(testEmployee));

    }
}