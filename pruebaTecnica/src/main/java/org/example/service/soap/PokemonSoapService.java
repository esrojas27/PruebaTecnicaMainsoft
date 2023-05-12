package org.example.service.soap;

import org.example.model.Pokemon;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface PokemonSoapService {
    @WebMethod(operationName = "getAllPokemon")
    @WebResult(name = "pokemon")
    List<Pokemon> getAllPokemon(
            @WebParam(name = "limit") int limit,
            @WebParam(name = "offset") int offset
    );
}
