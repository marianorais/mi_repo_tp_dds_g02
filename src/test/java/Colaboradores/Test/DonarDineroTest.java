package Colaboradores.Test;

import Colaboradores.DonarDinero;
import Colaboradores.TipoColaboracion;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static Colaboradores.Frecuencia.MENSUAL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DonarDineroTest {
    TipoColaboracion tipoDonarDinero = new TipoColaboracion(0.5);
    @Test
    public void elPuntajeDeDonar20Es10() {
        DonarDinero donacion20 = new DonarDinero(20, LocalDate.now(),MENSUAL,tipoDonarDinero);
        assertEquals(10,donacion20.calcularPuntaje());
    }
    @Test
    public void elPuntajeDeDonar123Con80Es61Con90(){
        DonarDinero donacion123 = new DonarDinero(123.80, LocalDate.now(),MENSUAL,tipoDonarDinero);
        assertEquals(61.9,donacion123.calcularPuntaje());
    }
    @Test
    public void elPuntajeDeDonar0Es0() {
        DonarDinero donacion0 = new DonarDinero(0, LocalDate.now(),MENSUAL,tipoDonarDinero);
        assertEquals(0,donacion0.calcularPuntaje());
    }
}