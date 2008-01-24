//  Authors: Peter Tsoi & Justin Uang
//  Project: Grid World Bugs
//  Bug: SpiralBug
//  Date Completed: 12/5/2007
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.Random;

import java.awt.Color;
import java.util.Random;

public class SpiralBug extends DetectorBug
{
    public SpiralBug (Color bugColor)
    {
        setColor(bugColor);
        stepCounter = -1;
        turnCounter = 0;
    }
    
    public SpiralBug (Color bugColor, int direction)
    {
        setColor(bugColor);
        setDirection(direction);
        stepCounter = -1;
        turnCounter = 0;
    }
    
    public SpiralBug ()
    {
        setColor(Color.YELLOW);
        stepCounter = -1;
        turnCounter = 0;
    }
    
    public void move()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(next))
            moveTo(next);
        else
            removeSelfFromGrid();
        
    }
    
    public boolean canMove()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (!gr.isValid(next))
        {
            // Reached Wall
            turnCounter++;
            turn();
            turn();
            turn();
            turn();
            turn();
            turn();
            stepCounter = 0;
            return true;
        }
        
        Actor neighbor = gr.get(next);
        
        // Teleport
        if (!((neighbor == null) || neighbor instanceof Flower))
        {
            turnCounter = 0;
                stepCounter = -1;
                Random newRandom = new Random();
                int randomRow = newRandom.nextInt (getGrid().getNumRows());
                int randomCol = newRandom.nextInt (getGrid().getNumCols());
                moveTo(new Location(randomRow,randomCol));
            return false;
        }
        return true;
    }
    
    
    public void act()
    {
        Location myLoc = getLocation();
        if (stepCounter == -1)
        {
            initDir = closestDir();
            targetCounter = wallDistance(initDir);
            setDirection(initDir);
            stepCounter++;
        }
        if (stepCounter < targetCounter)
        {
            if (canMove())
            {
                
                move(); 
                stepCounter++;
                
            }
            
            if (stepCounter == 1)
                {
                    Flower flower = new Flower(getColor());
                    flower.putSelfInGrid(getGrid(), myLoc);
                }
        }
        else
        {
            stepCounter = 0;
            turn();
            turn();
            turn();
            turn();
            turn();
            turn();
            turnCounter++;
            if (turnCounter % 2 == 0 && turnCounter != 0)
            {
                targetCounter--;
            }
            if (targetCounter <= 0)
            {
                Location bugLoc = getLocation();
                getGrid().put (bugLoc, new Rock());
            }
        }
        
    }
    
    private int stepCounter;
    private int targetCounter;
    private int turnCounter;
    private int initDir;
    private int curDir;
}
