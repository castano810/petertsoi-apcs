import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;

public class SubBugs
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        world.addGridClass("SparseBoundedGrid2");
        world.add(new Bug());
        world.add(new CowardBug());
        world.add(new CryptoBug());
        world.add(new SpiralBug());
        world.add(new ZigZagBug());
        world.add(new FlowerEatingBug());
        world.add(new BackAndForthBug());
        world.add(new Rock());
        world.show();
    }
}