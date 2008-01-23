//  File: TypistNode.java
//  Author: Peter Tsoi
//  Date Started: September 28, 2007
//  Date Completed: September 29, 2007
//  Notes: Typist DOUBLE LINKED Node

public class TypistDLNode extends TypistNode
{
    public TypistDLNode (Typist newTypist, TypistNode initNext, TypistNode initPrev)
    {
        super(newTypist, initNext);
        prev = (TypistDLNode)initPrev;
    }
    
    public TypistDLNode prevNode ()
    {
        return prev;
    }
    
    public void setNewPrevRef (TypistNode prevObj) 
    {
        prev = (TypistDLNode)prevObj;
    }
    
    private TypistDLNode prev;
}
