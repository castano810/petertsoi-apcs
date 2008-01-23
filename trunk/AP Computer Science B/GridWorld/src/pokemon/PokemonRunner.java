package pokemon;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.util.ArrayList;
public class PokemonRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new PokemonArena();
        world.add (new Weedle());
        world.add (new Caterpie());
        world.show();
    }
}
