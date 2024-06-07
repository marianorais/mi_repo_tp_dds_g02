package Colaboradores.Test;

import Colaboradores.DonarDinero;
import Colaboradores.TipoColaboracion;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static Colaboradores.Frecuencia.MENSUAL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DonarDineroTest {

    @Test
    public void elPuntajeDeDonar20Es10() {
        TipoColaboracion tipoDonarDinero = new TipoColaboracion(0.5);
        DonarDinero donacion20 = new DonarDinero(20, LocalDate.now(),MENSUAL,tipoDonarDinero);


        assertEquals(10,donacion20.calcularPuntaje());
    }

}