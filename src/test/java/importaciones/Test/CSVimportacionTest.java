package importaciones.Test;

import Repositorios.IPersonaFisicaRepository;
import Repositorios.IPersonaJuridicaRepository;
import Repositorios.PersonaFisicaRepository;
import Repositorios.PersonaJuridicaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class CSVimportacionTest {

    private String filePath;
    private IPersonaJuridicaRepository personaJuridicaRepo;
    private IPersonaFisicaRepository personaFisicaRepo;

    @BeforeEach
    public void setUp() {
        filePath = "src/main/resources/documentacion/csvEntrega2.csv";
        personaJuridicaRepo = new PersonaJuridicaRepository();// mock(IPersonaJuridicaRepository.class);
        personaFisicaRepo = new PersonaFisicaRepository();//mock(IPersonaFisicaRepository.class);
    }

    @Test
    public void importacionCorrecta() {

        CSVimportacion csVimportacion = new CSVimportacion(this.personaJuridicaRepo,this.personaFisicaRepo);
        csVimportacion.importData(filePath);

        // Se podría poner assertFalse
        assertTrue(!personaJuridicaRepo.buscarTodos().isEmpty() && !personaFisicaRepo.buscarTodos().isEmpty());
    }
    @Test
    public void importacionIncorrecta() {

        CSVimportacion csVimportacion = new CSVimportacion(this.personaJuridicaRepo,this.personaFisicaRepo);
        String filePath = "path_incorrecto";
        csVimportacion.importData(filePath);

        assertTrue(personaJuridicaRepo.buscarTodos().isEmpty() || personaFisicaRepo.buscarTodos().isEmpty());
    }
}
