package Persona;

import Colaboradores.Colaboracion;
import Colaboradores.TipoColaboracion;
import Formularios.Formulario;

import java.util.ArrayList;
import java.util.List;

public class PersonaFisica {
    private List<Formulario> formulariosRespondidos;

    private List<Colaboracion> colaboracionesRealizadas;
    private List<TipoColaboracion> colaboracionesPermitidas;

    public PersonaFisica(Formulario formulario) {
        this.formulariosRespondidos = new ArrayList<>();
        this.formulariosRespondidos.add(formulario);
    }

    public double calcularPuntaje(){
        return colaboracionesRealizadas.stream()
                                        .mapToDouble(colaboracion->colaboracion.calcularPuntaje())
                                        .sum();
    }
    public void registrarColaboracion(){
    //TODO
    }
    public void canjearPuntos(){
        //TODO
    }
    public void agregarFormulario(Formulario formulario){
        this.formulariosRespondidos.add(formulario);
    }

}
