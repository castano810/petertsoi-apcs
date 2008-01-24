//  Authors: Peter Tsoi & Justin Uang
//  Project: Grid World Bugs
//  Bug: ZigZagBug
//  Date Completed: 12/5/2007

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.Random;

public class ZigZagBug extends Bug
{
    boolean alternateDirection = false;
    
    public ZigZagBug ()
    {
        Random randomizer = new Random();
        int initialDirection = randomizer.nextInt (8) * 45;
        setDirection(initialDirection);
        setColor(Color.pink);
    }
    
    public ZigZagBug(int direction)
    {
        setDirection(direction);
    }
    
    public ZigZagBug(Color bugColor, int direction)
    {
        setDirection(direction);
        setColor(bugColor);
    }
    
    public void act(){
        move();
    }
    
    public void move()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
        {
            return;
        }
        
        Location loc = getLocation();
        
        int nextDirection = getDirection();
        if (alternateDirection)
        {
            nextDirection -= 90;
            alternateDirection = false;
        }
        else
        {
            nextDirection += 90;
            alternateDirection = true;
        }
        Location nextLocation = loc.getAdjacentLocation (nextDirection);
        
        if(canMove(nextLocation))
        {
            moveTo(nextLocation);
            setDirection(nextDirection);
        }
        else
        {
            setDirection(getDirection() + 90);
        }
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
