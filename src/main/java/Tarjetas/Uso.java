package Tarjetas;

import java.time.LocalDate;
import Heladera.*;
import lombok.Data;
import lombok.Getter;
@Data
public class Uso {
    private LocalDate fecha;
    private Heladera heladera;
    private Vianda vianda;

    public Uso(LocalDate fecha, Heladera heladera, Vianda vianda) {
        this.fecha = fecha;
        this.heladera = heladera;
        this.vianda = vianda;
    }
}
