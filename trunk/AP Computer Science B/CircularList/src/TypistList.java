// File: TypistList.java
// Author: Justin Uang
// Date Started: September 18, 2007
// Date Completed: September 20, 2007
// Notes: Contains TypistList Definition. (Linked List)

public class TypistList extends Object  /*Obviously*/
{
    //Default Constructor
    //Creates an empty Linked List
    public TypistList ()
    {
        first = null;
        last = null;
    }

    //Constructor
    //Typist newTypist - typist to be put in linked list
    public TypistList (Typist newTypist)
    {
        first = new TypistNode(newTypist, null);
        last = first;
    }

    //Constructor
    //TypistList old - TypistList to be added to new List
    public TypistList(TypistList old)
    {
        addAll(old);
    }
    
    //Returns if linked list is empt
    public boolean isEmpty()
    {
        return first == null;
    }
    
    //Returns the size of the linked list
    public int size()
    {
        int counter = 0;
        TypistNode temp = first;
        while(temp != null)
        {
            counter++;
            temp = temp.getNext ();
        }
        return counter;
    }
    
    //Inserts a new Typist in the front of the list
    public void insertFront(Typist newTypist)
    {
        //if list is empty
        if (isEmpty())
        {
            first = new TypistNode(newTypist, null);
            last = first;
        }
        else
        {
            first = new TypistNode(newTypist, first);
        }
    }
    
    //Inserts a new Typist in the back of the list
    public void insertLast(Typist newTypist)
    {
        //if list is empty
        if (isEmpty())
        {
            first = new TypistNode(newTypist, last);
            last = first;
        }
        else
        {
            TypistNode oldTypist = last;
            last = new TypistNode(newTypist, null);
            oldTypist.setNext (last);
        }
    }
    
    //Inserts a new typist after an existing typist in list
    public boolean insertAfter(Typist newTypist, Typist following)
    {
        //If list is empty
        if (isEmpty())
        {
            first = new TypistNode(newTypist, last);
            last = first;
            return true;
        }
        else
        {
            TypistNode temp = first;
            while(temp != null)
            {
                if (temp.getValue () == following)
                {
                    temp.setNext (new TypistNode(newTypist, temp.getNext ()));
                    return true;
                }
                temp = temp.getNext();
            }
        }
        return false;
    }
    
    //Returns whether a typist is in the list
    public boolean contains(Typist checkedTypist)
    {
        TypistNode temp = first;
        while(temp != null)
        {
            if (temp.getValue () == checkedTypist)
            {
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }
    
    //Clears the linked list
    public void clear()
    {
        first = null;
        last = null;
    }
    
    //Adds the typists from an array to the end of the list
    public void addAll(Typist[] typists)
    {
        for(int i = 0; i < typists.length; i++)
        {
            if (typists[i] != null)
            {
                insertLast(typists[i]);
            }
        }
    }
    
    //Adds the typists in an existing list to the end of this list
    public void addAll(TypistList typists)
    {
        TypistNode oldListTemp = typists.getFirst ();
        while(oldListTemp != null)
        {
            insertLast(oldListTemp.getValue ());
            oldListTemp = oldListTemp.getNext();
        }
    }
    
    //Removes a Typist from the list and returns it
    public Typist remove(Typist removedTypist)
    {
        if (removedTypist == first.getValue ()) //if removing the first node
        {
            TypistNode oldFirst = first;
            first = first.getNext ();
            return oldFirst.getValue ();
        }
        else
        {
            TypistNode temp = first;
            while(temp != null)
            {
                TypistNode nextNode;
                nextNode = temp.getNext ();
                if (nextNode == last) //if removing the last node
                {
                    temp.setNext (null);
                    return last.getValue ();
                }
                
                if ((temp.getNext ()).getValue () == removedTypist)
                {
                    temp.setNext ((temp.getNext ()).getNext ());
                    return removedTypist;
                }
                temp = temp.getNext();
            }
        }
        return null;
    }
    
    //Prints everything in the list
    public void dump(){
        TypistNode temp = first;
        while(temp != null)
        {
            System.out.println (temp);
            temp = temp.getNext ();
        }
    }
    
    public static void main (String[] args)
    {
        TypistList theList = new TypistList();
        theList.insertFront(new Typist("Peter", 60, 60));
        theList.insertFront (new Typist("Last", 5, 5));
        theList.insertFront (new Typist("Jack", 5, 5));
        theList.insertFront (new Typist("John", 5, 5));
        theList.dump ();
    }
    
    public TypistNode getFirst ()
    {
        return first;
    }
    
    public void setFirst (TypistNode first)
    {
        this.first = first;
    }

    public TypistNode getLast ()
    {
        return last;
    }

    public void setLast (TypistNode last)
    {
        this.last = last;
    }
    
    protected TypistNode first;
    protected TypistNode last;
}