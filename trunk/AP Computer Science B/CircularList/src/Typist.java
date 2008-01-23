// File: Typist.java
// Author: Justin Uang
// Date Started: September 18, 2007
// Date Completed: September 20, 2007
// Notes: Contains Typist Class Definition

public class Typist extends Object  /*Obviously*/
{
    //Contains identifier that is incremented each time
    private static int nextIdentifier = 1001;
    
    //Default Constructor
    //String name - name of user
    //int rawWordsPerMin - Raw Words Per minute of user
    //int accuracy - user's accuracy
    public Typist (String name, int rawWordsPerMin, double accuracy)
    {
        this.name = name;
        this.identifier = Typist.nextIdentifier;
        Typist.nextIdentifier++;
        this.rawWordsPerMin = rawWordsPerMin;
        this.accuracy = accuracy;
    }
    
    public double getTrueSpeed()
    {
        return 0.5 * rawWordsPerMin + accuracy * rawWordsPerMin;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

/* RLB
*/
    public int getID()
        {
        return getIdentifier();
        }    

    public int getIdentifier ()
    {
        return identifier;
    }

    public void setIdentifier (int identifier)
    {
        this.identifier = identifier;
    }

    public int getRawWordsPerMin ()
    {
        return rawWordsPerMin;
    }

    public void setRawWordsPerMin (int rawWordsPerMin)
    {
        this.rawWordsPerMin = rawWordsPerMin;
    }

    public double getAccuracy ()
    {
        return accuracy;
    }

    public void setAccuracy (double accuracy)
    {
        this.accuracy = accuracy;
    }
    
    //Returns a string that represents the users
    //return - conatins info about user;
    public String toString()
    {
        String returnString = "";
        returnString = "Name: " + getName() + "\tIdentifier: " + 
                           getIdentifier() + "\tRaw Words Per Min: " +
                           getRawWordsPerMin() + "\tAccuracy: " +
                           getAccuracy() + "\tTrue Speed: " + getTrueSpeed();
        return returnString;
    }
    
    private String name;
    private int identifier;
    private int rawWordsPerMin;
    private double accuracy;
}
