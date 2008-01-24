// File: LinkedList.java
// Authors: Peter Tsoi & Justin Uang
// Generic Linked List

public class LinkedList <E> {
    public LinkedList (){
        first = null;
        last = null;
    }

    public LinkedList (E newObject){
        first = new ListNode(newObject, null);
        last = first;
    }

    public LinkedList(LinkedList old){
        addAll(old);
    }
    
    public boolean isEmpty(){
        return first == null;
    }
    
    public int size(){
        int counter = 0;
        ListNode temp = first;
        while(temp != null)
        {
            counter++;
            temp = temp.getNext ();
        }
        return counter;
    }
    
    public void insertFront(E newObject){
        //if list is empty
        if (isEmpty())
        {
            first = new ListNode(newObject, last);
            last = first;
        }
        else
        {
            first = new ListNode(newObject, first);
        }
    }
    
    public void insertLast(E newObject){
        //if list is empty
        if (isEmpty())
        {
            first = new ListNode(newObject, last);
            last = first;
        }
        else
        {
            ListNode oldTypist = last;
            last = new ListNode(newObject, null);
            oldTypist.setNext (last);
        }
    }
    
    public boolean insertAfter(E newObject, E following){
        boolean isSuccessful = false;
        //If list is empty
        if (isEmpty())
        {
            first = new ListNode(newObject, last);
            last = first;
            isSuccessful = true;
        }
        else
        {
            ListNode temp = first;
            while(temp != null)
            {
                if (temp.getValue () == following)
                {
                    temp.setNext (new ListNode(newObject, temp.getNext ()));
                    isSuccessful = true;
                }
                temp = temp.getNext();
            }
        }
        return isSuccessful;
    }
    
    public boolean contains(E checkedObject){
        boolean doesContain = false;
        
        ListNode temp = first;
        while(temp != null)
        {
            if (temp.getValue () == checkedObject)
            {
                doesContain = true;
            }
            temp = temp.getNext();
        }
        return doesContain;
    }
    
    public void clear(){
        first = null;
        last = null;
    }
    
    public void addAll(E[] objects){
        for(int i = 0; i < objects.length; i++)
        {
            if (objects[i] != null)
            {
                insertLast(objects[i]);
            }
        }
    }
    
    public void addAll(LinkedList objects){
        ListNode<E> oldListTemp = objects.getFirst ();
        while(oldListTemp != null)
        {
            insertLast(oldListTemp.getValue ());
            oldListTemp = oldListTemp.getNext();
        }
    }
    
    public E remove(E removedTypist){
        if (removedTypist == first.getValue ()) //if removing the first node
        {
            ListNode<E> oldFirst = first;
            first = first.getNext ();
            return oldFirst.getValue ();
        }
        else
        {
            ListNode temp = first;
            while(temp != null)
            {
                ListNode<E> nextNode;
                nextNode = temp.getNext ();
                if (nextNode == last) //if removing the last node
                {
                    temp.setNext (null);
                    last = temp;
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
    
    public void dump(){
        ListNode temp = first;
        while(temp != null)
        {
            System.out.println (temp);
            temp = temp.getNext ();
        }
    }
    
    public static void main (String[] args)
    {
        LinkedList theList = new LinkedList();
        theList.dump ();
    }
    
    public ListNode getFirst ()
    {
        return first;
    }
    
    public void setFirst (ListNode first)
    {
        this.first = first;
    }

    public ListNode getLast ()
    {
        return last;
    }

    public void setLast (ListNode last)
    {
        this.last = last;
    }
    
    
    private ListNode<E> first;
    private ListNode<E> last;
}