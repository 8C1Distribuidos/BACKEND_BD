package com.weine.services;

import com.weine.entities.City;
import com.weine.mappers.ITicketMapper;
import com.weine.model.dtos.CityDto;
import com.weine.repositories.jpa.ICityRep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * Service to get the cities of the data base
 * @author Kaleb
 * @author Luis
 */
@RequiredArgsConstructor
@Service
public class CityService implements IServiceApi<CityDto, Object>{
    private final ITicketMapper cityMapper;
    private final ICityRep cityRep;

    @Override
    public List<CityDto> getObjects() {
        return cityMapper.cityListToCityDtoList(cityRep.findAll());
    }

    @Override
    public CityDto find(Integer id) {
        if(id != null){
            Optional<City> city = cityRep.findById(id);
            if(city.isPresent()){
                return cityMapper.toCity(city.get());
            }
        }
        return null;
    }

    @Override
    public CityDto save(CityDto request) throws RuntimeException {
        return null;
    }

    @Override
    public CityDto update(CityDto request) throws RuntimeException {
        return null;
    }

    @Override
    public boolean delete(Integer id) throws RuntimeException {
        return false;
    }

    @Override
    public boolean checkExistence(Integer id) {
        return false;
    }
}
