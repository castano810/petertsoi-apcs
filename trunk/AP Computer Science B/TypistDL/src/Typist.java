//  File: Typist.java
//  Author: Peter Tsoi
//  Date Started: September 17, 2007
//  Date Completed: September 20, 2007
//  Notes: Typist Class and Methods

public class Typist
{
    public Typist (String inName, int inWpm, double inAccuracy)
    {
        name = inName;
        id = idKey;
        wpm = inWpm;
        accuracy = inAccuracy;
        speed = (0.5 * wpm) + (accuracy * wpm);
        
        idKey++;
    }
    
    public String getName ()
    {
        return name;
    }

    public int getId ()
    {
        return id;
    }

    public int getwpm ()
    {
        return wpm;
    }

    public double getAccuracy ()
    {
        return accuracy;
    }
    
    public double getSpeed ()
    {
        return speed;
    }
    
    private static int idKey = 1000;
    
    private String name;
    private int id;
    private int wpm;
    private double accuracy;
    private double speed;
}
