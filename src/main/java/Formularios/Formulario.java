package Formularios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Formulario {
    private Map<String, String> datos = new HashMap<>();
    private List<Pregunta> preguntasList = new ArrayList<>();

    public void agregarDato(String pregunta, String respuesta) {
        datos.put(pregunta, respuesta);
    }
    public void agregarPreguntas(Pregunta... preguntas) {
        for (Pregunta pregunta : preguntas) {
            Pregunta nuevaPregunta = new Pregunta(pregunta.getPregunta(), pregunta.getRespuesta());
            this.preguntasList.add(nuevaPregunta);
        }
    }
    public Map<String, String> getDatos() {
        return datos;
    }
}
