package org.example.service;

import org.example.model.PokeApiPokemonFactory;
import org.example.model.Pokemon;
import org.example.persistance.dao.PokeApiDAO;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService
public class PokemonServiceImpl implements PokemonService {

    private final PokeApiDAO pokeApiDAO;
    private final PokeApiPokemonFactory pokemonFactory;

    public PokemonServiceImpl(PokeApiDAO pokeApiDAO) {
        this.pokeApiDAO = pokeApiDAO;
        this.pokemonFactory = new PokeApiPokemonFactory(pokeApiDAO);
    }

    @Override
    @WebMethod
    public List<Pokemon> getAllPokemonEntities(int limit, int offset) {
        List<Pokemon> pokemonEntities = new ArrayList<>();
        try {
            List<Pokemon> pokemons = pokeApiDAO.getAllPokemon(limit, offset);
            for (Pokemon pokemon : pokemons) {
                Pokemon pokemonEntity = pokemonFactory.createPokemon(pokemon.getName(), pokemon.getUrl());
                pokemonEntities.add(pokemonEntity);
            }
        } catch (Exception e) {
            // Manejar excepción apropiadamente
            e.printStackTrace();
        }
        return pokemonEntities;
    }
}
