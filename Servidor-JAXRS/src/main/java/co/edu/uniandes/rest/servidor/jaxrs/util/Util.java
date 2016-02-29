/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.servidor.jaxrs.util;

/**
 *
 * @author Asistente
 */
import java.util.ArrayList;
import java.util.List;
import co.edu.uniandes.rest.servidor.jaxrs.dto.CityDTO;
import java.util.Objects;
/**
 *
 * @author Asistente
 */
public class Util {

    public static Util u;

    public static ArrayList<CityDTO> listCities;

    public static Util getUtil() {
        if (u == null) {
            u = new Util();
            listCities = new ArrayList<>();
        }
        System.out.println("tamaño: " + listCities.size());
        return u;
    }

    public CityDTO createCity(CityDTO myCity) {
        listCities.add(myCity);
        return myCity;
    }

    public List<CityDTO> getCities() {
        return listCities;
    }

    public CityDTO getCity(Long id){
        CityDTO myCity = new CityDTO();
        for (CityDTO listCity : listCities) {
            if (Objects.equals(listCity.getId(), id)){
                myCity = listCity;
            }
        }
        return myCity;
    }

    public CityDTO updateCity(Long id, CityDTO dto) {
        for (CityDTO listCity : listCities) {
            if (Objects.equals(listCity.getId(), id)) {
                listCity.setId(dto.getId());
                listCity.setName(dto.getName());
            }
        }
        return dto;
    }

    public void deleteCity(Long id) {
        for (CityDTO listCity : listCities) {
            if (Objects.equals(listCity.getId(), id)) {
                listCities.remove(listCity);
                break;
            }
        }
    }
}
