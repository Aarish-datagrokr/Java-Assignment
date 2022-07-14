package com.assignment.multitenant.service;

import com.assignment.multitenant.entity.City;
import com.assignment.multitenant.repository.CityRepository;
import com.assignment.multitenant.service.CityService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CityServiceTest {
    City city;

    @Autowired
    CityService cityService;
    @Autowired
    CityRepository cityRepository;

    @BeforeEach
    void setUp() {
        city = new City();
    }

    @Test
    void something() {
        city.setName("Ujjain");
        city.setTenantId("tenant1");
        cityService.save(city);
    }

    @AfterEach
    void tearDown() {
        city.setName("");
        city.setTenantId("");
    }

    @Test
    @DisplayName("Save test")
    void save() {
        city.setName("Ujjain");
        city.setTenantId("tenant1");
        String expected =city.getName()+" added.";
        String actual = cityService.save(city);
        assertEquals(expected,actual);

    }

    @Test
    @DisplayName("getAll test")
    void getAll() throws SQLException {
        List<Object> list = new ArrayList<>();
        Object expected = list.getClass().getName();
        Object actual = cityService.getAll();
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("delete test")
    void delete() {
        String name = "Ujjain";
        String expected = "Ujjain deleted.";
        String actual = cityService.delete(name);
        assertEquals(expected,actual);
    }
}