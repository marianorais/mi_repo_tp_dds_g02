package importaciones;

import Formularios.Formulario;
import Formularios.Pregunta;
import Persona.PersonaFisica;
import Persona.PersonaJuridica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
                String documento =  data[0]; //Enum tipo documento
                String nroDoc = data[1];
                String nombre = data[2];
                String apellido = data[3];
                String email = data[4];
                String fecha = data[5]; //Datetime fecha agregado
                String donacion = data[6]; //Tipo de donacion
                String cantidad = data[7]; //Cantidad donacion

                //Creo el formulario con los datos
                Formulario nuevoFormulario = crearFormulario(documento,nroDoc,nombre,apellido,email,fecha);

                // Imprimir todos los datos
                System.out.println(Arrays.toString(data));

                //TODO GUARDADO DE DATOS
                switch(donacion.toUpperCase()){
                    case "DINERO":
                        PersonaJuridica personaJuridica = new PersonaJuridica(nuevoFormulario);
                        this.personasJuridicas.add(personaJuridica);
                        break;
                    case "DONACION_VIANDAS":
                        PersonaFisica personaFisica = new PersonaFisica(nuevoFormulario);
                        this.personasFisicas.add(personaFisica);
                        break;
                    case "REDISTRIBUCION_VIANDAS":
                        PersonaFisica personaFisica2 = new PersonaFisica(nuevoFormulario);
                        this.personasFisicas.add(personaFisica2);
                        break;
                    case "ENTREGA_TARJETAS":
                        PersonaFisica personaFisica3 = new PersonaFisica(nuevoFormulario);
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
