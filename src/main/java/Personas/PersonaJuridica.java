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

    private List<Oferta> productosOfrecidos;

    public PersonaJuridica(Formulario formulario) {
        this.colaboracionesRealizadas = new ArrayList<>();
        this.colaboracionesPermitidas = new ArrayList<>();
        this.formulariosRespondidos = new ArrayList<>();
        this.formulariosRespondidos.add(formulario);
    }
    public double calcularPuntaje(){
        return colaboracionesRealizadas.stream()
                .mapToDouble(colaboracion->colaboracion.calcularPuntaje())
                .sum();
    }
    public void ofrecerProductos(Oferta oferta){
        this.productosOfrecidos.add(oferta);
    }

    public void registrarColaboracion(Colaboracion colaboracion){
        this.colaboracionesRealizadas.add(colaboracion);
    }
    public void canjearPuntos(){
        //TODO
    }
    public void agregarFormulario(Formulario formulario){
        this.formulariosRespondidos.add(formulario);
    }
}
