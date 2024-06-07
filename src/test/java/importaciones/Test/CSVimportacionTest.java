package importaciones.Test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CSVimportacionTest {
    @Test
    public void importacionPersonasFisicasCorrecta() {

        CSVimportacion csVimportacion = new CSVimportacion();
        String filePath = "src/main/resources/documentacion/csvEntrega2.csv";
        csVimportacion.importData(filePath);

        assertTrue(!csVimportacion.getPersonasFisicas().isEmpty());
    }
    @Test
    public void importacionPersonasFisicasIncorrecta() {

        CSVimportacion csVimportacion = new CSVimportacion();
        String filePath = "path_incorrecto";
        csVimportacion.importData(filePath);

        assertTrue(csVimportacion.getPersonasFisicas().isEmpty());
    }
    @Test
    public void importacionPersonasJuridicasCorrecta() {

        CSVimportacion csVimportacion = new CSVimportacion();
        String filePath = "src/main/resources/documentacion/csvEntrega2.csv";
        csVimportacion.importData(filePath);

        assertTrue(!csVimportacion.getPersonasJuridicas().isEmpty());
    }
    @Test
    public void importacionPersonasJuridicasIncorrecta() {

        CSVimportacion csVimportacion = new CSVimportacion();
        String filePath = "path_incorrecto";
        csVimportacion.importData(filePath);

        assertTrue(csVimportacion.getPersonasJuridicas().isEmpty());
    }
}
