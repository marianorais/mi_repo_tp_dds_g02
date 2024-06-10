package Colaboradores.Test;

import Colaboradores.*;
import Heladera.Heladera;
import Heladera.Vianda;
import Tarjetas.TarjetaAlimentaria;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static Colaboradores.Frecuencia.MENSUAL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ColaboracionesTest {
    //no se si estan bien los test, x que si cambian el coeficiente se pudre
    TipoColaboracion tipoDonarDinero = new TipoColaboracion(0.5);
    TipoColaboracion tipoDistribuirVianda = new TipoColaboracion(1);
    TipoColaboracion tipoDonarVianda = new TipoColaboracion(1.5);
    TipoColaboracion tipoTarjetaRepartida = new TipoColaboracion(2);
    TipoColaboracion tipoHeladeras = new TipoColaboracion(5);
    Vianda v1 = new Vianda();
    TarjetaAlimentaria t1 = new TarjetaAlimentaria();
    Heladera h1 = new Heladera();

    @Test
    public void elPuntajeDeHacerseCargoDeUnaHeladeraCon3HardCodeEs15() {
        HacerseCargoHeladera cargoHeladera = new HacerseCargoHeladera(h1,LocalDate.of(2024,1,1),tipoHeladeras);
        assertEquals(3,cargoHeladera.calcularPuntaje(),0.01);
    }
    @Test
    public void elPuntajeDeRepartir1TarjetaEs2() {
        RegistrarPersonaVulnerable registro1 = new RegistrarPersonaVulnerable(t1,tipoTarjetaRepartida);
        assertEquals(2,registro1.calcularPuntaje(),0.01);
    }
    @Test
    public void elPuntajeDeDonar1ViandasEs1con5() {
        DonarVianda donacionVianda = new DonarVianda(v1,tipoDonarVianda);
        assertEquals(1.5,donacionVianda.calcularPuntaje(),0.01);
    }

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
    @Test
    public void elPuntajeDeDistribuir3ViandasEs3() {
        DistribuirVianda distribucion3 = new DistribuirVianda(3,tipoDistribuirVianda);
        assertEquals(3,distribucion3.calcularPuntaje());
    }
    @Test
    public void elPuntajeDeDistribuir0ViandasEs0(){
        DistribuirVianda distribucion = new DistribuirVianda(0,tipoDistribuirVianda);
        assertEquals(0,distribucion.calcularPuntaje());
    }
    @Test
    public void elPuntajeDeDistribuir40ViandasEs40() {
        DistribuirVianda distribucion = new DistribuirVianda(40,tipoDistribuirVianda);
        assertEquals(40,distribucion.calcularPuntaje());
    }

}