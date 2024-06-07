package Colaboradores;

import Tarjetas.TarjetaAlimentaria;

public class RegistrarPersonaVulnerable implements Colaboracion{

    private TarjetaAlimentaria tarjeta;
    private TipoColaboracion tipoColab;

    public RegistrarPersonaVulnerable(TarjetaAlimentaria tarjeta, TipoColaboracion tipoColab) {
        this.tarjeta = tarjeta;
        this.tipoColab = tipoColab;
    }

    @Override
    public double calcularPuntaje() {
        return tipoColab.getCoeficiente();
    }
}
