//  Authors: Peter Tsoi & Justin Uang
//  Project: Grid World Bugs
//  Bug: FlowerEatingBug (aka. BoringBug & DizzyBug)
//  Date Completed: 12/7/2007

import java.awt.Color;

public class FlowerEatingBug extends DetectorBug
{  
    public FlowerEatingBug()
    {
        setColor(Color.WHITE);
    }
    
    public FlowerEatingBug(Color bugColor)
    {
        setColor(bugColor);
    }
    
    public FlowerEatingBug(Color bugColor, int direction)
    {
        setColor(bugColor);
        setDirection(direction);
    }
    
    public void act()
    {
        int flower = flowerFinder(getColor());
        if (flower > -1)
        {
            int curDir = getDirection();
            int newDir = flower;
            int turns = 0;
            if (curDir > newDir)
            {
                // Turn counterclockwise
                turns = (curDir-newDir)/45;
                for (int i=0;i<(8-turns);i++)
                {
                    turn();
                }
            }
            if (curDir < newDir)
            {
                // Turn clockwise
                turns = (newDir-curDir)/45;
                for (int i=0;i<turns;i++)
                {
                    turn();
                }
            }
            move();
        }
        else
        {
            if (canMove())
                move(); 
            else
                turn();
        }
    }
}
