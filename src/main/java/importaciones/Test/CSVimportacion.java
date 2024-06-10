package importaciones.Test;

import Colaboradores.*;
import Formularios.Formulario;
import Formularios.Pregunta;
import Heladera.Heladera;
import Heladera.Vianda;
import Personas.PersonaFisica;
import Personas.PersonaJuridica;
import Tarjetas.TarjetaAlimentaria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Colaboradores.Frecuencia.MENSUAL;

public class CSVimportacion {
    private List<PersonaJuridica> personasJuridicas ;
    private List<PersonaFisica> personasFisicas;

    public CSVimportacion(){
        personasJuridicas = new ArrayList<>();
        personasFisicas = new ArrayList<>();
    }

    public void importData(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            String separator = ",";
            br.readLine();
            while ((line = br.readLine()) != null) {

                String[] data = line.split(separator);

                //Normalizo datos
                String documento =  data[0];
                String nroDoc = data[1];
                String nombre = data[2];
                String apellido = data[3];
                String email = data[4];
                String fecha = data[5];
                String donacion = data[6];
                String cantidad = data[7];

                //Creo el formulario con los datos
                Formulario nuevoFormulario = crearFormulario(documento,nroDoc,nombre,apellido,email,fecha);

                switch(donacion.toUpperCase()){
                    case "DINERO":
                        PersonaJuridica personaJuridica = new PersonaJuridica(nuevoFormulario);
                        TipoColaboracion tipoDonarDinero = new TipoColaboracion(0.5);
                        Colaboracion colaboracion = new DonarDinero(Float.parseFloat(cantidad), LocalDate.now(), MENSUAL, tipoDonarDinero);
                        personaJuridica.registrarColaboracion(colaboracion);
                        this.personasJuridicas.add(personaJuridica);
                        break;
                    case "DONACION_VIANDAS":
                        PersonaFisica personaFisica = new PersonaFisica(nuevoFormulario);
                        TipoColaboracion tipoDonarVianda = new TipoColaboracion(0.5);
                        Vianda vianda = new Vianda();
                        Colaboracion colaboracionViandas = new DonarVianda(vianda, tipoDonarVianda);
                        personaFisica.registrarColaboracion(colaboracionViandas);
                        this.personasFisicas.add(personaFisica);
                        break;
                    case "REDISTRIBUCION_VIANDAS":
                        PersonaFisica personaFisica2 = new PersonaFisica(nuevoFormulario);
                        TipoColaboracion tipoDistribuirVianda = new TipoColaboracion(0.5);
                        Colaboracion colaboracionRedistribucionVianda = new DistribuirVianda(Integer.parseInt(cantidad), tipoDistribuirVianda);
                        personaFisica2.registrarColaboracion(colaboracionRedistribucionVianda);
                        this.personasFisicas.add(personaFisica2);
                        break;
                    case "ENTREGA_TARJETAS":
                        PersonaFisica personaFisica3 = new PersonaFisica(nuevoFormulario);
                        TipoColaboracion tipoRegistrarVulnerable = new TipoColaboracion(0.5);
                        Colaboracion colaboracionRegistroVulnerable = new RegistrarPersonaVulnerable(new TarjetaAlimentaria(), tipoRegistrarVulnerable);
                        personaFisica3.registrarColaboracion(colaboracionRegistroVulnerable);
                        this.personasFisicas.add(personaFisica3);
                        break;
                    default:
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<PersonaJuridica> getPersonasJuridicas() {
        return this.personasJuridicas;
    }
    public List<PersonaFisica> getPersonasFisicas() {
        return this.personasFisicas;
    }

    private Formulario crearFormulario(String documento, String nroDoc, String nombre, String apellido, String email, String fecha) {
        Formulario nuevoFormulario = new Formulario();

        Pregunta preguntaDoc = new Pregunta("Documento",documento);
        Pregunta preguntaNroDoc = new Pregunta("NroDocumento",nroDoc);
        Pregunta preguntaNombre = new Pregunta("Nombre",nombre);
        Pregunta preguntaApellido = new Pregunta("Apellido",apellido);
        Pregunta preguntaEmail = new Pregunta("Email",email);
        Pregunta preguntaFecha = new Pregunta("Fecha",fecha);

        nuevoFormulario.agregarPreguntas(preguntaDoc,preguntaNroDoc,preguntaNombre,preguntaApellido,preguntaEmail,preguntaFecha);

        return nuevoFormulario;
    }
}
