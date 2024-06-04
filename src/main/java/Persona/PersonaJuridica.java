package Persona;

import Colaboradores.Colaborador;
import DatosDePersonas.*;
import Formularios.Formulario;
import Usuario.Usuario;

import java.util.ArrayList;
import java.util.List;

public class PersonaJuridica extends Colaborador {

    /* FALTAN ESTOS ATRIBUTOS
    - heladerasACargo : List<Heladera>
    - recomendador : RecomendadorUbicacion*/
    private Usuario usuario;
    private List<Formulario> formulariosRespondidos;

    public PersonaJuridica(Formulario formulario) {
        this.formulariosRespondidos = new ArrayList<>();
        this.formulariosRespondidos.add(formulario);
    }

    public Oferta ofrecerProductos(){
        return new Oferta();
    }

    public void agregarFormulario(Formulario formulario){
        this.formulariosRespondidos.add(formulario);
    }
}
