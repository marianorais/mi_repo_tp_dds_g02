package TarjetaAlimentaria;

import Persona.PersonaVulnerable;
import java.util.List;
import java.util.ArrayList;

public class TarjetaAlimentaria {
    private String codigo;
    private PersonaVulnerable titular; //entiendase al titular de una tarjeta a la persona vulnerable a cargo de la misma.
    private Integer limiteUsosDiarios;
    private List<Uso> usos;

    public TarjetaAlimentaria(String codigo, PersonaVulnerable titular) {
        this.codigo = codigo;
        this.titular = titular;
        this.limiteUsosDiarios = 4 + 2 * titular.getCantMenoresACargo();
        this.usos = new ArrayList<>();
    }

    public Boolean puedeUsarse() {
        if (this.limiteUsosDiarios > 0)
            return true;
        else
            return false;
    }

    public void registrarUso(Uso uso)
    {
        usos.add(uso);
    }

}
