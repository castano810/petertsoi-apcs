//  File: main.java
//  Author: Peter Tsoi
//  Date Started: October 10, 2007
//  Date Completed: October 11, 2007
//  Notes: Testing Class

public class main 
{
    public static void main(String[] args) 
    {
        int[] randomArray = {37,2,6,4,89,8,10,12,68,45};
        for (int i: randomArray)
        {
            System.out.print(i + ",");
        }
        System.out.println();
        randomArray = sorts.quicksort(randomArray);
        for (int i: randomArray)
        {
            System.out.print(i + ",");
        }
        System.out.println();
    }   
}
