//  File: SquareSearch.java
//  Author: Peter Tsoi
//  Date Started: September 12, 2007
//  Date Completed: September 12, 2007
//  Notes: SqareSearch Class and Methods

package squares;
public class SquareSearch
{
    int counter = 0;
    public SquareSearch (int in)
    {
        int theSquare = in*in;
        // Recursive Init.
        counter = 1;
        System.out.println(recursiveReduce (theSquare, 1));
        // Loop Init.
        counter = 0;
        System.out.println(loopReduce(theSquare));
        // Exer 06 Call Statement
        System.out.println(newtonRoot(theSquare));
    }
    // Start Exer 01
    int recursiveReduce (int in, int last)
    {
        if (in - last > 0)
        {
            counter++;
            recursiveReduce(in-last, last+2);
        } 
        return counter;
        
    }
    int loopReduce (int in)
    {
        int last = -1;
        for (int eval = in; eval > 0; eval = eval-last)
        {
            counter++;
            last = last + 2;
        }
        return counter;
    }
    // End Exer 01
    // Start Exer 05
    int getRoot(int in){
        counter = 0;
       return recursiveReduce(in, 1); 
    }
    // End Exer 05
    // Start Exer 06
    // Newton / Babylonian Method
    // Formula: 
    // x = 0.5(x + (A/x))
    // Repeat until desired precision is acquired
    int newtonRoot (int in)
    {
        int precision = in%10;
        double square = (double)in;
        double x = Math.pow(3, precision);
        for (int i = 0; i < precision; i++)
        {
            x = 0.5 * (x + (square/x));
        }
        return (int)x;
    }
}

/*  Exer 02:
 *      It requires N subtractions to return to 0. This number is the same as
 *      the square root of the squared number and is also equal to the input 
 *      value.
 *  Exer 03:
 *      Recursive. Its more elegant and requires less lines of code.
 *  Exer 04:
 *      The sum of a series of consecutive odd integers is a perfect square,
 *      therefore, if the number does not subtract and become zero, then it is 
 *      not a perfect square.
 *  Exer 06: Newton / Babylonian Method (See Above)
 *  Exer 07:
 *      To identify a perfect square, square a number "x" (starting with 1) and 
 *      check if it is greater than the number that is being checked ("a"). If 
 *      it is less, then increase "x" by one and try again. Do this until it 
 *      equals or is greater than "a". If it becomes equal to "a", then "a" is a
 *      perfect sqaure, if it is greater, then it is not.
 */