package Persona;

import Colaboradores.Colaborador;

public class PersonaJuridica extends Colaborador {

    String razonSocial;
    Rubro rubro;
    TipoPersonaJuridica tipo;

    /* FALTAN ESTOS ATRIBUTOS
    - heladerasACargo : List<Heladera>
    - recomendador : RecomendadorUbicacion*/
    public Oferta ofrecerProductos(){
        return new Oferta();
    }
}
