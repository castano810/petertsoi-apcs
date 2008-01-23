//  File: Main.java
//  Author: Peter Tsoi
//  Date Started: September 14, 2007
//  Date Completed: September TBD, 2007
//  Notes: Testing Class and Main Method

package factoringarray;
public class Main
{
    public Main ()
    {
    }
    public static void main (String[] args)
    {
        Array2D2Primes thing = new Array2D2Primes(5, 10);
        thing.dump ();
        System.out.println(thing.test());
    }
    
}
