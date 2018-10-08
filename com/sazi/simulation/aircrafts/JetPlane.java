package com.sazi.simulation.aircrafts;

import com.sazi.weather.*;
import com.sazi.simulation.Logger;

public class JetPlane extends Aircraft implements Flyable
{
    private WeatherTower weathertower;

    JetPlane(String name, Coordinates coord)
    {
        super(name, coord);
    }

    public void updateConditions()
    {
        String currentWeather = weathertower.getWeather(coordinates);

        if (coordinates.getHeight() <= 0)
            weathertower.unregister(this);
        else
        {
            Logger.logToFile(this.toString());
            if (currentWeather.equals("SUN"))
                updateCoordinates(": Lightening speed!!! Sunny days are the best!!", 0, +10, +2);
            else if (currentWeather.equals("RAIN"))
                updateCoordinates(": Rain or not! Lets keep it moving", 0, +5, 0);
            else if (currentWeather.equals("FOG"))
                updateCoordinates(": Rather safe than sorry - I'ma take it slow in this fog", 0, +1, 0);
            else if (currentWeather.equals("SNOW"))
                updateCoordinates(": Well snow ain't fun! I'm barely moving - wait!... I am! In the OPPOSITE DIRECTION", 0, 0, -7);
            else
                Logger.logToFile("Heck! I must be in a weatherless planet");
        }
    }

    public void registerTower(WeatherTower wt)
    {
        weathertower = wt;
        if (coordinates.getHeight() > 0)
            weathertower.register(this);
    }

    @Override
    public String toString()
    {
		return "Jetplane#" + this.name + "(" + this.id + ")";
	}
}