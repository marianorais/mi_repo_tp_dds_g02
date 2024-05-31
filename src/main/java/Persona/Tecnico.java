package Persona;

import DatosDePersonas.*;
import lombok.Setter;

public class Tecnico
{
    @Setter
    private String nombre;
    @Setter
    private Documento tipoDocumento;
    @Setter
    private String numDocumento;
    @Setter
    private Integer cuil;
    @Setter
    private medioDeContacto contacto;
    @Setter
    private AreaDeCobertura cobertura;

    public Tecnico(String nombre, Documento documento, Integer cuil, medioDeContacto contacto, AreaDeCobertura cobertura)
    {
        this.nombre = nombre;
        this.tipoDocumento = documento;
        this.cuil = cuil;
        this.contacto = contacto;
        this.cobertura = cobertura;
    }
// Entiéndase a:
//      Alta de técnico: instanciación de esta clase.
//      Baja de técnico: método que elimine a un técnico de una lista o base de datos (no pertenece a esta capa).
//      Modificación de técnico: utilización de setters de los atributos para modificar su informacion.

}
