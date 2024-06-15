package Repositorios;

import Personas.Tecnico;

import java.util.ArrayList;

public class TecnicosRepository {
    private ArrayList<Tecnico> tecnicos;

    public TecnicosRepository(){
        this.tecnicos = new ArrayList<>();
    }

    public void guardar(Tecnico tecnico){
        tecnicos.add(tecnico);
    }
    public void eliminar(Tecnico tecnico){
        //TODO
    }

}
