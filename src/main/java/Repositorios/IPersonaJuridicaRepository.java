package Repositorios;

import Excepciones.PJuridicaNoEncontradaExcepcion;
import Personas.PersonaJuridica;

import java.util.ArrayList;

public interface IPersonaJuridicaRepository {
        void guardar(PersonaJuridica persona);
        ArrayList<PersonaJuridica> buscarTodos();
}
