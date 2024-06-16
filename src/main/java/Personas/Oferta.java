package Personas;

import DatosDePersonas.Rubro;
import lombok.Getter;

public class Oferta {
    String nombre;
    @Getter
    Double cantPuntosNecesarios;
    Rubro rubro;

    public Oferta(String nombre, Double cantPuntosNecesarios, Rubro rubro) {
        this.nombre = nombre;
        this.cantPuntosNecesarios = cantPuntosNecesarios;
        this.rubro = rubro;
    }
}
