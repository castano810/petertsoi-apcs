// File: ListNode.java
// Author: Justin Uang
// Date Started: December 11, 2007
// Date Completed: December 11, 2007

public class ListNode <E> 
{
    public ListNode()
    {
        
    }
    
    public ListNode (E value, ListNode next)
    {
        this.value = value;
        this.next = next;
    }

    public E getValue ()
    {
        return value;
    }

    public void setValue (E value)
    {
        this.value = value;
    }

    public ListNode getNext ()
    {
        return next;
    }

    public void setNext (ListNode next)
    {
        this.next = next;
    }
    
    public String toString()
    {
        return value.toString ();
    }
    
    protected E value;
    protected ListNode next;
}
