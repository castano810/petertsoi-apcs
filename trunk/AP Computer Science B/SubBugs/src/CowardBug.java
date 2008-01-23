//  Authors: Peter Tsoi & Justin Uang
//  Project: Grid World Bugs
//  Bug: CowardBug
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

public class CowardBug extends DetectorBug
{
    
    public CowardBug()
    {
        setColor(Color.GREEN);
        evasiveCounter = 4;
    }
    
    public CowardBug(Color bugColor)
    {
        setColor(bugColor);
        evasiveCounter = 4;
    }
    
    public CowardBug(Color bugColor, int direction)
    {
        setColor(bugColor);
        setDirection(direction);
        evasiveCounter = 4;
    }

    private void move(int freakedOut)
    {
        int turnAround =0;
        if (freakedOut == 0)
        {
            turn();
            turn();
            turn();
            turn();
        }
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(next))
            moveTo(next);
        else
            removeSelfFromGrid();
        Flower flower = new Flower(getColor());
        flower.putSelfInGrid(gr, loc);
    }
    
    public boolean canMove(int freakedOut)
    {
        int turnAround =0;
        if (freakedOut == 0)
            turnAround =180;
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection() + turnAround);
        if (!gr.isValid(next))
            return false;
        Actor neighbor = gr.get(next);
        return (neighbor == null) || (neighbor instanceof Flower);
    }
    
    public void act()
    {
        if (goEvasive() || evasiveCounter <=3)
        {
            if (goEvasive())
                evasiveCounter = 0;
            else 
                evasiveCounter++;
            
            if (canMove(evasiveCounter))
                move(evasiveCounter);
            else
            {
                Random newRandom = new Random();
                int randomInt = newRandom.nextInt (8);
                for (int i = 0; i<randomInt; i++)
                    turn();
            }
        }
        else
        {
            if (canMove())
                move(); 
            else
                turn();
        }
    }
    
    private int evasiveCounter;
    private Random randomNum;
}
