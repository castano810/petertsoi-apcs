//  File: sorts.java
//  Author: Peter Tsoi
//  Date Started: October 10, 2007
//  Date Completed: October 11, 2007
//  Notes: Java Sorting Class

public class sorts 
{  
    // Simple quicksort call
    // Requires complex quicksort call
    // int[] input = array of unsorted numbers
    // returns array of sorted numbers
    public static int[] quicksort (int[] input)
    {
        if (input.length > 1)
        {
            quicksort(input, 0, input.length-1);
        }
        return input;
    }
    
    // Complex quicksort call
    // int[] input = array of unsorted numbers
    // int small = index in array of a number smaller than pivot
    // int big = index in array of a number larger than pivot
    // returns array of sorted numbers
    public static int[] quicksort (int[] input, int small, int big)
    {
        int i = small;
        int j = big;
        int divider=input[(small+big)/2];
        do
        {    
            while (input[i]<divider) 
            {
                i++;
            } 
            while (input[j]>divider) 
            {
                j--;
            }
            if (i<=j)
            {
                int holder;
                holder=input[i]; 
                input[i]=input[j]; 
                input[j]=holder;
                i++; 
                j--;
            }
        } while (i<=j);
        if (small<j) 
        {
            quicksort(input, small, j);
        }
        if (i<big) 
        {
            quicksort(input, i, big);
        }
        return input;
    }
}
