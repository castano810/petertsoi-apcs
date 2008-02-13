//
//  BlusterCritter.java
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

public class BlusterCritter extends Critter {
	public void processActors(ArrayList<Actor> actors)
    {
		ArrayList<Actor> neighbors1 = getGrid().getNeighbors(getLocation());
		ArrayList<Actor> finalNeighbors = new ArrayList<Actor>();
		
		for (Actor neighbor : neighbors1)
		{
			if (neighbor != null)
			{
				ArrayList<Actor> nextLevel = getGrid().getNeighbors(neighbor.getLocation());
				for (Actor nextNeighbor : nextLevel)
				{
					if (neighbor != null)
					{
						for (
						finalNeighbors.add(nextNeighbor);
					}
				}
			}
		}
		System.out.println(finalNeighbors.size());
	}
}
