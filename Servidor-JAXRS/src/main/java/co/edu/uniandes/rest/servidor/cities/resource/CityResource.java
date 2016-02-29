/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.servidor.cities.resource;

import co.edu.uniandes.rest.servidor.cities.dtos.CityDTO;
import co.edu.uniandes.rest.servidor.cities.converters.CityConverter;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Asistente
 */
@Path("cities")
public class CityResource {

    @GET
    public List<CityDTO> getCities() {
        return CityConverter.getUtil().getCities();
    }

    @GET
    @Path("{id: \\d+}")
    public CityDTO getCity(@PathParam("id") Long id) {
        return CityConverter.getUtil().getCity(id);
    }

    @POST
    public CityDTO createCity(CityDTO dto) {
        return CityConverter.getUtil().createCity(dto);
    }

    @PUT
    @Path("{id: \\d+}")
    public CityDTO updateCity(@PathParam("id") Long id, CityDTO dto) {
        return CityConverter.getUtil().updateCity(id, dto);
    }

    @DELETE
    @Path("{id: \\d+}")
    public void deleteCity(@PathParam("id") Long id) {
        CityConverter.getUtil().deleteCity(id);
    }

}