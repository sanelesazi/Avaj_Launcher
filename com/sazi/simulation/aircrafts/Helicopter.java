package com.sazi.simulation.aircrafts;

import com.sazi.weather.*;
import com.sazi.simulation.Logger;

public class Helicopter extends Aircraft implements Flyable
{
    private WeatherTower weathertower;

    Helicopter(String name, Coordinates coord)
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
                        updateCoordinates(": Clear skies, Let's do this - Its sunny baby!", +10, 0, +2);
                else if (currentWeather.equals("RAIN"))
                        updateCoordinates(": Pushing through the rain drops, I can go higher! YEA! slowly but surely", 0, 0, 5);
                else if (currentWeather.equals("FOG"))
                        updateCoordinates(": I'ma make it through this fog! man it's affecting my speed", 1, 0, 0);
                else if (currentWeather.equals("SNOW"))
                        updateCoordinates(": Ever seen a heli going in reverse! damn snow!", 0, 0, -12);
                else
                        Logger.logToFile("I don't know what weather this is");
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
		return "Helicopter#" + this.name + "(" + this.id + ")";
	}
}