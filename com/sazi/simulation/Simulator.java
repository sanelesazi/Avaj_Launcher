/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Simulation.java                                    :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: sazi <sazi@student.42.fr>                  +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2018/06/22 15:33:01 by ssibiya           #+#    #+#             */
/*   Updated: 2018/07/10 18:16:59 by sazi             ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package com.sazi.simulation;

import com.sazi.simulation.aircrafts.*;
import com.sazi.weather.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Simulator
{
    private static WeatherTower weatherTower;
    private static List<Flyable>flyables = new ArrayList<>();

    private static int verifyLineread(String[] lineread)
    {
        if (lineread[0].equals("Helicopter") || lineread[0].equals("JetPlane") || lineread[0].equals("Baloon"))
        {
            if ((Integer.parseInt(lineread[2])) < 0 || (Integer.parseInt(lineread[3])) < 0 || (Integer.parseInt(lineread[4])) < 0)
                return -1;
        }
        else
            return -1;
        return 1;
    }

    public static void main (String[] args) throws InterruptedException
    {
        String line = null;
        try {
			Logger.setOutputFile("simulation.txt");
		} catch (IOException e) {
			System.out.println("Error: Unable to open file simulation.txt for writing.");
			return ;
		}
        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            int simulations = 0;

            line = reader.readLine();
            if (line != null)
            {
                simulations = Integer.parseInt(line.split(" ")[0]);
                if (simulations < 0)
                {
                    System.out.println("Invalid number of simulations count: " + simulations);
                    System.exit(-1);
                }
                weatherTower = new WeatherTower();
                while ((line = reader.readLine()) != null)
                {
                    String lineread[] = line.split(" ");
                    if (verifyLineread(lineread) == 1)
                    {
                        Flyable aircraft = AircraftFactory.newAircraft(lineread[0], lineread[1], Integer.parseInt(lineread[2]), 
                                                    Integer.parseInt(lineread[3]), Integer.parseInt(lineread[4]));
                        flyables.add(aircraft);
                    }
                    else
                    {
                        System.out.println("Invalid line format: " + line);
                        System.exit(-1);
                    }
                }

                for (Flyable flyable : flyables)
                {
                    flyable.registerTower(weatherTower);
                }

                for (int i = 0; i < simulations; i++)
                {
                    weatherTower.changeWeather();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't Find File: " + args[0]);
        }
        catch (IOException e) {
            System.out.println("There was an error while reading file: " + args[0]);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            // System.out.println("Done - Specify next simulation file");
        }
        catch (NumberFormatException e) {
            System.out.println("Invalid number format: Kindly specify a valid number: " + line);
        }
    }
}
