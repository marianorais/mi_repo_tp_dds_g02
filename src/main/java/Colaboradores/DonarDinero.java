package Colaboradores;

import Formularios.Formulario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;


public class DonarDinero implements Colaboracion{

    private float monto;

    private LocalDate fecha;
    private Frecuencia frecuencia; //no definimos como hacer esto
    TipoColaboracion tipoColab ;

    public DonarDinero(float monto, LocalDate fecha, Frecuencia frecuencia, TipoColaboracion tipoColab) {
        this.monto =monto; //no deberia ser negativo esto no se como se maneja ni donde?
        this.frecuencia= frecuencia;
        this.fecha=fecha;
        this.tipoColab =tipoColab;
    }
    @Override
    public double calcularPuntaje() {
        return monto * tipoColab.getCoeficiente();
    }
}
