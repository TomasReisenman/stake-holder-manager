package coop.tecso.examen.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import coop.tecso.examen.model.Titular;
import coop.tecso.examen.model.TitularFisico;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TitularRepositoryTest {


    @Autowired
    private TitularFisicoRepo titularFisicoRepo;
    
    @Before
    public void setUp() {
    	TitularFisico titular = new TitularFisico();
    	titular.setNombre("Andres");
    	titular.setApellido("Dario");
    	titular.setDni("35666");
    	titular.setCuit("5559595");

    	titularFisicoRepo.save(titular);
    }
        
    @Test
    public void findAllMustReturnAllTitulares() {
    	List<TitularFisico> result = titularFisicoRepo.findAll();
    	assertEquals(1, result.size());
    }
    
}
