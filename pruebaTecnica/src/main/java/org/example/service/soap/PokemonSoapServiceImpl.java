package org.example.service.soap;

import org.example.model.Pokemon;
import org.example.persistance.dao.PokeApiDAO;

import javax.jws.WebService;
import java.io.IOException;
import java.util.List;

@WebService(endpointInterface = "org.example.service.soap.PokemonSoapService")
public class PokemonSoapServiceImpl implements PokemonSoapService {
    private final PokeApiDAO dao;

    public PokemonSoapServiceImpl(PokeApiDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<Pokemon> getAllPokemon(int limit, int offset) {
        try {
            return dao.getAllPokemon(limit, offset);
        } catch (IOException e) {
            throw new RuntimeException("Error al obtener la lista de Pokémon desde la API", e);
        }
    }
}
