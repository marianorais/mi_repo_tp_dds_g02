package Tarjetas;

import Personas.PersonaVulnerable;
import Excepciones.*;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class TarjetaAlimentaria {
    private String codigo;
    private Integer menoresACargo;
    @Getter
    private Integer limiteUsosDiarios;
    private List<Uso> usos;

    public TarjetaAlimentaria(String codigo, Integer menoresACargo) {
        this.codigo = codigo;
        this.menoresACargo = menoresACargo;
        this.limiteUsosDiarios = 4 + 2 * this.menoresACargo;
        this.usos = new ArrayList<>();
    }

    public Uso ultimoUso(){
        return this.usos.get(this.usos.size() - 1);
    }

    public void restaurarLimite(){ // solo reestablece cuando se cambia de día
        LocalDate fechaActual = LocalDate.now();
        Uso ultimoUso = this.ultimoUso();
        if(!fechaActual.equals(ultimoUso.getFecha())) // si la fecha del último uso registrado es diferente a la fecha actual, entonces significa que el día cambió y debe reestablecerse el límite a su valor original.
            this.limiteUsosDiarios = 4 + 2 * this.menoresACargo;
    }

    public boolean puedeUsarse() {
        this.restaurarLimite();
        if(this.limiteUsosDiarios > 0)
            return true;
        else
            return false;
    }

    public void registrarUso(Uso uso) throws LimiteDiarioAlcanzadoException {
        this.restaurarLimite();
        if(this.puedeUsarse()){
            usos.add(uso);
            this.limiteUsosDiarios--;
        } else {
            throw new LimiteDiarioAlcanzadoException("No se puede agregar el uso, se ha alcanzado el límite diario.");
        }
    }
}
