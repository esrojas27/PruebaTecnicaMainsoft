package org.example.model;

import org.example.persistance.dao.PokeApiDAO;

public class PokeApiPokemonFactory implements PokemonFactory {
    private final PokeApiDAO pokeApiDAO;

    public PokeApiPokemonFactory(PokeApiDAO pokeApiDAO) {
        this.pokeApiDAO = pokeApiDAO;
    }

    @Override
    public Pokemon createPokemon(String name, String url) {
        // Usa PokeApiDAO para obtener información adicional del pokemon
        // y crea el objeto Pokemon con la información
        Pokemon pokemon = new Pokemon(name, url);
        // Agrega información adicional del pokemon usando PokeApiDAO
        // pokemon.setTipo(pokeApiDAO.getTipo(name));
        // pokemon.setHabilidades(pokeApiDAO.getHabilidades(name));
        return pokemon;
    }
}
