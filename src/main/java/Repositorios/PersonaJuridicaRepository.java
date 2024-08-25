package Repositorios;

import Personas.PersonaFisica;
import Personas.PersonaJuridica;

import java.util.ArrayList;

public class PersonaJuridicaRepository implements IPersonaJuridicaRepository{
    private ArrayList<PersonaJuridica> personasJuridicas;

    public PersonaJuridicaRepository(){
        this.personasJuridicas = new ArrayList<>();
    }

    @Override
    public void guardar(PersonaJuridica persona){
        this.personasJuridicas.add(persona);
    }

    @Override
    public ArrayList<PersonaJuridica> buscarTodos(){

        return this.personasJuridicas;
    }
}
