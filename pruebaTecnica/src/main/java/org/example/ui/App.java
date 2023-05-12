package org.example.ui;

import org.example.model.Pokemon;
import org.example.persistance.dao.PokeApiDAO;
import org.example.service.PokemonService;
import org.example.service.PokemonServiceSingleton;

import javax.xml.ws.Endpoint;
import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) {
        PokeApiDAO dao = new PokeApiDAO();
        PokemonService pokemonService = PokemonServiceSingleton.getInstance();

        List<Pokemon> pokemonList = pokemonService.getAllPokemonEntities(20, 0);
        System.out.println("Pokemons obtenidos: \n");
        for (Pokemon pokemon : pokemonList) {
            System.out.println(pokemon.toString());
        }


        String endpointUrl = "http://localhost:8081/pokemon";
        Endpoint.publish(endpointUrl, pokemonService);
        System.out.println("Servicio publicado en: " + endpointUrl);
    }
}
