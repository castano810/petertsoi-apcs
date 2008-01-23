// File: TypistNode.java
// Author: Justin Uang
// Date Started: September 18, 2007
// Date Completed: September 20, 2007
// Notes: Contains Typist Node Class Definition

public class TypistNode extends Object  /*Obviously*/
{
    public TypistNode()
    {
        
    }
    
    //Constructor
    //Typist value - value to be stored in node
    //TypistNode next - reference to next node in linked list
    public TypistNode (Typist value, TypistNode next)
    {
        this.value = value;
        this.next = next;
    }

    public Typist getValue ()
    {
        return value;
    }

    public void setValue (Typist value)
    {
        this.value = value;
    }

    public TypistNode getNext ()
    {
        return next;
    }

    public void setNext (TypistNode next)
    {
        this.next = next;
    }
    
    public String toString()
    {
        return value.toString ();
    }
    
    protected Typist value;
    protected TypistNode next;
}
