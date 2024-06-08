package Personas;

import Colaboradores.Colaboracion;
import Colaboradores.TipoColaboracion;
import Formularios.Formulario;
import Usuario.Usuario;

import java.util.ArrayList;
import java.util.List;

public class PersonaJuridica{

    /* FALTAN ESTOS ATRIBUTOS
    - heladerasACargo : List<Heladera>
    - recomendador : RecomendadorUbicacion*/
    private Usuario usuario;
    private List<Formulario> formulariosRespondidos;

    private List<Colaboracion> colaboracionesRealizadas;
    private List<TipoColaboracion> colaboracionesPermitidas;

    public PersonaJuridica(Formulario formulario) {
        this.formulariosRespondidos = new ArrayList<>();
        this.formulariosRespondidos.add(formulario);
    }
    public double calcularPuntaje(){
        return colaboracionesRealizadas.stream()
                .mapToDouble(colaboracion->colaboracion.calcularPuntaje())
                .sum();
    }
    public Oferta ofrecerProductos(){
        return new Oferta();
    }
    public void registrarColaboracion(){
        //TODO
    }
    public void canjearPuntos(){
        //TODO
    }
    public void agregarFormulario(Formulario formulario){
        this.formulariosRespondidos.add(formulario);
    }
}
