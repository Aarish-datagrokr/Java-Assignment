package com.assignment.multitenant.service;

import com.assignment.multitenant.entity.City;
import com.assignment.multitenant.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public String save(City city) {
        cityRepository.save(city);
        return (city.getName()+" added.");
    }

    public List<City> getAll() throws SQLException {
        return cityRepository.findAll();

    }

    public City get(Long id) {
        return cityRepository.findById(id).get();
    }

    public City getByName(String name) {
        return cityRepository.findByName(name);
    }

    public String delete(String name) {
        cityRepository.deleteByName(name);
        return name+" deleted.";

    }
}
