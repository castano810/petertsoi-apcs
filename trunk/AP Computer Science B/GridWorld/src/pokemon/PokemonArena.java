package pokemon;
import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.util.ArrayList;

public class PokemonArena extends ActorWorld
{
    public PokemonArena ()
    {
        super();
    }
    
    public void step()
    {
        Grid<Actor> gr = getGrid();
        ArrayList<Actor> actors = new ArrayList<Actor>();
        for (Location loc : gr.getOccupiedLocations())
            actors.add(gr.get(loc));

        for (Actor a : actors)
        {
            // only act if another actor hasn't removed a
            if (a.getGrid() == gr)
            {
                if (a instanceof Pokemon)
                {
                    if (Pokemon.stopCheaters ((Pokemon) a))
                    {
                        a.act();
                    }
                    else
                    {
                        System.out.println("Don't Cheat");
                    }
                }
            }
        }
    }
}
