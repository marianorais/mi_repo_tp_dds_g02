package Colaboradores;

import Heladera.Heladera;
import Heladera.Vianda;

public class DonarVianda implements Colaboracion{

    private Vianda vianda;
    private TipoColaboracion tipoColab;

    public DonarVianda(Vianda vianda, TipoColaboracion tipoColab) {
        this.vianda = vianda;
        this.tipoColab = tipoColab;

        // agregarVianda(vianda); ??
    }


    @Override
    public double calcularPuntaje() {
        return tipoColab.getCoeficiente();
    }
}
