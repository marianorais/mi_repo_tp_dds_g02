package Tarjetas;

import Personas.PersonaVulnerable;
import Excepciones.*;
import lombok.Data;
import lombok.Getter;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
@Data
public class TarjetaAlimentaria {
    private  String codigo;
    private  Integer menoresACargo;
    private Integer limiteUsosDiarios;
    private final List<Uso> usos;

    public TarjetaAlimentaria(String codigo, Integer menoresACargo) {
        this.codigo = codigo;
        this.menoresACargo = menoresACargo;
        this.limiteUsosDiarios = 4 + 2 * this.menoresACargo;
        this.usos = new ArrayList<>();
    }

    public TarjetaAlimentaria() {
        this.usos = new ArrayList<>();
    }

    public Uso ultimoUso(){
        return this.usos.get(this.usos.size() - 1);
    }

    public void restaurarLimite(){ // solo reestablece cuando se cambia de día
        if(this.usos.isEmpty())
            return;

        LocalDate fechaActual = LocalDate.now();
        Uso ultimoUso = this.ultimoUso();
        if(!fechaActual.equals(ultimoUso.getFecha())) // si la fecha del último uso registrado es diferente a la fecha actual, entonces significa que el día cambió y debe reestablecerse el límite a su valor original.
            this.limiteUsosDiarios = 4 + 2 * this.menoresACargo;
    }

    public boolean puedeUsarse() {
        this.restaurarLimite();
        return this.limiteUsosDiarios > 0;
    }

    public void registrarUso(Uso uso) throws LimiteDiarioAlcanzadoException {
        if(this.puedeUsarse()){
            usos.add(uso);
            this.limiteUsosDiarios--;
        } else
            throw new LimiteDiarioAlcanzadoException("No se puede agregar el uso, se ha alcanzado el límite diario.");
    }

    private String generarCodigo() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int longitudCodigo = 11;
        SecureRandom random = new SecureRandom();
        StringBuilder codigoBuilder = new StringBuilder(longitudCodigo);
        for (int i = 0; i < longitudCodigo; i++) {
            int index = random.nextInt(caracteres.length());
            codigoBuilder.append(caracteres.charAt(index));
        }
        return codigoBuilder.toString();
    }
}
