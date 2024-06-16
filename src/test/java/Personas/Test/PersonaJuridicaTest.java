package Personas.Test;

import Colaboradores.DistribuirVianda;
import Colaboradores.DonarDinero;
import Colaboradores.DonarVianda;
import Colaboradores.TipoColaboracion;
import Formularios.Formulario;
import Heladera.Vianda;

import Personas.Oferta;
import Personas.PersonaFisica;
import Personas.PersonaJuridica;
import org.junit.Test;

import java.time.LocalDate;

import static Colaboradores.Frecuencia.MENSUAL;
import static DatosDePersonas.Rubro.Gastronomia;
import static org.junit.Assert.assertEquals;

public class PersonaJuridicaTest {
    TipoColaboracion tipoDonarDinero = new TipoColaboracion(0.5);
    TipoColaboracion tipoHacerseCargoHeladera = new TipoColaboracion(5);
    TipoColaboracion tipoDistribuirVianda = new TipoColaboracion(1);
    Formulario formGenerico = new Formulario();
    Oferta of1= new Oferta("Burguer luchada",30.00, Gastronomia);
    @Test
    public void losPuntosDeUnaPersonaJuridicaQueDono30YDistribuyo15Es30() {
        DonarDinero donacion30 = new DonarDinero(30, LocalDate.now(), MENSUAL, tipoDonarDinero);
        DistribuirVianda distribucion15 = new DistribuirVianda(15, tipoDistribuirVianda);

        PersonaJuridica personaJ1 = new PersonaJuridica(formGenerico);

        personaJ1.registrarColaboracion(donacion30);
        personaJ1.registrarColaboracion(distribucion15);

        assertEquals(30.00, personaJ1.calcularPuntaje(), 0.01);
    }

    @Test
    public void losPuntosDeUnaPersonaJuridicaQueNoColaboroEs0() {

        PersonaJuridica personaJ1 = new PersonaJuridica(formGenerico);

        assertEquals(0, personaJ1.calcularPuntaje(), 0.01);
    }

    @Test
    public void losPuntosDeUnaPersonaJuridicaQueDono30y110y59() {
        DonarDinero donacion30 = new DonarDinero(30, LocalDate.now(), MENSUAL, tipoDonarDinero);
        DonarDinero donacion110 = new DonarDinero(110, LocalDate.now(), MENSUAL, tipoDonarDinero);
        DonarDinero donacion59 = new DonarDinero(59, LocalDate.now(), MENSUAL, tipoDonarDinero);


        PersonaJuridica personaJ1 = new PersonaJuridica(formGenerico);

        personaJ1.registrarColaboracion(donacion30);
        personaJ1.registrarColaboracion(donacion110);
        personaJ1.registrarColaboracion(donacion59);


        assertEquals(99.50, personaJ1.calcularPuntaje(), 0.01);
    }

    @Test
    public void unaPersonaCanjeaPuntosParaUnaOferta(){
        DonarDinero donacion30 = new DonarDinero(30, LocalDate.now(),MENSUAL,tipoDonarDinero);
        DonarDinero donacion110 = new DonarDinero(110, LocalDate.now(),MENSUAL,tipoDonarDinero);
        DonarDinero donacion59 = new DonarDinero(59, LocalDate.now(),MENSUAL,tipoDonarDinero);

        PersonaFisica personaF1 = new PersonaFisica(formGenerico);

        personaF1.registrarColaboracion(donacion30);
        personaF1.registrarColaboracion(donacion110);
        personaF1.registrarColaboracion(donacion59);

        assertEquals(99.50, personaF1.calcularPuntaje(),0.01);

        personaF1.canjearPuntos(of1);

        assertEquals(69.50, personaF1.calcularPuntaje(),0.01);
    }
}