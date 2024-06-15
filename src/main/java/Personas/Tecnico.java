package Personas;

import DatosDePersonas.*;
import lombok.Data;
import lombok.Setter;
@Data
public class Tecnico {
    private String nombre;
    private Documento tipoDocumento;
    private String numDocumento;
    private Integer cuil;
    private medioDeContacto contacto;
    private AreaDeCobertura cobertura;

    public Tecnico(String nombre, Documento documento, Integer cuil, medioDeContacto contacto, AreaDeCobertura cobertura){
        this.nombre = nombre;
        this.tipoDocumento = documento;
        this.cuil = cuil;
        this.contacto = contacto;
        this.cobertura = cobertura;
    }

}
