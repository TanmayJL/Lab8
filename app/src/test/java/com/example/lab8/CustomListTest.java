package com.example.lab8;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.mockito.Mockito;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CustomListTest {

    private CustomList list;

    /**
     * create a mocklist for my citylist
     *
     * @return
     */
    public CustomList MockCityList() {
        CityAdapterListener mockListener = Mockito.mock(CityAdapterListener.class);
        list = new CustomList(null, new ArrayList<>(), mockListener);
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     * plus one
     */
    @Test
    public void addCityTest() {
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(), listSize + 1);
    }

    /**
     * add citiy
     * check hascity returns true
     */
    @Test
    public void testHasCity() {
        list = MockCityList();
        list.addCity(new City("Edmonton", "AB"));

        assertTrue(list.hasCity(new City("Edmonton", "AB")));
        assertFalse(list.hasCity(new City("Toronto", "ON")));
    }

    public void testDeleteCity() {
        list = MockCityList();
        City edmonton = new City("Edmonton", "AB");
        list.addCity(edmonton);
        list.addCity(new City("Vancouver", "BC"));

        assertTrue(list.hasCity(edmonton));
        list.deleteCity(edmonton);
        assertFalse(list.hasCity(edmonton));
    }

    @Test
    public void testCountCities() {
        list = MockCityList();
        list.addCity(new City("Edmonton", "AB"));
        list.addCity(new City("Vancouver", "BC"));

        assertEquals(2, list.getCount());
    }

}
