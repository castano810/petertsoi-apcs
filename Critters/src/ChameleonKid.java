//
//  ChameleonKid.java
//  Critters
//
//  Created by Justin Uang on 2/13/08.
//  Copyright 2008 __MyCompanyName__. All rights reserved.
//

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.awt.Color;

import java.util.ArrayList;

public class ChameleonKid extends ChameleonCritter {

	public void processActors(ArrayList<Actor> actors)
    {
        int n = actors.size();
        if (n == 0)
		{
			Color c = getColor();
			int red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
			int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
			int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));

			setColor(new Color(red, green, blue));
		}
		else
		{
			Location front = getLocation().getAdjacentLocation(getDirection());
			Location back = getLocation().getAdjacentLocation(getDirection() + 180);
			
			if(getGrid().get(front) != null)
			{
				setColor(getGrid().get(front).getColor());
			}
			else if (getGrid().get(back) != null)
			{
				setColor(getGrid().get(back).getColor());
			}
		}
    }

}
