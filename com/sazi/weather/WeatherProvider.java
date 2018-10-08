/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   WeatherProvider.java                               :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: fthwala <fthwala@student.42.fr>            +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2018/06/22 14:57:24 by ssibiya           #+#    #+#             */
/*   Updated: 2018/07/10 13:10:49 by fthwala          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package com.sazi.simulation;

import com.sazi.simulation.aircrafts.Coordinates;

public class WeatherProvider
{
    private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
    private static WeatherProvider weatherprovider;

    private WeatherProvider()
    {}

    public static WeatherProvider getProvider()
    {
        if (weatherprovider == null)
            weatherprovider = new WeatherProvider();
        return weatherprovider;
    }

    public String getCurrentWeather(Coordinates coords)
    {
        int total;

        total = coords.getLongitude() + coords.getLatitude() + coords.getHeight();
        return (weather[(total % 4)]);
    }
}