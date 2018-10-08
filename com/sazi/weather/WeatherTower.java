/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   WeatherTower.java                                  :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: sazi <sazi@student.42.fr>                  +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2018/06/22 15:55:19 by ssibiya           #+#    #+#             */
/*   Updated: 2018/07/10 17:46:44 by sazi             ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package com.sazi.weather;

import com.sazi.simulation.aircrafts.Coordinates;
import com.sazi.simulation.WeatherProvider;

public class WeatherTower extends Tower
{
    public String getWeather (Coordinates coord)
    {
        return WeatherProvider.getProvider().getCurrentWeather(coord);
    }

    public void changeWeather()
    {
        conditionsChanged();
    }
}