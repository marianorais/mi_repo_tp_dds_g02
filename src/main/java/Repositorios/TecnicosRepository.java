package Repositorios;

import Personas.Tecnico;

import java.util.ArrayList;

import Excepciones.*;

 class TecnicosRepository implements ITecnicoRepository{
    private ArrayList<Tecnico> tecnicos;

    public TecnicosRepository(){
        this.tecnicos = new ArrayList<>();
    }

    @Override
    public void guardar(Tecnico tecnico){
        this.tecnicos.add(tecnico);
    }

    @Override
    public void eliminar(String numeroDocumento) throws TecnicoNoEncontradoException {
        this.tecnicos.remove(this.buscar(numeroDocumento));
    }

    @Override
    public void modificar(Tecnico tecnicoModificado) throws TecnicoNoEncontradoException {
        this.eliminar(tecnicoModificado.getNumDocumento());
        this.guardar(tecnicoModificado);
    }

    @Override
    public Tecnico buscar (String numeroDocumento) throws TecnicoNoEncontradoException {
        return tecnicos.stream()
                .filter(tecnico -> tecnico.getNumDocumento().equals(numeroDocumento))
                .findAny()
                .orElseThrow(() -> new TecnicoNoEncontradoException("Técnico buscado no encontrado."));
    }

    @Override
     public ArrayList<Tecnico> buscarTodos(){
        return this.tecnicos;
    }



}
