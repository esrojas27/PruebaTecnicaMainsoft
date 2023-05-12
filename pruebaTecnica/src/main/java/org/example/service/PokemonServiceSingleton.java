package org.example.service;

import org.example.persistance.dao.PokeApiDAO;

public class PokemonServiceSingleton {
    private static PokemonService instance;

    private PokemonServiceSingleton() {}

    public static PokemonService getInstance() {
        if (instance == null) {
            PokeApiDAO dao = new PokeApiDAO();
            instance = new PokemonServiceImpl(dao);
        }
        return instance;
    }
}
