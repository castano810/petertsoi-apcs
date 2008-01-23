//  File: TypistNode.java
//  Author: Peter Tsoi
//  Date Started: September 17, 2007
//  Date Completed: September 20, 2007
//  Notes: Typist Node

public class TypistNode
{
    public TypistNode (Typist newTypist, TypistNode initNext)
    {
        object = newTypist;
        next = initNext;
    }
    
    // Moves to the next node in the list
    public TypistNode nextNode ()
    {
        return next;
    }
    
    // Sets new reference for the list
    public void setNewRef (TypistNode nextObj) 
    {
        next = nextObj;
    }
    
    // Returns the object in the node
    public Typist getObject(){
        return object;
    }
    
    // Returns the Name of the Typist
    public String getName ()
    {
        return object.getName();
    }
    
    // Returns the ID of the Typist 
    public int getId ()
    {
        return object.getId();
    }
    
    // Returns WPM of the Typist
    public int getwpm ()
    {
        return object.getwpm();
    }
    
    // Returns WPM of the Typist
    public double getAccuracy ()
    {
        return object.getAccuracy();
    }
    
    // Returns speed of the Typist
    public double getSpeed ()
    {
        return object.getSpeed();
    }
    
    private Typist object;          // Typist Object
    private TypistNode next;        // Reference to next node
}
