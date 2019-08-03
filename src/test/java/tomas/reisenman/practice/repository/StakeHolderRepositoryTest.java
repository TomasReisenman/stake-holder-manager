package tomas.reisenman.practice.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import tomas.reisenman.practice.model.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StakeHolderRepositoryTest {


    @Autowired
    private EmployeeRepo employeeRepo;
    
    @Before
    public void setUp() {
    	Employee employee = new Employee();
    	employee.setName("Andres");
    	employee.setSurname("Dario");
    	employee.setPosition("Manager");
    	employee.setContactEmail("andr.dar@jmail.com");

    	employeeRepo.save(employee);
    }
        
    @Test
    public void findAllMustReturnAllEmployees() {
    	List<Employee> result = employeeRepo.findAll();
    	assertEquals(1, result.size());
    }
    
}
