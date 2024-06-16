package Personas;

import Colaboradores.Colaboracion;
import Colaboradores.TipoColaboracion;
import Formularios.Formulario;
import Heladera.Heladera;
import RecomendacionesUbicacion.RecomendadorUbicacion;
import Usuario.Usuario;

import java.util.ArrayList;
import java.util.List;

public class PersonaJuridica{

    private List<Heladera> heladerasACargo;
    private RecomendadorUbicacion recomendador;
    private Usuario usuario;
    private List<Formulario> formulariosRespondidos;

    private List<Colaboracion> colaboracionesRealizadas;
    private List<TipoColaboracion> colaboracionesPermitidas;

    private List<Oferta> productosOfrecidos;
    private Double puntosCanjeados;

    public PersonaJuridica(Formulario formulario) {
        this.colaboracionesRealizadas = new ArrayList<>();
        this.colaboracionesPermitidas = new ArrayList<>();
        this.formulariosRespondidos = new ArrayList<>();
        this.formulariosRespondidos.add(formulario);
        this.puntosCanjeados=0.00;
    }
    public double calcularPuntaje(){
        return colaboracionesRealizadas.stream()
                .mapToDouble(colaboracion->colaboracion.calcularPuntaje())
                .sum() - puntosCanjeados;
    }
    public void ofrecerProducto(Oferta oferta){
        this.productosOfrecidos.add(oferta);
    }

    public void registrarColaboracion(Colaboracion colaboracion){
        this.colaboracionesRealizadas.add(colaboracion);
    }
    public void canjearPuntos(Oferta oferta){
        if(oferta.cantPuntosNecesarios<= this.calcularPuntaje()){
            //adquiere el producto
            puntosCanjeados+= oferta.cantPuntosNecesarios;
        }
    }

    public void agregarFormulario(Formulario formulario){
        this.formulariosRespondidos.add(formulario);
    }
}
