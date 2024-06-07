package Colaboradores;

import Heladera.Heladera;

import java.util.Date;

public class HacerseCargoHeladera implements Colaboracion{

    private Heladera heladera;
    private Date fecha;
    private TipoColaboracion tipoColab;

    public HacerseCargoHeladera(Heladera heladera, Date fecha, TipoColaboracion tipoColab) {
        this.heladera = heladera;
        this.fecha = fecha;
        this.tipoColab = tipoColab;
    }


    @Override
    public double calcularPuntaje() {
        return mesesQuePasaron(this.fecha)* tipoColab.getCoeficiente(); //me suena que tendiramos que poner un if heladera esta activa
    }
    private int mesesQuePasaron(Date fecha){
        return 3;
    }
}
