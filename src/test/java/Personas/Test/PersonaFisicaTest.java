package Personas.Test;

import Colaboradores.DistribuirVianda;
import Colaboradores.DonarDinero;
import Colaboradores.DonarVianda;
import Colaboradores.TipoColaboracion;
import Formularios.Formulario;
import Heladera.Vianda;
import Personas.PersonaFisica;
import org.junit.Test;

import java.time.LocalDate;

import static Colaboradores.Frecuencia.MENSUAL;
import static org.junit.Assert.assertEquals;

public class PersonaFisicaTest {
    TipoColaboracion tipoDonarDinero = new TipoColaboracion(0.5);
    TipoColaboracion tipoDistribuirVianda = new TipoColaboracion(1);
    TipoColaboracion tipoDonarVianda = new TipoColaboracion(1.5);
    // TODO - los test funcionaban porque la clase Vianda estaba vacia
    Vianda viandaPrueba = new Vianda();
    Formulario formGenerico = new Formulario();
    @Test
    public void losPuntosDeUnaPersonaVulnerableQueDono30YDistribuyo15Es30() {
        DonarDinero donacion30 = new DonarDinero(30, LocalDate.now(),MENSUAL,tipoDonarDinero);
        DistribuirVianda distribucion15 = new DistribuirVianda(15,tipoDistribuirVianda);

        PersonaFisica personaF1 = new PersonaFisica(formGenerico);
        personaF1.registrarColaboracion(donacion30);
        personaF1.registrarColaboracion(distribucion15);

        assertEquals(30.00, personaF1.calcularPuntaje(),0.01);
    }
    @Test
    public void losPuntosDeUnaPersonaVulnerableQueNoColaboroEs0() {

        PersonaFisica personaF1 = new PersonaFisica(formGenerico);

        assertEquals(0, personaF1.calcularPuntaje(),0.01);
    }
    @Test
    public void losPuntosDeUnaPersonaVulnerableQueDono30y110y59YDistribuyo15YDonoViandaEs116s() {
        DonarDinero donacion30 = new DonarDinero(30, LocalDate.now(),MENSUAL,tipoDonarDinero);
        DistribuirVianda distribucion15 = new DistribuirVianda(15,tipoDistribuirVianda);
        DonarVianda donacionVianda = new DonarVianda(viandaPrueba, tipoDonarVianda);
        DonarDinero donacion110 = new DonarDinero(110, LocalDate.now(),MENSUAL,tipoDonarDinero);
        DonarDinero donacion59 = new DonarDinero(59, LocalDate.now(),MENSUAL,tipoDonarDinero);



        PersonaFisica personaF1 = new PersonaFisica(formGenerico);

        personaF1.registrarColaboracion(donacion30);
        personaF1.registrarColaboracion(donacion110);
        personaF1.registrarColaboracion(donacion59);
        personaF1.registrarColaboracion(distribucion15);
        personaF1.registrarColaboracion(donacionVianda);


        assertEquals(116.00, personaF1.calcularPuntaje(),0.01);
    }
}
