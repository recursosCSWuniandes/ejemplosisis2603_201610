/*
 * CityResource.java
 * Clase que representa el recurso "/cities"
 * Implementa varios métodos para manipular las ciudades
 */
package co.edu.uniandes.rest.cities.resources;

import co.edu.uniandes.rest.cities.dtos.CityDTO;
import co.edu.uniandes.rest.cities.mocks.CityLogicMock;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Clase que implementa el recurso REST correspondiente a "cities".
 * 
 * Note que la aplicación (definida en RestConfig.java) define la ruta
 * "/api" y este recurso tiene la ruta "cities". 
 * Al ejecutar la aplicación, el recurse será accesibe a través de la 
 * ruta "/api/cities" 
 * 
 * @author Asistente
 */
@Path("cities")
@Produces("application/json")
public class CityResource {

	// TODO: Cambiar por un @Inject a un servicio real
	CityLogicMock cityLogic = new CityLogicMock();
	
    @GET
    public List<CityDTO> getCities() {
        return cityLogic.getCities();
    }

    @GET
    @Path("{id: \\d+}")
    public CityDTO getCity(@PathParam("id") Long id) {
        return cityLogic.getCity(id);
    }

    @POST
    public CityDTO createCity(CityDTO dto) {
        return cityLogic.createCity(dto);
    }

    @PUT
    @Path("{id: \\d+}")
    public CityDTO updateCity(@PathParam("id") Long id, CityDTO dto) {
        return cityLogic.updateCity(id, dto);
    }

    @DELETE
    @Path("{id: \\d+}")
    public void deleteCity(@PathParam("id") Long id) {
    	cityLogic.deleteCity(id);
    }

}
