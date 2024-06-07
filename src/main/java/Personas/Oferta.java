package Personas;

import DatosDePersonas.Rubro;
import lombok.Getter;

public class Oferta {
    String nombre;
    @Getter
    Double cantPuntosNecesarios;
    Rubro rubro;
}
