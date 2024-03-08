package com.example.lab8;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

public class CustomList implements CustomAdapterInterface {

    private CustomAdapter customAdapter;
    private List<City> cities;
    private CityAdapterListener listener;

    public CustomList(Context context, List<City> cities, CityAdapterListener listener) {
        this.cities = cities;
        this.listener = listener;
        customAdapter = new CustomAdapter(context, cities, listener);
    }

    @Override
    public int getCount() {
        return customAdapter.getCount();
    }

    @Override
    public void addCity(City city) {
        customAdapter.addCity(city);
    }

    @Override
    public boolean hasCity(City city) {

    }

    @Override
    public void deleteCity(City city) {

    }

    @Override
    public void notifyDataSetChanged() {
        customAdapter.notifyDataSetChanged();
    }

    public ArrayAdapter<City> getAdapter() {
        return customAdapter;
    }
}
