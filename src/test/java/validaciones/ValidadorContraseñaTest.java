package validaciones;

import Usuario.ValidadorContraseña;
import Excepciones.ValidadorContraseñaException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidadorContraseñaTest {
    @Test
    public void contraseniaValida() throws ValidadorContraseñaException {
        String contrasenia = "ContraValida123";
        ValidadorContraseña validadorContraseña = new ValidadorContraseña();
        boolean contraseniaSegura = validadorContraseña.validarContrasenia(contrasenia);

        assertTrue(contraseniaSegura);
    }

    @Test
    public void contraseniaInvalida() throws ValidadorContraseñaException {
        String contrasenia = "ContraInvalida";

        ValidadorContraseña validadorContraseña = new ValidadorContraseña();

        ValidadorContraseñaException exception = assertThrows(ValidadorContraseñaException.class, () -> {
            validadorContraseña.validarContrasenia(contrasenia);
        });

        assertEquals("La contraseña no cumple con los requisitos de seguridad.", exception.getMessage());
    }
}
