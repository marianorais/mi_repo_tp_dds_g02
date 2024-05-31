package Persona;

import java.time.LocalDate;
import DatosDePersonas.*;
import Usuario.*;
import TarjetaAlimentaria.*;
import lombok.Getter;

public class PersonaVulnerable {
    private String nombre;
    private LocalDate fechaNacimiento;
    private LocalDate fechaRegistro;
    private Boolean situacionDeCalle;
    private Direccion domicilio;
    private Documento tipoDocumento;
    private String numDocumento;
    private Boolean menoresACargo;
    @Getter
    private Integer cantMenoresACargo; // creo que con solo este atributo alcanza, no es necesario el de arriba
    private Usuario usuario;
    private PersonaFisica registrador;
    private TarjetaAlimentaria tarjeta;

    public PersonaVulnerable(String nombre, LocalDate fechaNacimiento, LocalDate fechaRegistro,
                             Boolean situacionDeCalle, Direccion domicilio, Documento tipoDocumento,
                             String numDocumento, Boolean menoresACargo, Integer cantMenoresACargo,
                             Usuario usuario, PersonaFisica registrador, TarjetaAlimentaria tarjeta)
    {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaRegistro = fechaRegistro;
        this.situacionDeCalle = situacionDeCalle;
        this.domicilio = domicilio;
        this.tipoDocumento = tipoDocumento;
        this.numDocumento = numDocumento;
        this.menoresACargo = menoresACargo;
        this.cantMenoresACargo = cantMenoresACargo;
        this.usuario = usuario;
        this.registrador = registrador;
        this.tarjeta = tarjeta;
    }
}
