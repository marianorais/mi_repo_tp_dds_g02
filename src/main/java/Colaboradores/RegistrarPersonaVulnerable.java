package Colaboradores;

import Tarjetas.TarjetaAlimentaria;

import java.time.LocalDate;

public class RegistrarPersonaVulnerable implements Colaboracion{

    private TarjetaAlimentaria tarjeta;
    private TipoColaboracion tipoColab;
    private LocalDate fecha;

    public RegistrarPersonaVulnerable(TarjetaAlimentaria tarjeta, TipoColaboracion tipoColab) {
        this.tarjeta = tarjeta;
        this.tipoColab = tipoColab;
    }

    @Override
    public double calcularPuntaje() {
        return tipoColab.getCoeficiente();
    }
}
