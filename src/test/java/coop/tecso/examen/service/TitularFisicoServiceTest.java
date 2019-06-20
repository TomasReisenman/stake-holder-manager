package coop.tecso.examen.service;

import coop.tecso.examen.model.TitularFisico;
import coop.tecso.examen.repository.TitularFisicoRepo;
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

public class TitularFisicoServiceTest {

    private TitularFisicoService titularFisicoService;

    @Mock
    private TitularFisicoRepo titularFisicoRepo;

    Long id = 1L;
    String apellido = "Perez";
    String nombre = "Carlos";
    String cuit = "34667747";

    private TitularFisico titularFisicoTest;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        titularFisicoService = new TitularFisicoService(titularFisicoRepo);

        titularFisicoTest = new TitularFisico();
        titularFisicoTest.setId(id);
        titularFisicoTest.setCuit(cuit);
        titularFisicoTest.setNombre(nombre);
        titularFisicoTest.setApellido(apellido);
    }


    @Test
    public void findAllShouldReturnSingleValue() {

        List<TitularFisico> titularFisicoList = new ArrayList<>();
        titularFisicoList.add(titularFisicoTest);

        when(titularFisicoRepo.findAll()).thenReturn(titularFisicoList);

        assertThat(titularFisicoService.findAll(),equalTo(titularFisicoList));
    }

    @Test
    public void findById() {

        when(titularFisicoRepo.findById(anyLong())).thenReturn(Optional.ofNullable(titularFisicoTest));
        assertThat(titularFisicoService.findById(1L),equalTo(titularFisicoTest));
    }

    @Test
    public void updateTitularJuridico() {

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


        when(titularFisicoRepo.findById(any(Long.class))).thenReturn(Optional.of(titularFisicoTest));

        when(titularFisicoRepo.save(updatedTitular)).thenReturn(updatedTitular);
        assertThat(titularFisicoService.updateTitularJuridico(1L,updatedMap),equalTo(updatedTitular));
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void saveTitularFisico() {

        when(titularFisicoRepo.save(titularFisicoTest)).thenReturn(titularFisicoTest);

        assertThat(titularFisicoService.saveTitularFisico(titularFisicoTest),equalTo(titularFisicoTest));

    }
}