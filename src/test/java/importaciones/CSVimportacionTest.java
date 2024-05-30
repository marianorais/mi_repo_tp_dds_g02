package importaciones;

import Excepciones.ValidadorContraseñaException;
import org.junit.jupiter.api.Test;
import validaciones.ValidadorContraseña;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CSVimportacionTest {
    @Test
    public void importacionTest() throws ValidadorContraseñaException {

        CSVimportacion csVimportacion = new CSVimportacion();
        csVimportacion.importData("C:/Disenio/csvEntrega2.csv");

        String contrasenia = "ContraValida123";
        ValidadorContraseña validadorContraseña = new ValidadorContraseña();
        boolean contraseniaSegura = validadorContraseña.validarContrasenia(contrasenia);

        assertTrue(contraseniaSegura);
    }
    //
}
