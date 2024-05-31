package Persona;

import lombok.Setter;

public class Tecnico
{
    @Setter
    private String nombre;
    @Setter
    private Documento documento;
    @Setter
    private Integer cuil;
    @Setter
    private MedioDeContacto contacto;
    @Setter
    private AreaDeCobertura cobertura;

    public Tecnico(String nombre, Documento documento, Integer cuil, MedioDeContacto contacto, AreaDeCobertura cobertura)
    {
        this.nombre = nombre;
        this.documento = documento;
        this.cuil = cuil;
        this.contacto = contacto;
        this.cobertura = cobertura;
    }
// Entiéndase a:
//      Alta de técnico: instanciación de esta clase.
//      Baja de técnico: método que elimine a un técnico de una lista o base de datos (no pertenece a esta capa).
//      Modificación de técnico: utilización de setters de los atributos para modificar su informacion.

}
