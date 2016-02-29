/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.servidor.cities.converters;

/**
 *
 * @author Asistente
 */
import java.util.ArrayList;
import java.util.List;
import co.edu.uniandes.rest.servidor.cities.dtos.CityResource;
import java.util.Objects;
/**
 *
 * @author Asistente
 */
public class CityConverter {

    public static CityConverter u;

    public static ArrayList<CityResource> listCities;

    public static CityConverter getUtil() {
        if (u == null) {
            u = new CityConverter();
            listCities = new ArrayList<>();
        }
        System.out.println("tamaño: " + listCities.size());
        return u;
    }

    public CityResource createCity(CityResource myCity) {
        listCities.add(myCity);
        return myCity;
    }

    public List<CityResource> getCities() {
        return listCities;
    }

    public CityResource getCity(Long id){
        CityResource myCity = new CityResource();
        for (CityResource listCity : listCities) {
            if (Objects.equals(listCity.getId(), id)){
                myCity = listCity;
            }
        }
        return myCity;
    }

    public CityResource updateCity(Long id, CityResource dto) {
        for (CityResource listCity : listCities) {
            if (Objects.equals(listCity.getId(), id)) {
                listCity.setId(dto.getId());
                listCity.setName(dto.getName());
            }
        }
        return dto;
    }

    public void deleteCity(Long id) {
        for (CityResource listCity : listCities) {
            if (Objects.equals(listCity.getId(), id)) {
                listCities.remove(listCity);
                break;
            }
        }
    }
}
