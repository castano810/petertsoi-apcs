public class CircularList extends TypistList
{
    //Default Constructor
    //Creates an empty Linked List
    public CircularList ()
    {
        super();
    }

    //Constructor
    //Typist newTypist - typist to be put in linked list
    public CircularList (Typist newTypist)
    {
        super(newTypist);
    }

    //Constructor
    //CircularLinkedList old - TypistList to be added to new List
    public CircularList(TypistList old)
    {
        super(old);
    }
    
    //Inserts a new Typist in the front of the list
    public void insertFront(Typist newTypist)
    {
        //if list is empty
        if (isEmpty())
        {
            setFirst(new TypistNode(newTypist, null));
            getFirst().setNext (getFirst());
            setLast(getFirst());
        }
        else
        {
            setFirst(new TypistNode(newTypist, getFirst()));
        }
    }
    
    //Inserts a new Typist in the back of the list
    public void insertLast(Typist newTypist)
    {
        //if list is empty
        if (isEmpty())
        {
            setFirst(new TypistNode(newTypist, null));
            getFirst().setNext (getFirst());
            setLast(getFirst());
        }
        else
        {
            TypistNode oldTypist = last;
            last = new TypistNode(newTypist, first);
            oldTypist.setNext (last);
        }
    }
    
    //Inserts a new typist after an existing typist in list
    public boolean insertAfter(Typist newTypist, Typist following)
    {
        //If list is empty
        if (isEmpty())
        {
            setFirst(new TypistNode(newTypist, null));
            getFirst().setNext (getFirst());
            setLast(getFirst());
            return true;
        }
        else
        {
            TypistNode temp = first;
            while(temp != null)
            {
                if (temp.getValue () == following)
                {
                    if (temp.getNext () == getLast())
                    {
                        insertLast(following);
                    }
                    else
                    {
                        temp.setNext (new TypistNode(newTypist, temp.getNext ()));
                    }
                    return true;
                }
                temp = temp.getNext();
            }
        }
        return false;
    }
    
//    public boolean checkOneIteration(Typist nextTypist)
//    {
//        if (nextTypist)
//    }
    
    //Removes a Typist from the list and returns it
    public Typist remove(Typist removedTypist)
    {
        if (removedTypist == first.getValue ()) //if removing the first node
        {
            TypistNode oldFirst = first;
            first = first.getNext ();
            last.setNext (first);
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
                    temp.setNext (first);
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
    
    public static int countMerryWidow()
    {
        CircularList passengers = initializeMerryWidowList();
        
        int currentN = 1;
        int finalNum = -1;
        while(finalNum == -1)
        {
            TypistNode currentNode = passengers.getFirst();
            boolean continueRemoving = true;
            for (int removeCount = 0; removeCount <= 15 && continueRemoving; removeCount++)
            {
                if (removeCount == 15)
                {
                    finalNum = currentN;
                }
                
                for (int i = 1; i < currentN; i++)
                {
                    currentNode = currentNode.getNext ();
                }
                
                String removeCandidateName = currentNode.getValue ().getName ();
                if (removeCandidateName.charAt (0) == 'X')
                {
                    Typist remove = currentNode.getValue ();
                    currentNode = currentNode.getNext();
                    passengers.remove(remove);
                }
                else
                {
                    continueRemoving = false;
                }
            }
            passengers = initializeMerryWidowList();
            currentN++;
        }
        return finalNum;
    }
    
    private static CircularList initializeMerryWidowList()
    {
        CircularList passengers = new CircularList();
        passengers.insertLast (new Typist("O.1", 1, 2));
        passengers.insertLast (new Typist("O.2", 1, 2));
        passengers.insertLast (new Typist("O.3", 1, 2));
        passengers.insertLast (new Typist("O.4", 1, 2));
        passengers.insertLast (new Typist("O.5", 1, 2));
        passengers.insertLast (new Typist("X.1", 1, 2));
        passengers.insertLast (new Typist("X.2", 1, 2));
        passengers.insertLast (new Typist("X.3", 1, 2));
        passengers.insertLast (new Typist("X.4", 1, 2));
        passengers.insertLast (new Typist("O.6", 1, 2));
        passengers.insertLast (new Typist("O.7", 1, 2));
        passengers.insertLast (new Typist("X.5", 1, 2));
        passengers.insertLast (new Typist("X.6", 1, 2));
        passengers.insertLast (new Typist("O.8", 1, 2));
        passengers.insertLast (new Typist("X.7", 1, 2));
        passengers.insertLast (new Typist("O.9", 1, 2));
        passengers.insertLast (new Typist("O.10", 1, 2));
        passengers.insertLast (new Typist("X.8", 1, 2));
        passengers.insertLast (new Typist("O.11", 1, 2));
        passengers.insertLast (new Typist("X.9", 1, 2));
        passengers.insertLast (new Typist("O.12", 1, 2));
        passengers.insertLast (new Typist("X.10", 1, 2));
        passengers.insertLast (new Typist("X.11", 1, 2));
        passengers.insertLast (new Typist("O.13", 1, 2));
        passengers.insertLast (new Typist("X.12", 1, 2));
        passengers.insertLast (new Typist("X.13", 1, 2));
        passengers.insertLast (new Typist("O.14", 1, 2));
        passengers.insertLast (new Typist("O.15", 1, 2));
        passengers.insertLast (new Typist("X.14", 1, 2));
        passengers.insertLast (new Typist("X.15", 1, 2));
        
        return passengers;
    }
    
    public static void main(String[] args)
    {
        System.out.println("Magic Number: " + countMerryWidow());
    }
    
    private int iterationCounter = 0;
}