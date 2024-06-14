package Personas.Test;

import Colaboradores.DistribuirVianda;
import Colaboradores.DonarDinero;
import Colaboradores.TipoColaboracion;
import DatosDePersonas.*;
import Excepciones.*;
import Tarjetas.*;
import Usuario.*;
import Personas.*;
import Heladera.*;
import org.junit.Test;

import java.time.LocalDate;

import static Colaboradores.Frecuencia.MENSUAL;
import static DatosDePersonas.Documento.DNI;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class PersonaVulnerableTest {
    //------------------------------------- TEST DE USO DE TARJETA -------------------------------------------------------------------

    // instancio a la persona en cada método para no tener que reestablecer los usos de su tarjeta.
    @Test
    public void tarjetaUsadaExitosamente() throws LimiteDiarioAlcanzadoException {

        PersonaVulnerable persona = new PersonaVulnerable("Pedro", LocalDate.of(1994, 6, 15),
                LocalDate.of(2024, 1, 27), false,
                new Direccion(2345, new Calle("Avenida Santa Fe")), DNI, "12345678",
                1, mock(Usuario.class), mock(PersonaFisica.class),
                new TarjetaAlimentaria("12345678911", 1));

        persona.usarTarjeta(new Uso(LocalDate.now(), mock(Heladera.class), mock(Vianda.class)));

        assertEquals(5, persona.getTarjeta().getLimiteUsosDiarios());
    }

    @Test
    public void tarjetaAlcanzaLimiteDeUsos() throws LimiteDiarioAlcanzadoException {

        PersonaVulnerable persona = new PersonaVulnerable("Pedro", LocalDate.of(1994, 6, 15),
                LocalDate.of(2024, 1, 27), false,
                new Direccion(2345, new Calle("Avenida Santa Fe")), DNI, "12345678",
                1, mock(Usuario.class), mock(PersonaFisica.class),
                new TarjetaAlimentaria("12345678911", 1));

        for (int i = 0; i < 6; i++) // agoto los 6 usos de tarjeta disponibles para Pedro.
            persona.usarTarjeta(new Uso(LocalDate.now(), mock(Heladera.class), mock(Vianda.class)));

        assertThrows(LimiteDiarioAlcanzadoException.class, () -> {
            persona.usarTarjeta(new Uso(LocalDate.of(2024, 6, 8), mock(Heladera.class), mock(Vianda.class)));
            ;
        }); // el 7mo uso debería provocar que se lance la excepción.
    }

    @Test
    public void tarjetaRestauraSuLimiteAlCambiarDeDia() throws LimiteDiarioAlcanzadoException {

        PersonaVulnerable persona = new PersonaVulnerable("Pedro", LocalDate.of(1994, 6, 15),
                LocalDate.of(2024, 1, 27), false,
                new Direccion(2345, new Calle("Avenida Santa Fe")), DNI, "12345678",
                1, mock(Usuario.class), mock(PersonaFisica.class),
                new TarjetaAlimentaria("12345678911", 1));

        for (int i = 0; i < 6; i++) {// agoto los 6 usos de tarjeta disponibles para Pedro.
            //en realidad la fecha del uso debe ser siempre LocalDate.now() pero paso fecha para no tener que actualizar la del cambio de dia
            persona.usarTarjeta(new Uso(LocalDate.of(2024, 6, 7), mock(Heladera.class), mock(Vianda.class)));
        }
        // el 7mo uso se realiza al día siguiente 08/06/24 por lo que debería poder hacerse
        persona.usarTarjeta(new Uso(LocalDate.of(2024, 6, 8), mock(Heladera.class), mock(Vianda.class)));

        assertEquals(5, persona.getTarjeta().getLimiteUsosDiarios());
    }
}


