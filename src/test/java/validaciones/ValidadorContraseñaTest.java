package validaciones;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidadorContraseñaTest {
    @Test
    public void contraseniaValida() {
        String contrasenia = "ContraValida123";
        ValidadorContraseña validadorContraseña = new ValidadorContraseña();
        boolean contraseniaSegura = validadorContraseña.validarContrasenia(contrasenia);

        assertTrue(contraseniaSegura);
    }

    @Test
    public void contraseniaInvalida() {
        String contrasenia = "ContraInvalida";
        ValidadorContraseña validadorContraseña = new ValidadorContraseña();
        boolean contraseniaSegura = validadorContraseña.validarContrasenia(contrasenia);

        assertFalse(contraseniaSegura);
    }
}
