//  File: Typist.java
//  Author: Peter Tsoi
//  Date Started: September 17, 2007
//  Date Completed: September 20, 2007
//  Notes: Typist List Class and Methods Testing Class & Methods

public class TypistList
{
    public TypistNode first;        // First Node in List
    public TypistNode last;         // Last Node in List
    // Testing Class
    /*public static void main (String[] args)
    {
        TypistList myList = new TypistList();
        
        Typist allen = new Typist("Allen", 1, 0.0);
        Typist justin = new Typist("Justin", 50, 0.7);
        Typist peter = new Typist("Peter", 100, 1.0);
        Typist whitney = new Typist("Whitney", 25, 1.0);
        myList.insertFront(allen);
        myList.insertAfter(whitney, allen);
        myList.insertLast (peter);
        myList.insertAfter (justin, peter);
        myList.dump ();
        
        System.out.println ("\n\n");
        Typist[] newTypists = new Typist[3];
        Typist bob = new Typist("Bob", 1, 0.0);
        Typist joe = new Typist("Joe", 50, 0.7);
        Typist sam = new Typist("Sam", 100, 1.0);
        newTypists[0] = bob;
        newTypists[1] = joe;
        newTypists[2] = sam;
        myList.addAll (newTypists);
        //myList.insertLast (bob);
        myList.dump ();
        
        System.out.println ("\t\t");
        
    }*/
    
    // Default Constructor
    public TypistList ()
    {
        first = null;
        last = null;
    }
    
    // Single Typist Constructor
    public TypistList (Typist newTypist)
    {
        first = new TypistNode(newTypist, null);
        last = first;
    }
    
    // Copy TypistList Constructor
    public TypistList (TypistList oldTypistList)
    {
        first = oldTypistList.first;
        last = oldTypistList.last;
    }
    
    // Adds all the typists in an Array of typists to the end of the list
    public void addAll(Typist[] typist)
    {
        for (Typist newTypist: typist)
        {
            insertLast(newTypist);
        }
    }
    
    // Appends a typist list to the end of the current list
    public void addAll(TypistList typist)
    {
        TypistNode checkNode = typist.first;
        while (checkNode != null)
        {
            insertLast(checkNode.getObject ());
            checkNode = checkNode.nextNode ();
        }
    }
    
    // Checks if the list is empty
    public boolean isEmpty ()
    {
        if (first == null)
        {
            return true;
        }
        return false;
    }
    
    // Returns size of list
    public int size ()
    {
        TypistNode checkNode = first;
        int i = 0;
        while (checkNode != null)
        {
            i++;
            checkNode = checkNode.nextNode();
        }
        return i;
    }
    
    // Insert newTypist at first position
    public void insertFront(Typist newTypist)
    {
        // If the list is empty
        if (size() == 0)
        {
            first = new TypistNode(newTypist, null);
            last = first;
        } else 
        {
            first = new TypistNode(newTypist, first);
        }
    }
    
    // Insert newTypist at last position
    public void insertLast(Typist newTypist)
    {
        TypistDLNode checkNode = (TypistDLNode)first;
        /*last = new TypistNode(newTypist, null);
        // if there is only 1 element
        if (first == last)
        {
            first.setNewNextRef (last);
        } else 
        {*/
            //System.out.println(first.getName());
           /* while (checkNode.nextNode() != null)
            {
                checkNode = (TypistDLNode)checkNode.nextNode ();
            }
            checkNode.setNewNextRef (last);
        }*/
    }
    
    // Insert newTypist after prevTypist
    // Returns true if prevTypist is in list and adds newTypist
    // Returns false if prevTypist does not exist
    public boolean insertAfter(Typist newTypist, Typist prevTypist)
    {
        TypistNode checkNode = first;
        TypistNode temp;
        while (checkNode != null)
        {
            if (checkNode.getObject().getId() == prevTypist.getId())
            {
                if (checkNode.nextNode() == null)
                {
                    temp = new TypistNode(newTypist, null);
                    last = temp;
                } else
                {
                    temp = new TypistNode(newTypist, checkNode.nextNode());
                }
                checkNode.setNewNextRef (temp);
                return true;
            }
            checkNode = checkNode.nextNode();
        }
        return false;
    }
    
    // Removes a typist from the list
    public Typist remove (Typist toRemove) 
    {
        TypistNode checkNode = first;
        TypistNode removed;
        if (checkNode.getId () == toRemove.getId ())
        {
            if (size() != 1)
            {
                first = checkNode.nextNode ();
            } else 
            {
                last = null;
            }
            return checkNode.getObject ();
        }
        while (checkNode != null)
        {
            last = checkNode;
            if (checkNode.nextNode() != null)
            {
                if (checkNode.nextNode().getId() == toRemove.getId())
                {
                    removed = checkNode;
                    if (checkNode.nextNode() != null)
                    {
                        checkNode.setNewNextRef (null);
                    } else 
                    {
                        checkNode.setNewNextRef(checkNode.nextNode());
                    }
                    //System.out.println(checkNode.nextNode().getName ());
                    return removed.getObject ();
                }
            } 
            checkNode = checkNode.nextNode ();
        }
        return null;
    }
    
    // Clears the list
    public void clear ()
    {
        // Remove References (Trash Collector does the rest)
        first = null;
        last = null;
    }
    
    // Prints the values of the list
    public void dump ()
    {
        TypistNode checkNode = first;
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
    
    // Returns true if checkTypist is in the list
    private boolean contains(Typist checkTypist)
    {
        TypistNode checkNode = first;
        while (checkNode != null)
        {
            checkNode = checkNode.nextNode();
            if (checkTypist.getId() == checkNode.getId())
            {
                return true;
            }
        }
        return false;
    }
}
