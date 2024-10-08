package Colaboradores;

import Heladera.Heladera;

import java.time.LocalDate;

public class DistribuirVianda implements Colaboracion{

    private LocalDate fecha;
    private int cantidadViandas;
    private Heladera heladeraOrigen;
    private Heladera heladeraDestino;
    private String motivo;
    private TipoColaboracion tipoColab;

    // TODO - Dejamos los dos, para no perjudidar el validador de contraseñas, después lo corregimos.
    public DistribuirVianda(int cantidadViandas, Heladera heladeraOrigen, Heladera heladeraDestino, String motivo, TipoColaboracion tipoColab) {
        this.cantidadViandas = cantidadViandas;
        this.heladeraOrigen = heladeraOrigen;
        this.heladeraDestino = heladeraDestino;
        this.motivo = motivo;
        this.tipoColab = tipoColab;
    }
    public DistribuirVianda(int cantidadViandas, TipoColaboracion tipoColab) {
        this.cantidadViandas = cantidadViandas;
        this.tipoColab = tipoColab;
    }

    @Override
    public double calcularPuntaje() {
        return tipoColab.getCoeficiente() * cantidadViandas;
    }
}
