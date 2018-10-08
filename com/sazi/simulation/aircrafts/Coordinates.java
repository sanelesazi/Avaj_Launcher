package com.sazi.simulation.aircrafts;

public class Coordinates
{
    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int theLongitude, int theLatitude, int theHeight)
    {
        this.longitude = theLongitude;
        this.latitude = theLatitude;
        this.height = theHeight;
    }

    public int getLongitude()
    {
        return this.longitude;
    }

    public int getLatitude()
    {
        return this.latitude;
    }

    public int getHeight()
    {
        return this.height;
    }

    public void setLongitude(int new_val)
    {
        this.longitude += new_val;
    }

    public void setLatitude(int new_val)
    {
        this.latitude += new_val;
    }

    public void setHeight(int new_val)
    {
        this.height += new_val;
    }
}