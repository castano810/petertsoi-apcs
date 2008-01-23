//  Authors: Peter Tsoi & Justin Uang
//  Project: Grid World Bugs
//  Bug: BackAndForthBug
//  Date Completed: 12/5/2007

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class BackAndForthBug extends Bug
{
    Location targetLocation = null, initialLocation = null;
    
    public BackAndForthBug ()
    {
        Random randomizer = new Random();
        setDirection(randomizer.nextInt (8) * 45);
        setColor(Color.MAGENTA);
    }
    
    public BackAndForthBug(int direction)
    {
        setDirection(direction);
        setColor(Color.MAGENTA);
    }
    
    public BackAndForthBug(Color bugColor, int direction)
    {
        setDirection(direction);
        setColor(bugColor);
    }
    
    public void act(){
        //initialize locations
        if (targetLocation == null)
        {
            Location currentLocation = getLocation();
            targetLocation = new Location(currentLocation.getCol (), currentLocation.getRow ());
            initialLocation = getLocation();
        }
        move();
    }
    
    public void move()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
        {
            return;
        }
        if (getLocation().equals (targetLocation))
        {
            Location oldTargetLocation = targetLocation;
            targetLocation = initialLocation;
            initialLocation = oldTargetLocation;
            return;
        }
        
        Location loc = getLocation();
        Location nextLocation = calculateNextLocation(loc);
        if (canMove(nextLocation))
        {
            setDirection(loc.getDirectionToward (nextLocation));
            moveTo(nextLocation);
        }
        else
        {
            ArrayList<Location> availableLocations = gr.getEmptyAdjacentLocations (getLocation());
            if (availableLocations.get (0) != null) //if not empty
            {
                int totalDifference = 0;
                int leastDifference = 10;
                Location leastDifferenceLocation = availableLocations.get (0);
                for (int i = 0; i < availableLocations.size (); i++)
                {
                    totalDifference += Math.abs(availableLocations.get (i).getCol () - targetLocation.getCol());
                    totalDifference += Math.abs(availableLocations.get (i).getRow () - targetLocation.getRow());
                    if (totalDifference < leastDifference)
                    {
                        leastDifference = totalDifference;
                        leastDifferenceLocation = availableLocations.get (i);
                    }
                    totalDifference = 0;
                }
                setDirection(loc.getDirectionToward (leastDifferenceLocation));
                moveTo(leastDifferenceLocation);
            }
        }
    }
    
    public Location calculateNextLocation(Location originalLocation)
    {
        return getLocation().getAdjacentLocation(getLocation().getDirectionToward (targetLocation));
    }
    
    public boolean canMove(Location nextLocation)
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
        {
            return false;
        }
        
        if (!gr.isValid (nextLocation))
        {
            return false;
        }
        Actor neighbor = gr.get (nextLocation);
        
        return (neighbor == null) || (neighbor instanceof Flower);
    }
}