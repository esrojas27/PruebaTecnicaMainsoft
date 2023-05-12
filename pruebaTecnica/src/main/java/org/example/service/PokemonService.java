package org.example.service;

import org.example.model.Pokemon;

import java.util.List;

public interface PokemonService {
    List<Pokemon> getAllPokemonEntities(int limit, int offset);
}
