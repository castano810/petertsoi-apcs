//  Authors: Peter Tsoi & Justin Uang
//  Project: Grid World Bugs
//  Bug: CryptoBug
//  Date Completed: 12/5/2007

import java.awt.Color;
import java.util.Random;

public class CryptoBug extends DetectorBug
{
    public CryptoBug()
    {
        setColor(Color.BLUE);
        originalColor = Color.BLUE;
        evasiveCounter = 3;
    }
    
    public CryptoBug(Color bugColor)
    {
        setColor(bugColor);
        originalColor = bugColor;
        evasiveCounter = 3;
    }
    
    public CryptoBug(Color bugColor, int direction)
    {
        setColor(bugColor);
        setDirection(direction);
        originalColor = bugColor;
        evasiveCounter = 3;
    }
    
    public void act()
    {
        if (goEvasive() || evasiveCounter <=2)
        {
            if (goEvasive())
                evasiveCounter = 0;
            else 
                evasiveCounter++;
            
            setColor(Color.WHITE);
        }
        else
        {
            setColor(originalColor);
            if (canMove())
                move(); 
            else
                turn();
        }
    }
    
    private int evasiveCounter;
    private Color originalColor;
}
