package Colaboradores;

import Persona.Oferta;
import Usuario.Usuario;
import Varios.Direccion;
import Varios.medioDeContacto;

public class Colaborador {
    private Direccion direccion;
    private medioDeContacto medioDeContacto;
    private Usuario usuario;
    private Colaboraciones colaboraciones;

    public double puntaje(){
        return colaboraciones.calcularPuntajeTotal();
    }
    public void canjearPuntos(Oferta oferta){
        //se gana los productos de la oferta?
        colaboraciones.setPuntosCanjeados(oferta.getCantPuntosNecesarios());

    }
}
