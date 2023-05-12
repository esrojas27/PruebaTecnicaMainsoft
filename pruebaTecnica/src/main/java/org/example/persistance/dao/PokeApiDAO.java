package org.example.persistance.dao;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.Pokemon;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PokeApiDAO {
    private static final String API_URL = "https://pokeapi.co/api/v2/pokemon";

    public List<Pokemon> getAllPokemon(int limit, int offset) throws IOException {
        String apiUrl = String.format("%s?limit=%d&offset=%d", API_URL, limit, offset);
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode root = objectMapper.readTree(connection.getInputStream());
        List<Pokemon> pokemonList = new ArrayList<>();
        for (JsonNode node : root.get("results")) {
            String name = node.get("name").asText();
            String urlPok = node.get("url").asText();
            Pokemon pokemon = new Pokemon(name, urlPok);
            pokemonList.add(pokemon);
        }

        return pokemonList;
    }
}
