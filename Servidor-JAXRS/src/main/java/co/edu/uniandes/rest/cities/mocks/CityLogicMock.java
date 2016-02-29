/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.rest.cities.mocks;

/**
 *
 * @author Asistente
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import co.edu.uniandes.rest.cities.dtos.CityDTO;
/**
 *
 * @author Asistente
 */
public class CityLogicMock {

    public static ArrayList<CityDTO> cities;

    public CityLogicMock() {

    	if (cities == null) {
            cities = new ArrayList<>();
            cities.add(new CityDTO(1L, "Bogota"));
            cities.add(new CityDTO(2L, "Cali"));
            cities.add(new CityDTO(3L, "Medellin"));
        }
        System.out.println("tamaño: " + cities.size());
        
    }

    public CityDTO createCity(CityDTO myCity) {
        cities.add(myCity);
        return myCity;
    }

    public List<CityDTO> getCities() {
        return cities;
    }

    public CityDTO getCity(Long id){
        CityDTO myCity = new CityDTO();
        for (CityDTO listCity : cities) {
            if (Objects.equals(listCity.getId(), id)){
                myCity = listCity;
            }
        }
        return myCity;
    }

    public CityDTO updateCity(Long id, CityDTO dto) {
        for (CityDTO listCity : cities) {
            if (Objects.equals(listCity.getId(), id)) {
                listCity.setId(dto.getId());
                listCity.setName(dto.getName());
            }
        }
        return dto;
    }

    public void deleteCity(Long id) {
        for (CityDTO listCity : cities) {
            if (Objects.equals(listCity.getId(), id)) {
                cities.remove(listCity);
                break;
            }
        }
    }
}
