package com.sazi.simulation.aircrafts;

import com.sazi.weather.WeatherTower;

public interface Flyable
{
    public void updateConditions();
    public void registerTower(WeatherTower wt);
    public String getName();
}