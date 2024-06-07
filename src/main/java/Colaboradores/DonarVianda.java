package Colaboradores;

import Heladera.Vianda;

public class DonarVianda implements Colaboracion{

    private Vianda vianda;
    private TipoColaboracion tipoColab;

    public DonarVianda(Vianda vianda, TipoColaboracion tipoColab) {
        this.vianda = vianda;
        this.tipoColab = tipoColab;
    }


    @Override
    public double calcularPuntaje() {
        return tipoColab.getCoeficiente();
    }
}
