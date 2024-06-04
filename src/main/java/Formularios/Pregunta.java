package Formularios;

import java.util.Map;

public class Pregunta {

    private String pregunta;
    private String respuesta;

    public Pregunta(String pregunta, String respuesta) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    public String getPregunta() {
        return this.pregunta;
    }
    public String getRespuesta() {
        return this.respuesta;
    }
}
