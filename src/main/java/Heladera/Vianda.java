package Heladera;

import java.time.LocalDate;

public class Vianda {

    public Vianda(String comida, LocalDate caducidad, LocalDate fechaDonacion, Heladera heladera, Double calorias, Double peso, Boolean estadoEntrega) {
        this.comida = comida;
        this.caducidad = caducidad;
        this.fechaDonacion = fechaDonacion;
        this.heladera = heladera;
        this.calorias = calorias;
        this.peso = peso;
        this.estadoEntrega = estadoEntrega;
    }

    private String comida;
    private LocalDate caducidad;
    private LocalDate fechaDonacion;
    private Heladera heladera;
    // private Colaborador colaborador -- // TODO - no existe la clase Colaborador ahora, ver que ponemos
    private Double calorias;
    private Double peso;
    private Boolean estadoEntrega;

    public void entregar() {
      // TODO - Método vacio - No se que implica entregar la vianda, no lo encuentro en la consigna, supongo que es algo de lo que se encarga distribuir vianda (tipo de colaboracion)
    }
}
