# PruebaTecnicaMainsoft

Prueba técnica 
Crear una aplicación Java, la cual:
-	Debe tener una arquitectura de tres niveles
-	Debe consumir el API RESTful https://pokeapi.co/api/v2/pokemon 
-	Debe traer los resultados paginados
-	Debe exponer los resultados en un servicio SOAP y poderse consumir por SOAP UI
-	Debe aplicar dos patrones de diseño y sustentar su uso


Patrones implementados:
SINGLETON:
Esta implementación del patrón Singleton garantiza que solo se cree una única instancia 
de PokemonService y que esta instancia pueda ser obtenida en cualquier punto del código 
mediante el método getInstance(). Además, si en algún momento se necesita modificar la 
forma en que se crea la instancia de PokemonService (por ejemplo, si se decide utilizar 
otro DAO diferente a PokeApiDAO), esto solo requeriría modificar la implementación de 
getInstance().

FACTORY METHOD:
Se implementa el patrón Factory Method para crear instancias de la clase Pokemon. En lugar
de crear objetos Pokemon directamente en la clase PokemonService, podríamos crear un objeto
fabricante de Pokémon que se encargue de crear los objetos Pokemon según sea necesario. Con
la interfaz o clase abstracta PokemonFactory que defina el método para crear objetos Pokemon.
Luego, podemos crear una subclase PokeApiPokemonFactory que implemente PokemonFactory y cree
objetos Pokemon utilizando el PokeApiDAO.
