package Heladera;

import java.time.LocalDate;

public class Vianda {

    // Los related problems son por los test que no usan el constructor
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
    // private Colaborador colaborador -- // TODO - no existe la clase Colaborador ahora
    private Double calorias;
    private Double peso;
    private Boolean estadoEntrega;

    public void entregar() {

    }
}
