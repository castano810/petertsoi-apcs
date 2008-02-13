import info.gridworld.actor.*;
import info.gridworld.grid.Location;

//
//  Critters.java
//  Critters
//
//  Created by Justin Uang on 2/13/08.
//  Copyright (c) 2008 __MyCompanyName__. All rights reserved.
//
import java.util.*;

public class Critters {

    public static void main (String args[]) {
		ActorWorld world = new ActorWorld();
        world.add(new Location(7, 8), new Actor());
        world.add(new Location(3, 3), new ChameleonCritter());
        world.add(new Location(6, 2), new RockHound());
        world.show();
	}
}