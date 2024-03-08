package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

// Idea for CustomAdapter: https://www.geeksforgeeks.org/custom-arrayadapter-with-listview-in-android/
public class CustomAdapter extends ArrayAdapter<City> implements CustomAdapterInterface {

    private List<City> cities;
    private CityAdapterListener listener;
    private Context context;

    public CustomAdapter(Context context, List<City> cities, CityAdapterListener listener) {
        super(context, 0, cities);
        this.context = context;
        this.cities = cities;
        this.listener = listener;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.content, parent, false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;
    }

    @Override
    public void addCity(City city) {
        cities.add(city);
        notifyDataSetChanged();
    }

    @Override
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    @Override
    public void deleteCity(City city) {
        if (!cities.remove(city)) {
            throw new IllegalArgumentException("City not found");
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return cities.size();
    }

    @Override
    public void notifyDataSetChanged() {
        if (listener != null) {
            listener.notifyDataSetChanged();
        }
    }

}
