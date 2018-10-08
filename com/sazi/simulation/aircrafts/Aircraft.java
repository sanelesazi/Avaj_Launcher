package com.sazi.simulation.aircrafts;

import com.sazi.simulation.Logger;

public abstract class Aircraft
{
    protected long id;
    protected String name;
    protected Coordinates coordinates;

    private static long _idCounter = 0;

    protected Aircraft (String nam, Coordinates coord)
    {
        this.name = nam;
        this.coordinates = coord;
        this.id = nextID();
    }

    public void updateCoordinates(String message, int theLong, int theLat, int theHeight)
    {
        Logger.logToFile(message + '\n');
        this.coordinates.setLongitude(theLong);
        this.coordinates.setLongitude(theLat);
        this.coordinates.setHeight(theHeight);
        if (this.coordinates.getHeight() > 100)
        {
            int height = this.coordinates.getHeight();
            this.coordinates.setHeight(-(height - 100));
        }
    }

    public String getName()
    {
        return this.name;
    }

    public long getLongitude()
    {
        return this.coordinates.getLongitude();
    }

    public long getLatitude()
    {
        return this.coordinates.getLatitude();
    }

    public long getHeight()
    {
        return this.coordinates.getHeight();
    }

    public Coordinates getCoordinates()
    {
        return this.coordinates;
    }

    public long getID()
    {
        return this.id;
    }

    private long nextID()
    {
        return _idCounter++;
    }
}

