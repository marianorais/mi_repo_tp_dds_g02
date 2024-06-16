package Personas;


import Colaboradores.Colaboracion;
import Colaboradores.TipoColaboracion;
import Formularios.Formulario;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class PersonaFisica {
    private List<Formulario> formulariosRespondidos;

    private List<Colaboracion> colaboracionesRealizadas;
    private List<TipoColaboracion> colaboracionesPermitidas;

    private Double puntosCanjeados;
    public PersonaFisica(Formulario formulario) {
        this.colaboracionesRealizadas = new ArrayList<>();
        this.colaboracionesPermitidas = new ArrayList<>();
        this.formulariosRespondidos = new ArrayList<>();
        this.formulariosRespondidos.add(formulario);
        this.puntosCanjeados=0.00;
    }

    public Double getPuntosCanjeados(){
        return puntosCanjeados;
    }
    public double calcularPuntaje(){
        return colaboracionesRealizadas.stream()
                                        .mapToDouble(colaboracion->colaboracion.calcularPuntaje())
                                        .sum() - puntosCanjeados;
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
