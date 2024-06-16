package Repositorios;

import java.util.ArrayList;

import Excepciones.*;
import Personas.*;

public class PersonasVulnerablesRepository implements IPersonaVulnerableRepository{
    private ArrayList<PersonaVulnerable> personasVulnerables;

    public PersonasVulnerablesRepository(){
        this.personasVulnerables = new ArrayList<>();
    }

    @Override
    public void guardar(PersonaVulnerable persona){
        this.personasVulnerables.add(persona);
    }

    @Override
    public void eliminar(String numeroDocumento) throws PVulnerableNoEncontradaException {
        this.personasVulnerables.remove(this.buscar(numeroDocumento));
    }

    @Override
    public void modificar(PersonaVulnerable personaVulnerableModificada) throws PVulnerableNoEncontradaException {
        this.eliminar(personaVulnerableModificada.getNumDocumento());
        this.guardar(personaVulnerableModificada);
    }

    @Override
    public PersonaVulnerable buscar (String numeroDocumento) throws PVulnerableNoEncontradaException {
        return personasVulnerables.stream()
                .filter(persona -> persona.getNumDocumento().equals(numeroDocumento))
                .findAny()
                .orElseThrow(() -> new PVulnerableNoEncontradaException("Persona vulnerable buscado no encontrada."));
    }

    @Override
    public ArrayList<PersonaVulnerable> buscarTodos(){
        return this.personasVulnerables;
    }
}
