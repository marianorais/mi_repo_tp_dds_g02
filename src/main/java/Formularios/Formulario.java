package Formularios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Formulario {
    private List<Pregunta> preguntasList = new ArrayList<>();

    public void agregarPreguntas(Pregunta... preguntas) {
        for (Pregunta pregunta : preguntas) {
            this.preguntasList.add(pregunta);
        }
    }
}
