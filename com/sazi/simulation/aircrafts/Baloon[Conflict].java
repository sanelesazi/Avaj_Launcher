package com.sazi.simulation.aircrafts;

import com.sazi.weather.*;
import com.sazi.simulation.Logger;

public class Baloon extends Aircraft implements Flyable
{
    private WeatherTower weathertower;

    Baloon(String name, Coordinates coord)
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
                        updateCoordinates(": Up up and away, Its a Sunny day", +2, 0, +4);
                else if (currentWeather.equals("RAIN"))
                        updateCoordinates(": These rain drops better not make me pop", 0, 0, -5);
                else if (currentWeather.equals("FOG"))
                        updateCoordinates(": Man I can't see where I'm going, Fog gon make me pop", 0, 0, -3);
                else if (currentWeather.equals("SNOW"))
                        updateCoordinates(": I've gained weight, I must be frozen - I can't elevate no more", 0, 0, -15);
                else
                        Logger.logToFile("No Weather! No Feathers");
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
		return "Baloon#" + this.name + "(" + this.id + ")";
	}
}