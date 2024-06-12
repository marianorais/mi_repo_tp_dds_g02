package Heladera;

import DatosDePersonas.Direccion;
import DatosDePersonas.Ubicacion;

import java.time.LocalDate;

public class Heladera {
    private Ubicacion ubicacion;
    private Direccion direccion;
    private String nombre;
    private LocalDate fechaPuestaEnFuncionamiento;
    private Boolean activa;
    private Integer cantViandas;
    private Double temperaturaMinima;
    private Double temperaturaMaxima;
    private Double temperaturaActual;
    private Boolean sensorMovimientoActivado;

    // Siento que es demasiado grande el constructor
    public Heladera(Ubicacion ubicacion, Direccion direccion, String nombre, LocalDate fechaPuestaEnFuncionamiento, Boolean activa, Integer cantViandas, Double temperaturaMinima, Double temperaturaMaxima, Double temperaturaActual, Boolean sensorMovimientoActivado) {
        this.ubicacion = ubicacion;
        this.direccion = direccion;
        this.nombre = nombre;
        this.fechaPuestaEnFuncionamiento = fechaPuestaEnFuncionamiento;
        this.activa = activa;
        this.cantViandas = cantViandas;
        this.temperaturaMinima = temperaturaMinima;
        this.temperaturaMaxima = temperaturaMaxima;
        this.temperaturaActual = temperaturaActual;
        this.sensorMovimientoActivado = sensorMovimientoActivado;
    }

    // TODO - No entiendo porque estos métodos están tanto en la clase de la vianda como acá, REVISAR!!
    public void agregarVianda(){

    }

    public void sacarVianda(){

    }
}
