# Ejemplo Cliente y Servicio REST

Ejemplo de un Cliente en Javascript con Angular y un servicio REST implementado usando JAX-RS.
El servicio permite manipular datos de ciudades.
Por defecto, para efecto de las pruebas, el servicio incluye los datos de 3 ciudades.


## Estructura del proyecto

El proyecto sigue la estructura de los proyectos Maven.
Por lo tanto, el c�digo fuente Java est� ubicado en la carpeta `src/main/java` dentro del proyecto.
El c�digo de la p�gina web est� ubicado en la carpeta `src/main/webapp`.

Para entender el c�digo fuente del ejemplo, es necesario revisar los siguientes archivos:

```
City
?   pom.xml
?
????Cities.web
    ?    pom.xml
    ?
    ????src/main/java
    ?   ????co.edu.uniandes.rest.cities.resources
    ?   ?   ?   RestConfig.java
    ?   ?   ?   CityResource.java
    ?   ?
    ?   ????co.edu.uniandes.rest.cities.dtos
    ?   ?   ?   CityDTO.java
    ?   ?
    ?   ????co.edu.uniandes.rest.cities.mocks
    ?   ?   ?   CityLogicMock.java
    ?   ?
    ?   ????co.edu.uniandes.rest.cities.exceptions
    ?   ?   ?   CityLogicException.java
    ?   ?
    ?   ????co.edu.uniandes.rest.cities.converters
    ?       ?   CityLogicExceptionMapper.java
    ?
    ????src/main/webapp
        ?   ?   index.html
        ?
        ????src
            ?   app.js
            ?
            ????modules/city
               ?   city.tpl.html
               ?   city.mod.js
               ?   city.ctrl.js
               ?   city.svc.js
```

| Clase | Descripci�n |
| ----- | ----------- |
| `RestConfig.java` | Indica que la aplicaci�n expone recursos REST. Solo se requiere uno en la aplicaci�n. Especifica la ruta `/api` como prefijo para los recursos REST |
| `CityResource.java` | Define el recurso con la ruta `/api/cities`. Contiene m�todos para procesar las peticiones GET, POST, PUT y DELETE de acuerdo al API definido |
| `CityDTO.java` | Define los datos que se transfiere entre el cliente y el servidor. Como se usa como tipo de retorno en los m�todos de `CityResource`, JAX-RS convierte autom�ticamente de JSON a esta clase y de esta clase a JSON.  |
| `CityLogicMock.java` | Simula un servicio de l�gica de negocios. En este ejemplo, el Mock manipula los elementos en una lista de ciudades (Un lista de `CityDTO`). |
| `CityLogicException.java` | Excepci�n lanzada por CityLogicMock cuando se genera un error. |
| `CityLogicExceptionMapper.java` | Convertidor de la excepci�n `CityLogicException` a mensajes REST. |


## Documentaci�n del API

### Entidad City

La comunicaci�n entre el cliente y el servidor se realiza intercambiando objetos JSON que siguen el siguiente formato:

```javascript
{
    "id" : 1,     /* Tipo Long */
    "name" : ''    /* Tipo String */
}
```

Si se solicta la servidor una lista de ciudades, el servidor retorna un arreglo de esos objetos siguiendo el siguiente formato:

 ```javascript
[
  {
    "id" : 1,     /* Tipo Long */
    "name" : ''    /* Tipo String */
  }, {
    "id" : 2,     /* Tipo Long */
    "name" : ''    /* Tipo String */
  } /* ... otras ciudades */
]
```

### Servicios REST

Al ejecutarlo en su propia m�quina, el recurso REST estar� disponible en:
*  `http://localhost:8080/Servidor-JAXRS/api/cities`

La descripci�n del API REST se presenta a continuaci�n:

M�todo|URI|Acci�n|Par�metros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/cities|Lista los registros de City (READ)|||Colecci�n de registros de City
**GET**|/cities/*:id*|Obtener los atributos de una instancia de City (READ)|**@PathParam id**: Identificador del registro||Atributos de la instancia de City
**POST**|/cities|Crear una nueva instancia de la entidad City (CREATE)||Atributos de la instancia de City a crear|Instancia de City creada, incluyendo su nuevo ID
**PUT**|/cities/*:id*|Actualiza una instancia de la entidad City (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de City|Instancia de City actualizada
**DELETE**|/cities/*:id*|Borra instancia de City en el servidor (DELETE)|**@PathParam id**: Identificador del registro||



## Ejecutando y probando el proyecto

El proyecto se ejecuta como un proyecto web tradicional.
En Netbeans basta con ejecutar "Clean and Build" en el proyecto y luego usar la opci�n de "Run".

Es posible usar [Postman](http://www.getpostman.com/) para probar el servicio REST.

| Ejemplo | Comando |
| ------- | ------- |
| Obtener las ciudades | GET http://localhost:8080/Servidor-JAXRS/api/cities |
| Obtener una ciudad   | GET http://localhost:8080/Servidor-JAXRS/api/cities/{id} donde id es el `id` de la ciudad a obtener. Por ejemplo, para traer la ciudad con el id=1 es posible usar el URL http://localhost:8080/Servidor-JAXRS/api/cities/1 |
| Agregar una ciudad   | POST http://localhost:8080/Servidor-JAXRS/api/cities  incluyendo en la petici�n una ciudad. Por ejemplo, es posible usar `{ "id": 4, "name": "barranquilla" }` |
| Modificar una ciudad | PUT http://localhost:8080/Servidor-JAXRS/api/cities/{id} donde id es el `id` de la ciudad a modificar. Por ejemplo, para modificar la ciudad con el id=1 es necesario usar el URL http://localhost:8080/Servidor-JAXRS/api/cities/1 y enviar como par�metro los datos de la nueva cuidad, por ejemplo, `{ "id": 1, "name": "Santa Fe de Bogota" }` |
| Borrar una ciudad    | DELETE http://localhost:8080/Servidor-JAXRS/api/cities/{id} donde id es el `id` de la ciudad a eliminar. Por ejemplo, para eliminar la ciudad con el id=2 es necesario usar el URL http://localhost:8080/Servidor-JAXRS/api/cities/2 |