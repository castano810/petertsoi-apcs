//  File: TypistDLList.java
//  Author: Peter Tsoi
//  Date Started: September 28, 2007
//  Date Completed: September 29, 2007
//  Notes: Main Method and Testing Class

public class TypistDLList extends TypistList
{
    // Default constructor; Casts previous first and last values to DLNodes
    public TypistDLList ()
    {
        first = (TypistDLNode)super.first;
        last = (TypistDLNode)super.last;
    }
    
    // Constructor; Single typist list
    public TypistDLList (Typist newTypist)
    {
        first = new TypistDLNode(newTypist, null, null);
        last = first;
    }
    
    // Main Method
    public static void main (String[] args)
    {
        TypistDLList myList = new TypistDLList();
        
        Typist allen = new Typist("Allen", 1, 0.0);
        Typist justin = new Typist("Justin", 50, 0.7);
        Typist peter = new Typist("Peter", 100, 1.0);
        Typist whitney = new Typist("Whitney", 25, 1.0);
        Typist sam = new Typist("Sam", 45, 2.0);
        //myList.insertFront(allen);
        //myList.insertAfter(whitney, allen);
        //myList.insertLast (peter);
        //myList.insertAfter (justin, peter);
        myList.insertLast (sam);
        //myList.deleteLast();
        //myList.deleteFront();
        myList.dump ();
        System.out.println(myList.size ());
        
    }
    
    // Insert newTypist at first position
    public void insertFront(Typist newTypist)
    {
        // If the list is empty
        if (size() == 0)
        {
            first = new TypistDLNode(newTypist, null, null);
            last = first;
        } else 
        {
            first = new TypistDLNode(newTypist, first, null);
        }
    }
    
    // Insert newTypist after prevTypist
    // Returns true if prevTypist is in list and adds newTypist
    // Returns false if prevTypist does not exist
    public boolean insertAfter(Typist newTypist, Typist prevTypist)
    {
        TypistDLNode checkNode = first;
        TypistDLNode temp;
        while (checkNode != null)
        {
            if (checkNode.getObject().getId() == prevTypist.getId())
            {
                if (checkNode.nextNode() == null)
                {
                    temp = new TypistDLNode(newTypist, null, checkNode);
                    last = temp;
                } else
                {
                    temp = new TypistDLNode(newTypist, checkNode.nextNode(), checkNode);
                }
                checkNode.setNewNextRef (temp);
                return true;
            }
            checkNode = checkNode.nextNode();
        }
        return false;
    }
    
    public int size ()
    {
        TypistDLNode checkNode = first;
        int i = 0;
        while (checkNode != null)
        {
            i++;
            checkNode = checkNode.nextNode ();
        }
        
        return i;
    }
    
    // Insert newTypist at last position
    public void insertLast(Typist newTypist)
    {
        TypistDLNode checkNode = first;
        last = new TypistDLNode(newTypist, null, null);
        // if there is only 1 element
        if (first == last)
        {
            first.setNewNextRef (last);
            last.setNewPrevRef(first);
        } else 
        {
            if (checkNode != null)
            {
                while (checkNode.nextNode () != null)
                {
                    checkNode = checkNode.nextNode ();
                    last.setNewPrevRef(checkNode.nextNode());
                }
                last.setNewPrevRef(checkNode);
                checkNode.setNewNextRef (last);
            } else 
            {
                first = last;
            }
        }
    }
    
    // Removes last node from list
    public void deleteLast()
    {
        if (first == last)
        {
            first = null;
            last = null;
        } else 
        {
            last.prevNode().setNewNextRef(null);
            last = last.prevNode();
        }
    }
    
    // Removes first node from list
    public void deleteFront()
    {
        if (first == last)
        {
            first = null;
            last = null;
        } else 
        {
            first.nextNode().setNewPrevRef(null);
            first = first.nextNode();
        }
    }
    
    // Returns the number of typists after input in list
    public int numAfter(Typist input)
    {
        TypistDLNode checkNode = first;
        int i = 0;
        while (checkNode != null)
        {
            if (checkNode.getId() == input.getId() || i > 0)
            {
                i++;
            }
            checkNode = checkNode.nextNode();
        }
        return i-1;
    }
    
    // Returns the number of typists before input in the list
    public int numBefore(Typist input)
    {
        TypistDLNode checkNode = last;
        int i = 0;
        while (checkNode != null)
        {
            if (checkNode.getId() == input.getId() || i > 0)
            {
                i++;
            }
            checkNode = checkNode.prevNode();
        }
        return i-1;
    }
    
    //  Dumps the contents of the list
    public void dump ()
    {
        TypistDLNode checkNode = first;
        while (checkNode != null)
        {
            System.out.print(checkNode.getName() + "\t");
            System.out.print(checkNode.getId() + "\t");
            System.out.print(checkNode.getwpm() + "\t");
            System.out.print(checkNode.getAccuracy() + "\t");
            System.out.println(checkNode.getSpeed());
            checkNode = checkNode.nextNode();
        }
    }
    
    // First and last nodes in the list
    protected TypistDLNode last;
    protected TypistDLNode first;
}

/*  Exer A
 *      1.  Array: n.   One needs to create a new array and loop through all existing
 *                      members and copy them to the new array
 *          Doubly Linked List: 1. One only needs to reassign two references 
 *                      (the "next" reference of the old list and the "previous"
 *                      reference of the new last item) and assign last to the new
 *                      last value.
 *          Stack: n:   Due to the FILO data orginization, one would need to extract 
 *                      all the data members then add the new item then re-stack 
 *                      all the data members that were "popped" off.
 *
 *      2.  Array: n.   One needs to create a new array and loop through all existing
 *                      members and copy them to the new array
 *          Doubly Linked List: 1. One only needs to reassign two references 
 *                      (the "previous" reference of the old list and the "next"
 *                      reference of the new first item) and assign first to the new
 *                      first value.
 *          Stack: 1:   Due to the FILO data orginization, one would only need to 
 *                      push the new item to the top of the stack
 *
 *      3.  Array: n.   One needs to delete the member and also copy all the members to a
 *                      new array with the corrected size
 *          Doubly Linked List: 1.  One only needs to delete the member and set the previous 
 *                      and next references that it previously had to the next and previous
 *                      members respectively.
 *          Stack: n.   One would need to pop all members out, delete the one needed, then
 *                      push all the members back into the stack
 *
 *      4.  Array: n.   One would need to loop through the array (starting from index = length)
 *                      and put all of those into a new array.
 *          Doubly Linked List: n. One would need to go through all members and swap the
 *                      previous and next references.
 *          Stack: n.   One would need to pop all the members to a new new stack which would then 
 *                      contain the reverse order.
 *
 *      5.  Array: n.   One would have to call the first member and then, to emulate a "pop", 
 *                      one would have to create a new array and loop and copy all members
 *                      to the new array.
 *          Doubly Linked List: 1.  One would only need to call the first item, then reassign 
 *                      the first node to the second node and reassign the second node's prev.
 *                      reference
 *          Stack: 1:   One would just need to call a "pop" and get that member.
 */