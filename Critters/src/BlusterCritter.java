// Authors: Justin Uang & Peter Tsoi
// Bluster Critter
// Critters Project

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;
import java.awt.Color;

import java.util.ArrayList;

public class BlusterCritter extends Critter {
	private int courage;
	private static final double DARKENING_FACTOR = 0.05;
	
	public BlusterCritter(int c)
	{
		super();
		courage = c;
	}
	
	public BlusterCritter()
	{
		super();
		courage = 1;
	}

	public void processActors(ArrayList<Actor> actors)
    {
		ArrayList<Location> neighborsFirst = getGrid().getValidAdjacentLocations(getLocation());
		ArrayList<Location> finalNeighbors = new ArrayList<Location>();
		
		for (Location neighbor : neighborsFirst)
		{
			if (neighbor != null)
			{
				ArrayList<Location> nextLevel = getGrid().getValidAdjacentLocations(neighbor);
				for (Location nextNeighbor : nextLevel)
				{
					if (finalNeighbors.indexOf(nextNeighbor) == -1 && getGrid().get(nextNeighbor) != this && getGrid().get(nextNeighbor) != null)
					{
						finalNeighbors.add(nextNeighbor);
					}
				}
			}
		}
		if (finalNeighbors.size() >= courage)
		{
			Color c = getColor();
			int red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
			int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
			int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));

			setColor(new Color(red, green, blue));
		}
		else
		{
			Color c = getColor();
			int red = (int) (c.getRed() * (1 + DARKENING_FACTOR));
			if (red > 255)
				red = 255;
			int green = (int) (c.getGreen() * (1 + DARKENING_FACTOR));
			if (green > 255)
				green = 255;
			int blue = (int) (c.getBlue() * (1 + DARKENING_FACTOR));
			if (blue > 255)
				blue = 255;

			setColor(new Color(red, green, blue));
		}
	}
}
