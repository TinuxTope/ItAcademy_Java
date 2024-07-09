# Juego de dados

Este es mi proyecto final de ItAcademy java, una API 100% diseñada por mí, donde aplicaré todo lo que he aprendido 
para crear una aplicación completa, desde la base de datos hasta la seguridad. 

## Descripción del Juego de Dados

Voy a crear un juego de dados muy sencillo y divertido. Se juega con dos dados y si la suma de ambos es 7, 
ganas la partida; si no, pierdes. Cada jugador podrá ver un listado de todas las tiradas que ha hecho 
y su porcentaje de éxito.

#### Registro de Usuarios
Para poder jugar, primero necesitaré registrarte con un nombre único. Al registrarte, se te asignará un identificador 
numérico único y una fecha de registro. Si prefieres no añadir ningún nombre, serás registrado como "ANÓNIMO". 
Puede haber varios jugadores con el nombre "ANÓNIMO".

#### Funcionalidades del Juego
Listado de Tiradas: Podrás ver todas las tiradas que has realizado, incluyendo el valor de cada dado y si ganaste o no.
Porcentaje de Éxito: Además, podrás ver tu porcentaje de éxito en todas las tiradas.
Eliminación de Tiradas
No podrás eliminar una tirada específica, pero sí podrás eliminar todo el historial de tiradas de tu cuenta.

Listado de Jugadores
El software permitirá listar a todos los jugadores registrados en el sistema, mostrando el porcentaje de éxito de 
cada uno y el porcentaje de éxito medio de todos los jugadores.

Diseño del Software
El software respetará los principales patrones de diseño para asegurar que sea robusto y escalable.

### Detalles de Construcción
- URL’s:
- POST: /players: crea un jugador.
- PUT: /players: modifica el nombre del jugador.
- POST: /players/{id}/games/: un jugador específico realiza una tirada de los dados.
- DELETE: /players/{id}/games: elimina las tiradas del jugador.
- GET: /players/: retorna el listado de todos los jugadores del sistema con su porcentaje medio de éxitos.
- GET: /players/{id}/games: retorna el listado de jugadas de un jugador.
- GET: /players/ranking: retorna el ranking medio de todos los jugadores del sistema.
- GET: /players/ranking/loser: retorna el jugador con peor porcentaje de éxito.
- GET: /players/ranking/winner: retorna el jugador con mejor porcentaje de éxito.

### Fases del Desarrollo
* Fase 1: Persistencia en MySQL
Utilizaré una base de datos MySQL para la persistencia de datos.

* Fase 2: Migración a MongoDB
Cambiaré la persistencia a MongoDB.

* Fase 3: Autenticación
Añadiré seguridad al proyecto con autenticación por JWT en todos los accesos a las URL's del microservicio.

* Nivel 2: Testing
Añadiré tests unitarios, de componente y de integración con librerías jUnit, AssertJ o Hamcrest.
Utilizaré Mocks en el testing del proyecto (Mockito) y Contract Tests (https://docs.pact.io/).

* Nivel 3: Persistencia Dual
Diseñaré y modificaré el proyecto para que utilice dos esquemas de base de datos al mismo tiempo, MySQL y MongoDB.