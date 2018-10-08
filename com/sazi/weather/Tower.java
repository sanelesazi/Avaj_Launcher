/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Tower.java                                         :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: sazi <sazi@student.42.fr>                  +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2018/06/22 15:49:27 by ssibiya           #+#    #+#             */
/*   Updated: 2018/07/10 17:24:35 by sazi             ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package com.sazi.weather;

import java.util.Queue;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import com.sazi.simulation.aircrafts.Flyable;
import com.sazi.simulation.Logger;

public abstract class Tower
{
    private Queue<Flyable> observers = new LinkedBlockingQueue<Flyable>();

    public void register(Flyable flyable)
    {
        Logger.logToFile("Tower says: " + flyable + " registered to weather tower.\n");
		observers.add(flyable);
    }

    public void unregister(Flyable flyable)
    {
        Iterator<Flyable> iter = observers.iterator();
        while (iter.hasNext())
        {
            if (iter.next() == flyable)
            {
				Logger.logToFile("Tower says: " + flyable + " unregistered from weather tower.\n");
				iter.remove();
			}
        }
    }

    protected void conditionsChanged()
    {
        for (Flyable observer : observers)
		    observer.updateConditions();
    }
}