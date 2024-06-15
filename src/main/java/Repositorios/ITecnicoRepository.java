package Repositorios;

import Excepciones.TecnicoNoEncontradoException;
import Personas.Tecnico;

import java.util.ArrayList;

public interface ITecnicoRepository {
    void guardar(Tecnico tecnico);
    void eliminar(String numeroDocumento) throws TecnicoNoEncontradoException;
    void modificar(Tecnico tecnico) throws TecnicoNoEncontradoException;
    Tecnico buscar(String numeroDocumento) throws TecnicoNoEncontradoException;
    ArrayList<Tecnico> buscarTodos();
}
