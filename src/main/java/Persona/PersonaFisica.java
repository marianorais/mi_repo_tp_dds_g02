package Persona;

import Formularios.Formulario;

import java.util.ArrayList;
import java.util.List;

public class PersonaFisica {
    private List<Formulario> formulariosRespondidos;

    public PersonaFisica(Formulario formulario) {
        this.formulariosRespondidos = new ArrayList<>();
        this.formulariosRespondidos.add(formulario);
    }
    public void agregarFormulario(Formulario formulario){
        this.formulariosRespondidos.add(formulario);
    }

}
