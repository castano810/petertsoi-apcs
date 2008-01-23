import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.Arrays;

public class DetectorBug extends Bug
{
    
    public boolean goEvasive () 
    {
        boolean returnValue = false;
        Grid<Actor> gr = getGrid();
        if (gr != null)
        {
            Location loc = getLocation();
            //System.out.print (loc + "\t");
            for (int currentDir = 0; currentDir < 360 && !returnValue; currentDir+=45)
            {
                Location nextLoc = loc.getAdjacentLocation(currentDir);
                if (gr.isValid(nextLoc))
                {
                    //System.out.print(loc + "\t");
                    Actor neighbor = gr.get(nextLoc);
                    if (neighbor != null)
                    {
                        returnValue = !((neighbor instanceof Rock) || (neighbor instanceof Flower));
                    }
                }
            }
        }
        return returnValue;
    }
    
    public int closestDir()
    {
        Grid<Actor> gr = getGrid();
        int returnValue = 0;
        int dNorth = getLocation().getRow ();
        int dWest = getLocation().getCol ();
        int dEast = gr.getNumCols()-getLocation().getCol ()-1;
        int dSouth = gr.getNumRows ()-getLocation().getRow ()-1;
        int[] arr = {dNorth, dWest, dEast, dSouth};
        Arrays.sort(arr);
        if (arr[0] == dNorth)
        {
            returnValue = 0;
        }
        if (arr[0] == dWest)
        {
            returnValue = 270;
        }
        if (arr[0] == dEast)
        {
            returnValue = 90;
        }
        if (arr[0] == dSouth)
        {
            returnValue = 180;
        }
        return returnValue;
    }
    
    public int wallDistance(int direction)
    {
        Grid<Actor> gr = getGrid();
        int returnValue = -1;
        if (direction == 0)
        {
            returnValue = getLocation().getRow ();
        }
        if (direction == 90)
        {
            returnValue = gr.getNumCols()-getLocation().getCol ()-1;
        }
        if (direction == 180)
        {
            returnValue = gr.getNumRows ()-getLocation().getRow ()-1;
        }
        if (direction == 270)
        {
            returnValue = getLocation().getCol ();
        }
        return returnValue;
    }
    
    public int flowerFinder (Color myColor) 
    {
        int returnValue = -1;
        int freshestFlower = -1;
        int oldCombo = myColor.getRed()+myColor.getGreen()+myColor.getBlue();
        Grid<Actor> gr = getGrid();
        if (gr != null)
        {
            Location loc = getLocation();
            for (int currentDir = 0; currentDir < 360; currentDir+=45)
            {
                Location nextLoc = loc.getAdjacentLocation(currentDir);
                if (gr.isValid(nextLoc))
                {
                    Actor neighbor = gr.get(nextLoc);
                    if (neighbor instanceof Flower)
                    {
                        int neighborColor = neighbor.getColor().getRed()+neighbor.getColor().getGreen()+neighbor.getColor().getBlue();
                        if (neighborColor <= oldCombo)
                        {
                            oldCombo = neighborColor;
                            returnValue = currentDir;
                            
                        }
                    }
                }
            }
        }
        return returnValue;
    }
}
