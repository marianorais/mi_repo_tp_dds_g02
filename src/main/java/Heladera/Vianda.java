package Heladera;

import Personas.PersonaFisica;
import lombok.Data;

import java.time.LocalDate;

@Data
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
    private PersonaFisica colaborador;
    private Double calorias;
    private Double peso;
    private Boolean estadoEntrega;

}
