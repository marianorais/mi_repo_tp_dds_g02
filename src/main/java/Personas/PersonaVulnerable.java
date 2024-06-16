package Personas;

import java.time.LocalDate;
import DatosDePersonas.*;
import Usuario.*;
import Tarjetas.*;
import lombok.Data;
import lombok.Getter;
import Excepciones.*;

@Data
public class PersonaVulnerable {
    private String nombre;
    private LocalDate fechaNacimiento;
    private LocalDate fechaRegistro;
    private Boolean situacionDeCalle;
    private Direccion domicilio;
    private Documento tipoDocumento;
    private String numDocumento;
    private Integer menoresACargo;
    private Usuario usuario;
    private PersonaFisica registrador;
    private TarjetaAlimentaria tarjeta;

    public PersonaVulnerable(String nombre, LocalDate fechaNacimiento, LocalDate fechaRegistro,
                             Boolean situacionDeCalle, Direccion domicilio, Documento tipoDocumento,
                             String numDocumento, Integer cantMenoresACargo, Usuario usuario,
                             PersonaFisica registrador, TarjetaAlimentaria tarjeta)
    {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaRegistro = fechaRegistro;
        this.situacionDeCalle = situacionDeCalle;
        this.domicilio = domicilio;
        this.tipoDocumento = tipoDocumento;
        this.numDocumento = numDocumento;
        this.menoresACargo = cantMenoresACargo;
        this.usuario = usuario;
        this.registrador = registrador;
        this.tarjeta = tarjeta;
    }

    public void usarTarjeta(Uso uso) throws LimiteDiarioAlcanzadoException {
        this.tarjeta.registrarUso(uso);
    }
}
