package Repositorios;

import Excepciones.PFiscaNoEncontradaExcepcion;
import Personas.PersonaFisica;
import Personas.Tecnico;

import java.util.ArrayList;

public interface IPersonaFisicaRepository {
    void guardar(PersonaFisica persona);
    ArrayList<PersonaFisica> buscarTodos();
}
