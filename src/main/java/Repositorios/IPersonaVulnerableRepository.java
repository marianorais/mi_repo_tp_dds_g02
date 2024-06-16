package Repositorios;
import Excepciones.PVulnerableNoEncontradaException;
import Personas.PersonaVulnerable;

import java.util.ArrayList;

public interface IPersonaVulnerableRepository {
    void guardar(PersonaVulnerable persona);
    void eliminar(String numeroDocumento) throws PVulnerableNoEncontradaException;
    void modificar(PersonaVulnerable persona) throws PVulnerableNoEncontradaException;
    PersonaVulnerable buscar(String numeroDocumento) throws PVulnerableNoEncontradaException;
    ArrayList<PersonaVulnerable> buscarTodos();
}
