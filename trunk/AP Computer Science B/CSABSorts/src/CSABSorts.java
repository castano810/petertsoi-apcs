//  File: CSABSorts.java
//  Author: Peter Tsoi
//  Date Started: October 8, 2007
//  Date Completed: October TBA, 2007
//  Notes: Main Method and Testing Class

public class CSABSorts
{
    public CSABSorts ()
    {
        
    }
    
    public static void sortTypistsbySpeed(TypistDLList inList, boolean ascending)
    {
        int size = inList.size (); 
        int min;
        TypistDLNode curTypist = inList.first;
        TypistDLNode jTypist = curTypist;
        TypistDLNode minTypist = jTypist;
        System.out.println (size);
        for (int i = 0; i < size - 1; i++)
        {
            System.out.println("hi");
            min = i;
            if (i>0)
            {
                curTypist = curTypist.nextNode ();
            }
               for (int j = i+1; j < size; j++)
               {
                    for (int k = 0; k<j; k++)
                    {
                        jTypist = jTypist.nextNode ();
                    }
                    for (int k = 0; k<min; k++)
                    {
                        minTypist = minTypist.nextNode ();
                    }
                    
                    if (ascending)
                    {
                        if (jTypist.getSpeed () < minTypist.getSpeed ())
                        {
                            min = j;
                        }
                    } 
                }
            swap(curTypist, minTypist);
        }
    }
    
    static void swap(TypistDLNode i, TypistDLNode min)
    {
        TypistDLNode iNext = i.nextNode ();
        TypistDLNode iPrev = i.prevNode ();
        TypistDLNode minNext = min.nextNode ();
        TypistDLNode minPrev = min.prevNode ();
        i.setNewNextRef (minNext);
        i.setNewPrevRef (minPrev);
        min.setNewNextRef (iNext);
        min.setNewPrevRef (iPrev);
    }
}
