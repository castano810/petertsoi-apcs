// Authors: Justin Uang & Peter Tsoi
// Critters Runner
// Critters Project

import info.gridworld.actor.*;
import info.gridworld.grid.Location;
import java.util.*;

public class Critters {

    public static void main (String args[]) {
		ActorWorld world = new ActorWorld();
        world.add(new Location(7, 8), new Actor());
        world.add(new Location(3, 3), new ChameleonCritter());
        world.add(new Location(3, 5), new Rock());
        world.add(new Location(3, 4), new ChameleonKid());
        world.add(new Location(6, 6), new BlusterCritter());
        world.add(new Location(6, 2), new Rock());
        world.add(new Location(6, 4), new QuickCrab());
        world.add(new Location(1,1), new Bug());
        world.add(new Location(3, 2), new KingCrab());
        world.show();
	}
}