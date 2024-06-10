package Personas.Test;

import Colaboradores.DistribuirVianda;
import Colaboradores.DonarDinero;
import Colaboradores.DonarVianda;
import Colaboradores.TipoColaboracion;
import Formularios.Formulario;
import Heladera.Vianda;

import Personas.PersonaJuridica;
import org.junit.Test;

import java.time.LocalDate;

import static Colaboradores.Frecuencia.MENSUAL;
import static org.junit.Assert.assertEquals;

public class PersonaJuridicaTest {
    TipoColaboracion tipoDonarDinero = new TipoColaboracion(0.5);
    TipoColaboracion tipoDistribuirVianda = new TipoColaboracion(1);
    Formulario formGenerico = new Formulario();

    @Test
    public void losPuntosDeUnaPersonaVulnerableQueDono30YDistribuyo15Es30() {
        DonarDinero donacion30 = new DonarDinero(30, LocalDate.now(), MENSUAL, tipoDonarDinero);
        DistribuirVianda distribucion15 = new DistribuirVianda(15, tipoDistribuirVianda);

        PersonaJuridica personaJ1 = new PersonaJuridica(formGenerico);

        personaJ1.registrarColaboracion(donacion30);
        personaJ1.registrarColaboracion(distribucion15);

        assertEquals(30.00, personaJ1.calcularPuntaje(), 0.01);
    }

    @Test
    public void losPuntosDeUnaPersonaVulnerableQueNoColaboroEs0() {

        PersonaJuridica personaJ1 = new PersonaJuridica(formGenerico);

        assertEquals(0, personaJ1.calcularPuntaje(), 0.01);
    }

    @Test
    public void losPuntosDeUnaPersonaVulnerableQueDono30y110y59() {
        DonarDinero donacion30 = new DonarDinero(30, LocalDate.now(), MENSUAL, tipoDonarDinero);
        DonarDinero donacion110 = new DonarDinero(110, LocalDate.now(), MENSUAL, tipoDonarDinero);
        DonarDinero donacion59 = new DonarDinero(59, LocalDate.now(), MENSUAL, tipoDonarDinero);


        PersonaJuridica personaJ1 = new PersonaJuridica(formGenerico);

        personaJ1.registrarColaboracion(donacion30);
        personaJ1.registrarColaboracion(donacion110);
        personaJ1.registrarColaboracion(donacion59);


        assertEquals(116.00, personaJ1.calcularPuntaje(), 0.01);
    }

}