package com.example.lab8;

public interface CustomAdapterInterface {
    void addCity(City city);
    boolean hasCity(City city);
    void deleteCity(City city);
    void notifyDataSetChanged();
    int getCount();
}
