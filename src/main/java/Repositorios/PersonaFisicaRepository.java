package Repositorios;

import Excepciones.PVulnerableNoEncontradaException;
import Personas.PersonaFisica;
import Personas.PersonaVulnerable;

import java.util.ArrayList;


public class PersonaFisicaRepository implements IPersonaFisicaRepository{
    private ArrayList<PersonaFisica> personasFisicas;

    public PersonaFisicaRepository(){
        this.personasFisicas = new ArrayList<>();
    }

    @Override
    public void guardar(PersonaFisica persona){
        this.personasFisicas.add(persona);
    }

    @Override
    public ArrayList<PersonaFisica> buscarTodos(){
        return this.personasFisicas;
    }
}
