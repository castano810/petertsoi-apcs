import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;
import java.lang.Math;

public class KingCrab extends CrabCritter
{

    public void processActors(ArrayList<Actor> actors)
    {
        for (Actor a : actors)
        {
            if (!(a instanceof Rock) && !(a instanceof Flower)){
                Location actorLocation = a.getLocation();
                Location myLocation = getLocation();
                boolean up, down, left, right;
                up = down = left = right = false;
                ArrayList<Location> moveLocations = new ArrayList(5);
                if (myLocation.getRow() > actorLocation.getRow()){
                    up = true;
                    if (getGrid().isValid(actorLocation.getAdjacentLocation(0)))
                        moveLocations.add(actorLocation.getAdjacentLocation(0));
                }
                if (myLocation.getRow() < actorLocation.getRow()){
                    down = true;
                    if (getGrid().isValid(actorLocation.getAdjacentLocation(180)))
                        moveLocations.add(actorLocation.getAdjacentLocation(180));
                }
                if (myLocation.getCol() > actorLocation.getCol()){
                    left = true;
                    if (getGrid().isValid(actorLocation.getAdjacentLocation(270)))
                        moveLocations.add(actorLocation.getAdjacentLocation(270));
                    if (up && getGrid().isValid(actorLocation.getAdjacentLocation(315))) 
                        moveLocations.add(actorLocation.getAdjacentLocation(315));
                    if (down && getGrid().isValid(actorLocation.getAdjacentLocation(235)))
                        moveLocations.add(actorLocation.getAdjacentLocation(235));
                }
                if (myLocation.getCol() < actorLocation.getCol()){
                    right = true;
                    if (getGrid().isValid(actorLocation.getAdjacentLocation(90)))
                        moveLocations.add(actorLocation.getAdjacentLocation(90));
                    if (up && getGrid().isValid(actorLocation.getAdjacentLocation(45)))
                        moveLocations.add(actorLocation.getAdjacentLocation(45));
                    if (down && getGrid().isValid(actorLocation.getAdjacentLocation(135)))
                        moveLocations.add(actorLocation.getAdjacentLocation(135));
                    
                }
                if (moveLocations.size() == 0)
                    a.removeSelfFromGrid();
                else{
                    int r = (int) (Math.random() * moveLocations.size());
                    a.moveTo(moveLocations.get((int) (Math.random() * r)));
                } //moveLocations.get((int) (Math.random() * moveLocations.size()))
            }
        }
    }
}