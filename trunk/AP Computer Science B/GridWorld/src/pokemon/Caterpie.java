package pokemon;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import java.awt.Color;

public class Caterpie extends Pokemon
{
    public Caterpie()
    {
        super(Color.GREEN);
        setAttackPoints(10);
    }
    
    public void act()
    {
        Grid<Actor> gr = getGrid ();
        Actor neighbor = gr.get (getLocation().getAdjacentLocation (getDirection()));
        if (neighbor instanceof Weedle)
        {
            System.out.println("Attack Weedle");
            Pokemon opposingPokemon = (Pokemon) neighbor;
            opposingPokemon.takeDamage (5);
        }
    }
}
