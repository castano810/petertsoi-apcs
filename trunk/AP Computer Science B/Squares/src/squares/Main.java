//  File: Main.java
//  Author: Peter Tsoi
//  Date Started: September 12, 2007
//  Date Completed: September 12, 2007
//  Notes: Main Method and Testing Class

package squares;
public class Main
{
    public Main ()
    {
    }
    public static void main (String[] args)
    {
        SquareSearch mySquare = new SquareSearch(24);
        System.out.println(mySquare.getRoot(50));
    }
    
}
