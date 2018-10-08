/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   WeatherProvider.java                               :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: sazi <sazi@student.42.fr>                  +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2018/06/22 14:57:24 by ssibiya           #+#    #+#             */
/*   Updated: 2018/07/10 17:24:41 by sazi             ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package com.sazi.weather;

import com.sazi.simulator.aircrafts.Coordinates;

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