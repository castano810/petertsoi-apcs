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

public abstract class Pokemon extends Bug
{
    private int speedPoints, hitPoints, accuracyPoints, defensePoints, attackPoints;
    private int levelPoints;
    private boolean correctInit = false;
    private boolean stopCheaters;
    private int currentTurn, currentTurnCheat;
//    protected int[] attackPower, accuracyPower;
    
    public Pokemon (Color color)
    {
        setColor(color);
        correctInit = true;
        
        levelPoints = 50;
    }
    
    public Pokemon()
    {
        super();
    }
    
    public static boolean stopCheaters(Pokemon poke)
    {
        
        if (!poke.correctInit)
        {
            return false;
        }
        
        if (poke.speedPoints + poke.hitPoints + poke.accuracyPoints + poke.defensePoints + poke.attackPoints > poke.levelPoints)
        {
            return false;
        }
        
        return true;
    }
    
    public void takeDamage(int damage)
    {
        hitPoints -= damage;
        System.out.println (this);
    }
    
    public int getSpeedPoints ()
    {
        return speedPoints;
    }

    public void setSpeedPoints (int speedPoints)
    {
        if (speedPoints > 0)
        {
            if (speedPoints + hitPoints + accuracyPoints + defensePoints + attackPoints <= levelPoints)
            {
                this.speedPoints = speedPoints;
            }
        }
    }

    public int getHitPoints ()
    {
        return hitPoints;
    }

    public void setHitPoints (int hitPoints)
    {
        if (hitPoints > 0)
        {
            if (speedPoints + hitPoints + accuracyPoints + defensePoints + attackPoints <= levelPoints)
            {
                this.hitPoints = hitPoints;
            }
        }
    }

    public int getAccuracyPoints ()
    {
        return accuracyPoints;
    }

    public void setAccuracyPoints (int accuracyPoints)
    {
        if (accuracyPoints > 0)
        {
            if (speedPoints + hitPoints + accuracyPoints + defensePoints + attackPoints <= levelPoints)
            {
                this.accuracyPoints = accuracyPoints;
            }
        }
    }

    public int getDefensePoints ()
    {
        return defensePoints;
    }

    public void setDefensePoints (int defensePoints)
    {
        if (defensePoints > 0)
        {
            if (speedPoints + hitPoints + accuracyPoints + defensePoints + attackPoints <= levelPoints)
            {
                this.defensePoints = defensePoints;
            }
        }
    }

    public int getAttackPoints ()
    {
        return attackPoints;
    }

    public void setAttackPoints (int attackPoints)
    {
        if (attackPoints > 0)
        {
            if (speedPoints + hitPoints + accuracyPoints + defensePoints + attackPoints <= levelPoints)
            {
                this.attackPoints = attackPoints;
            }
        }
    }

    public int getLevelPoints ()
    {
        return levelPoints;
    }
    
    public String toString()
    {
        String returnString = "";
        returnString += "HP: " + hitPoints + "\t\n";
        returnString += "Speed Points: " + speedPoints + "\t\n";
        returnString += "Accuracy Points: " + accuracyPoints + "\t\n";
        returnString += "Defense Points: " + defensePoints + "\t\n";
        returnString += "Attack Points: " + attackPoints + "\t\n";
        
        return returnString;
    }
}
