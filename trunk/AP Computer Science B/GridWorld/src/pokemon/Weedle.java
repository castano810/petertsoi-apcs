package pokemon;
import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class Weedle extends Pokemon
{
    public Weedle()
    {
        super(Color.ORANGE);
        setAttackPoints(8);
        setHitPoints(15);
    }
    
    public void act()
    {
    }
}
