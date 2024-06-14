package Personas.Test;

import Colaboradores.*;
import DatosDePersonas.Calle;
import DatosDePersonas.Direccion;
import DatosDePersonas.Ubicacion;
import Formularios.Formulario;
import Heladera.Heladera;
import Heladera.Vianda;
import Personas.PersonaFisica;
import Tarjetas.TarjetaAlimentaria;
import org.junit.Test;

import java.time.LocalDate;

import static Colaboradores.Frecuencia.MENSUAL;
import static org.junit.Assert.assertEquals;

public class PersonaFisicaTest {
    TipoColaboracion tipoDonarDinero = new TipoColaboracion(0.5);
    TipoColaboracion tipoRegistrarPersonaVulnerable = new TipoColaboracion(2);
    TipoColaboracion tipoDonarVianda = new TipoColaboracion(1.5);
    Heladera h1 = new Heladera(new Ubicacion(12.00,45.23),new Direccion(3000,new Calle("Medriano")),
            "Heladera Medrano",LocalDate.of(2000,10,9),Boolean.TRUE,15,
            1.31, 40.62,15.87,Boolean.TRUE);
    Vianda viandaPrueba = new Vianda("Milanesas",LocalDate.of(2024,12,30),LocalDate.now(),
            h1,2300.00,1.00,Boolean.TRUE);
    Formulario formGenerico = new Formulario();

    TarjetaAlimentaria t1 = new TarjetaAlimentaria();

    TarjetaAlimentaria t2 = new TarjetaAlimentaria();
    TarjetaAlimentaria t3 = new TarjetaAlimentaria();
    @Test
    public void losPuntosDeUnaPersonaVulnerableQueDono30YDistribuyo15Es30() {
        DonarDinero donacion30 = new DonarDinero(30, LocalDate.now(),MENSUAL,tipoDonarDinero);
        RegistrarPersonaVulnerable registro1 = new RegistrarPersonaVulnerable(t1,tipoRegistrarPersonaVulnerable);

        PersonaFisica personaF1 = new PersonaFisica(formGenerico);
        personaF1.registrarColaboracion(donacion30);
        personaF1.registrarColaboracion(registro1);

        assertEquals(17.00, personaF1.calcularPuntaje(),0.01);
    }
    @Test
    public void losPuntosDeUnaPersonaVulnerableQueNoColaboroEs0() {

        PersonaFisica personaF1 = new PersonaFisica(formGenerico);

        assertEquals(0, personaF1.calcularPuntaje(),0.01);
    }
    @Test
    public void losPuntosDeUnaPersonaVulnerableQueDono30y110y59YDistribuyo15YDonoViandaEs116s() {
        DonarDinero donacion30 = new DonarDinero(30, LocalDate.now(),MENSUAL,tipoDonarDinero);
        DonarVianda donacionVianda = new DonarVianda(viandaPrueba, tipoDonarVianda);
        DonarDinero donacion110 = new DonarDinero(110, LocalDate.now(),MENSUAL,tipoDonarDinero);
        DonarDinero donacion59 = new DonarDinero(59, LocalDate.now(),MENSUAL,tipoDonarDinero);

        RegistrarPersonaVulnerable registro1 = new RegistrarPersonaVulnerable(t1,tipoRegistrarPersonaVulnerable);

        RegistrarPersonaVulnerable registro2 = new RegistrarPersonaVulnerable(t2,tipoRegistrarPersonaVulnerable);

        RegistrarPersonaVulnerable registro3 = new RegistrarPersonaVulnerable(t3,tipoRegistrarPersonaVulnerable);

        PersonaFisica personaF1 = new PersonaFisica(formGenerico);

        personaF1.registrarColaboracion(donacion30);
        personaF1.registrarColaboracion(donacion110);
        personaF1.registrarColaboracion(donacion59);
        personaF1.registrarColaboracion(donacionVianda);
        personaF1.registrarColaboracion(registro1);
        personaF1.registrarColaboracion(registro2);
        personaF1.registrarColaboracion(registro3);


        assertEquals(107.00, personaF1.calcularPuntaje(),0.01);
    }
}
