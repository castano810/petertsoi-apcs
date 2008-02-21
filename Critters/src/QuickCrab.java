// Authors: Justin Uang & Peter Tsoi
// QuickCrab
// Critters Project

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;
import java.lang.Math;

public class QuickCrab extends CrabCritter
{

    /**
     * A crab gets the actors in the three locations immediately in front, to its
     * front-right and to its front-left
     * @return a list of actors occupying these locations
     */
    public ArrayList<Actor> getActors()
    {
        ArrayList<Actor> actors = new ArrayList<Actor>();
        int[] dirs =
            { Location.AHEAD, Location.HALF_LEFT, Location.HALF_RIGHT };
        for (Location loc : getLocationsInDirections(dirs))
        {
            Actor a = getGrid().get(loc);
            if (a != null)
                actors.add(a);
        }

        return actors;
    }  

    /**
     * @return list of empty locations immediately to the right and to the left
     */
    public ArrayList<Location> getMoveLocations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        int[] dirs =
            { Location.LEFT, Location.RIGHT };
        for (Location loc : getLocationsInDirections(dirs))
            if (getGrid().isValid(loc) && getGrid().get(loc) == null){
                if (Math.abs(getLocation().getRow()-loc.getRow()) != 1 && Math.abs(getLocation().getCol()-loc.getCol()) != 1){
                    if (getLocation().getRow() != loc.getRow()){
                        if (getLocation().getRow() > loc.getRow()){
                            if (getGrid().isValid(loc.getAdjacentLocation(180)) && getGrid().get(loc.getAdjacentLocation(180)) == null){
                                locs.add(loc);
                            }
                        } else {
                            if (getGrid().isValid(loc.getAdjacentLocation(0)) && getGrid().get(loc.getAdjacentLocation(0)) == null){
                                locs.add(loc); 
                            }
                        }
                    } else {
                        if (getLocation().getCol() > loc.getCol()){
                            if (getGrid().isValid(loc.getAdjacentLocation(90)) && getGrid().get(loc.getAdjacentLocation(90)) == null)
                                locs.add(loc);
                            
                        } else {
                            if (getGrid().isValid(loc.getAdjacentLocation(270)) && getGrid().get(loc.getAdjacentLocation(270)) == null)
                                locs.add(loc); 
                        }
                    }
                }
            }

        return locs;
    }
    
    /**
     * Finds the valid adjacent locations of this critter in different
     * directions.
     * @param directions - an array of directions (which are relative to the
     * current direction)
     * @return a set of valid locations that are neighbors of the current
     * location in the given directions
     */
    public ArrayList<Location> getLocationsInDirections(int[] directions)
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        Grid gr = getGrid();
        Location loc = getLocation();
    
        for (int d : directions)
        {
            Location neighborLoc = loc.getAdjacentLocation(getDirection() + d);
            if (gr.isValid(neighborLoc))
                locs.add(neighborLoc);
            neighborLoc = loc.getAdjacentLocation(getDirection() + d).getAdjacentLocation(getDirection() + d);
            if (gr.isValid(neighborLoc))
                locs.add(neighborLoc);
        }
        return locs;
    }    
}
